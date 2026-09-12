package in.kumar.services;

import in.kumar.dto.AccountDto;
import in.kumar.entities.Account;
import in.kumar.payload.ApiResponse;

import java.util.List;

public interface AccountServices {


    ApiResponse<Account> saveAccount(AccountDto accountDto);

    ApiResponse<List<Account>> getAllAccount();

    ApiResponse<Account> getSingleAccount(String id);
}
