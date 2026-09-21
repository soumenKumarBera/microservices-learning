package in.kumar.controller;

import in.kumar.dto.AccountDto;
import in.kumar.entities.Account;
import in.kumar.payload.ApiResponse;
import in.kumar.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountMainController {

    @Autowired
    private AccountServices accountServices;

    @PostMapping
    public ResponseEntity<ApiResponse<Account>> saveEmployee(@Valid @RequestBody AccountDto accountDto){
        ApiResponse<Account> savedAccountResponse = accountServices.saveAccount(accountDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAccountResponse);

    }

//    getAllAccount
    @GetMapping
    public ResponseEntity<ApiResponse<List<Account>>> getAllEmployee(){
        ApiResponse<List<Account>> allAccountResponse = accountServices.getAllAccount();
        return ResponseEntity.ok(allAccountResponse);
    }

    //getSingleAccount

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Account>> getSingleEmployee(@PathVariable String id){
        ApiResponse<Account> singleAccountResponse = accountServices.getSingleAccount(id);
        return ResponseEntity.ok(singleAccountResponse);
    }




}
