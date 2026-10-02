package in.kumar.clicent;

import in.kumar.entities.Account;
import in.kumar.external.EmployResponse;
import in.kumar.payload.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(
//        name = "micro-employee",
//        url = "http://localhost:8081/api/employees"
//)
@FeignClient("MICRO-EMPLOYEE")
public interface EmployeeClient {

    @GetMapping("/api/employees/{id}")
    public ResponseEntity<ApiResponse<EmployResponse>> getSingleEmployee(@PathVariable String id);




}
