package in.kumar.controller;

import in.kumar.dto.EmployeeDto;
import in.kumar.entities.Employee;
import in.kumar.payload.ApiResponse;
import in.kumar.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //save

    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto){
       ApiResponse<Employee> savedEmployeeResponse = employeeService.saveEmployee(employeeDto);
       return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployeeResponse);



    }
    //getAllEmployee
    //getSingleEmployee
}
