package in.kumar.services;

import in.kumar.dto.AccountDto;
import in.kumar.entities.Account;
import in.kumar.payload.ApiResponse;

import java.util.List;

public class AccountServicesImp implements AccountServices{
    @Override
    public ApiResponse<Account> saveAccount(AccountDto accountDto) {
        return null;
    }

    @Override
    public ApiResponse<List<Account>> getAllAccount() {
        return null;
    }

    @Override
    public ApiResponse<Account> getSingleAccount(String id) {
        return null;
    }
}
