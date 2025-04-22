package com.bankingApp.serviceImpl;

import com.bankingApp.dto.AccountDto;
import com.bankingApp.exception.AccountNotFoundException;
import com.bankingApp.model.Account;
import com.bankingApp.repository.AccountRepository;
import com.bankingApp.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account mapAccount=this.modelMapper.map(accountDto, Account.class);
        Account saveAccount=this.accountRepository.save(mapAccount);
        return this.modelMapper.map(saveAccount,AccountDto.class);
    }

    @Override
    public AccountDto getAccount(Long id) {
      Account getAccById=this.accountRepository.findById(id).orElseThrow(()->
                new AccountNotFoundException("This Account Not Existing"));
      return this.modelMapper.map(getAccById, AccountDto.class);
    }

    @Override
    public AccountDto depositeBalance(Long id, double amount) {
        Account getAcc=this.accountRepository.findById(id).orElseThrow(()->
                new AccountNotFoundException("This Account Not Existing"));

        double totalBalance=getAcc.getBalance()+amount;
        getAcc.setBalance(totalBalance);

        Account updateBalance=this.accountRepository.save(getAcc);
        return this.modelMapper.map(updateBalance, AccountDto.class);
    }

    @Override
    public AccountDto withdrawBalance(Long id, double amount) {
        Account getAcc=this.accountRepository.findById(id).orElseThrow(()->
                new AccountNotFoundException("This Account Not Existing"));

        //condition
        if(getAcc.getBalance()<amount){

            throw new RuntimeException("Balance not sufficient");
        }

        double totalBalance=getAcc.getBalance()-amount;
        getAcc.setBalance(totalBalance);

        Account updateBalance=this.accountRepository.save(getAcc);
        return this.modelMapper.map(updateBalance, AccountDto.class);
    }


    @Override
    public List<AccountDto> getAllAccount() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account)->
                modelMapper.map(account, AccountDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteAcccount(Long id) {

     Account getAcc=this.accountRepository.findById(id).orElseThrow(()->
                new AccountNotFoundException("User Account not existing by their id"));

    accountRepository.deleteById(id);
    }


}
