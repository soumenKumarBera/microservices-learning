package in.kumar.services;

import in.kumar.dto.EmployeeDto;
import in.kumar.entities.Employee;
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


    @Override
    public ApiResponse<Employee> saveEmployee(EmployeeDto employeeDto) {

      Employee employee =  modelMapper.map(employeeDto, Employee.class); // this work one object to convert another object

        employee.setId(UUID.randomUUID().toString());
        employee.setDatetime(LocalDateTime.now().toString());

        Employee saveEmployee = employeeRepo.save(employee);

        return new ApiResponse<>("Success", "Employee data create", saveEmployee);
    }

    @Override
    public ApiResponse<List<Entity>> getAllEmployees() {
        return null;
    }

    @Override
    public ApiResponse<Employee> getSingleEmployee(String id) {
        return null;
    }
}
