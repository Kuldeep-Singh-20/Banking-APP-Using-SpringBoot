package com.bankingApp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class AccountDto {

    private Long id;
    private String accountHolderName;
    public double balance;

    public AccountDto(Long id,String accountHolderName,double balance){
        this.id=id;
        this.accountHolderName=accountHolderName;
        this.balance=balance;
    }


    public void setBalance(double balance){
        this.balance=balance;
    }

    public double getBalance(){
        return balance;
    }

    public void setAccountHolderName(String accountHolderName){
        this.accountHolderName=accountHolderName;
    }

    public String getAccountHolderName(){
        return accountHolderName;
    }

    public void setId(long id){
        this.id=id;
    }

    public long getId(){
        return id;
    }
}
