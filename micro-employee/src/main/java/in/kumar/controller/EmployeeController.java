package in.kumar.controller;

import in.kumar.dto.EmployeeDto;
import in.kumar.entities.Employee;
import in.kumar.payload.ApiResponse;
import in.kumar.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    @GetMapping
    public ResponseEntity<ApiResponse<List<Employee>>> getAllEmployee(){
        ApiResponse<List<Employee>> allEmployeeResponse = employeeService.getAllEmployees();
        return ResponseEntity.ok(allEmployeeResponse);
    }

    //getSingleEmployee

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> getSingleEmployee(@PathVariable String id){
        ApiResponse<Employee> singleEmployeeResponse = employeeService.getSingleEmployee(id);
        return ResponseEntity.ok(singleEmployeeResponse);
    }
}
