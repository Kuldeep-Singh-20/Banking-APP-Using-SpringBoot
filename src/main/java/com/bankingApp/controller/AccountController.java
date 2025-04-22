package com.bankingApp.controller;

import com.bankingApp.dto.AccountDto;
import com.bankingApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountController {


    @Autowired
    private AccountService accountService;

    @PostMapping("/save")
    public ResponseEntity<AccountDto> saveAccount(@RequestBody  AccountDto accountDto){
      AccountDto saveAcc=accountService.createAccount(accountDto);
      return new ResponseEntity<>(saveAcc, HttpStatus.CREATED);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<AccountDto> getAccDto(@PathVariable("id") Long id){

     AccountDto getAcc=accountService.getAccount(id);
     return new ResponseEntity<>(getAcc,HttpStatus.OK);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<AccountDto>>getAllAccDto(){

       List<AccountDto> getAllAcc=accountService.getAllAccount();
       return new ResponseEntity<>(getAllAcc,HttpStatus.OK);
    }

    @PutMapping("/deposite/{id}")
    public ResponseEntity<AccountDto> depositedto(@PathVariable Long id , @RequestBody Map<String,Double>request){

        Double amount = request.get("amount");

        AccountDto depositeBalance=accountService.depositeBalance(id,amount);
        return new ResponseEntity<>(depositeBalance,HttpStatus.ACCEPTED);
    }


    @PutMapping("/withdraw/{id}")
    public ResponseEntity<AccountDto> withdrawdto(@PathVariable Long id , @RequestBody Map<String,Double>request){

        Double amount = request.get("amount");

        AccountDto withdrawBalance=accountService.depositeBalance(id,amount);
        return new ResponseEntity<>(withdrawBalance,HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id)
    {
        accountService.deleteAcccount(id);
        return  ResponseEntity.ok("Account deleted Successfully");
    }
}
