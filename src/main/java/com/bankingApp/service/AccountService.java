package com.bankingApp.service;

import com.bankingApp.dto.AccountDto;
import lombok.Lombok;

import java.util.List;

public interface AccountService {

    public AccountDto createAccount(AccountDto accountDto);

    public AccountDto getAccount(Long id);

    public AccountDto depositeBalance(Long id , double amount);

    public AccountDto withdrawBalance(Long id,double amount);

    public List<AccountDto> getAllAccount();

    public void deleteAcccount(Long id);
}
