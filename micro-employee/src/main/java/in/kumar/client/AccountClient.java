package in.kumar.client;

import in.kumar.external.AccountDto;
import in.kumar.external.AccountResponse;
import in.kumar.payload.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient("MICRO-ACCOUNT")
public interface AccountClient {

    @PostMapping("/api/account")
    public ResponseEntity<ApiResponse<AccountResponse>> saveAccount(@Valid @RequestBody AccountDto accountDto);

    @DeleteMapping("/api/account/{id}")
    public ResponseEntity<ApiResponse<Object>> accountDataDeleted(@PathVariable String id);
}
