package com.bankingApp.MapperConvert;

import com.bankingApp.dto.AccountDto;
import com.bankingApp.model.Account;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class MapperConvertable {

    @Autowired
    public ModelMapper modelMapper;

    //Convert AccountDto to Account
    public Account mapToAccount(AccountDto accountDto){
       Account  account = this.modelMapper.map(accountDto, Account.class);
       return account;
     }


    //Convert Account to AccountDto
    public AccountDto mapToAccountDto(Account account){
        AccountDto  accountDto = this.modelMapper.map(account, AccountDto.class);
        return accountDto;
    }




}
