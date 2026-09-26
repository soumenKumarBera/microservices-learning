package in.kumar.services;

import in.kumar.dto.AccountDto;
import in.kumar.entities.Account;
import in.kumar.exception.DuplicateResourceNotFoundException;
import in.kumar.exception.ResourceNotFoundException;
import in.kumar.payload.ApiResponse;
import in.kumar.repository.AccountRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
public class AccountServicesImp implements AccountServices{

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ApiResponse<Account> saveAccount(AccountDto accountDto) {

        // CHECK  THIS ACCOUNT  ARE DUPLICATE
        if(accountRepo.findByAccNo(accountDto.getAccNo()).isPresent()){

            throw  new DuplicateResourceNotFoundException("DUPLICATE RESOURCE FOUND EXCEPTION...");
        }

        Account account =  modelMapper.map(accountDto, Account.class); // this work one object to convert another object

        account.setId(UUID.randomUUID().toString());
        account.setDatetime(LocalDateTime.now().toString());

        Account saveAccount = accountRepo.save(account);

        return new ApiResponse<>("Success", "Account data create", saveAccount);


    }

    @Override
    public ApiResponse<List<Account>> getAllAccount() {
        List<Account> allAccount = accountRepo.findAll();

        if (allAccount.isEmpty()){
            return new ApiResponse<>("SUCCESS", "ACCOUNT DATA NOT FOUND",allAccount);
        }

        return new ApiResponse<>("SUCCESS", "ACCOUNT DATA FOUND",allAccount);
    }

    @Override
    public ApiResponse<Account> getSingleAccount(String id) {

        Account singleAccount = accountRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("ACCOUNT NOT FOUND WITH ID: " +id ));


        return new ApiResponse<>("SUCCESS", "SINGLE ACCOUNT DATA FOUND", singleAccount );
    }
}
