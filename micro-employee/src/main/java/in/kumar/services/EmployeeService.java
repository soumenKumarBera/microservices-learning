package in.kumar.services;

import in.kumar.dto.EmployeeDto;
import in.kumar.dto.hybrid.EmployeeFullDto;
import in.kumar.entities.Employee;
import in.kumar.payload.ApiResponse;

import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;
import java.util.List;

public interface EmployeeService {


    ApiResponse<Employee> saveEmployee(EmployeeDto employeeDto);

    ApiResponse<List<Employee>> getAllEmployees();

    ApiResponse<Employee> getSingleEmployee(String id);

    ApiResponse<Employee> getFullEmployee(@Valid EmployeeFullDto employeeFullDto);

    ApiResponse<Object> employDataDeleted(String id);
}
