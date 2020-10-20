package com.tesfai.onlinebanking.service;

import java.util.List;

import com.tesfai.onlinebanking.exception.NoAccountFoundException;
import com.tesfai.onlinebanking.exception.NotSufficientBalance;
import com.tesfai.onlinebanking.exception.UnsupportedData;
import com.tesfai.onlinebanking.model.Account;

public interface AccountService {
	Account createAccount();
    void deposit(Integer account,double amount) throws UnsupportedData, NoAccountFoundException;
    void withdraw(Integer account, double amount) throws NotSufficientBalance, NoAccountFoundException;
	List<Account> displayAllAccounts();
	
	 void deleteaccount(Integer account) throws NotSufficientBalance, NoAccountFoundException;
    
    
}