package in.kumar.services;

import in.kumar.client.AccountClient;
import in.kumar.client.PlotClient;
import in.kumar.dto.EmployeeDto;
import in.kumar.dto.hybrid.EmployeeFullDto;
import in.kumar.entities.Employee;
import in.kumar.exception.ResourceNotFoundException;
import in.kumar.external.AccountDto;
import in.kumar.external.PlotDto;
import in.kumar.payload.ApiResponse;
import in.kumar.repositories.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private PlotClient plotClient;

    @Override
    public ApiResponse<Employee> saveEmployee(EmployeeDto employeeDto) {

      Employee employee =  modelMapper.map(employeeDto, Employee.class); // this work one object to convert another object

        employee.setId(UUID.randomUUID().toString());
        employee.setDatetime(LocalDateTime.now().toString());

        Employee saveEmployee = employeeRepo.save(employee);

        return new ApiResponse<>("Success", "Employee data create", saveEmployee);

    }

    @Override
    public ApiResponse<List<Employee>> getAllEmployees() {

        List<Employee> allEmployee = employeeRepo.findAll();

        if (allEmployee.isEmpty()){
            return new ApiResponse<>("SUCCESS", "EMPLOYEE DATA NOT FOUND",allEmployee);
        }

        return new ApiResponse<>("SUCCESS", "EMPLOYEE DATA FOUND",allEmployee);
    }

    @Override
    public ApiResponse<Employee> getSingleEmployee(String id) {

      Employee singleEmployee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("EMPLOYEE NOT FOUND WITH ID: " +id ));


        return new ApiResponse<>("SUCCESS", "SINGLE EMPLOYEE DATA FOUND", singleEmployee );
    }

    @Override
    public ApiResponse<Employee> getFullEmployee(EmployeeFullDto employeeFullDto) {

        //employ-->Save
        ApiResponse<Employee> employeeApiResponse =  saveEmployee(employeeFullDto.getEmployeeDto());
        Employee saveEmploy = employeeApiResponse.getData();


        //account-->save

        AccountDto accountDto = employeeFullDto.getAccountDto();
        accountDto.setEmployeeId(employeeApiResponse.getData().getId());
        accountClient.saveAccount(accountDto);



        //plot-->save

      PlotDto plotDto = employeeFullDto.getPlotDto();
      plotDto.setEmployeeId(employeeApiResponse.getData().getId());
        plotClient.savePlot(plotDto);




        return new ApiResponse<>("SUCCESS", "EMPLOYEE FULL DATA SAVED SUCCESSFULLY", saveEmploy);
    }
}
