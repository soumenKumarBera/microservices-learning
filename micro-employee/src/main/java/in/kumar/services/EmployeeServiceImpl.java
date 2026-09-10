package in.kumar.services;

import in.kumar.dto.EmployeeDto;
import in.kumar.entities.Employee;
import in.kumar.payload.ApiResponse;
import in.kumar.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;


    @Override
    public ApiResponse<Employee> saveEmployee(EmployeeDto employeeDto) {



        return null;
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
