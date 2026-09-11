package in.kumar.services;

import in.kumar.dto.EmployeeDto;
import in.kumar.entities.Employee;
import in.kumar.payload.ApiResponse;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface EmployeeService {


    ApiResponse<Employee> saveEmployee(EmployeeDto employeeDto);

    ApiResponse<List<Employee>> getAllEmployees();

    ApiResponse<Employee> getSingleEmployee(String id);

}
