package com.tesfai.onlinebanking.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesfai.onlinebanking.exception.NoAccountFoundException;
import com.tesfai.onlinebanking.exception.NotSufficientBalance;
import com.tesfai.onlinebanking.exception.UnsupportedData;
import com.tesfai.onlinebanking.model.Account;
import com.tesfai.onlinebanking.repository.AccountRepository;
import com.tesfai.onlinebanking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private static int nextAccountNumber = 11223145;

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account createAccount() {
		Account account = new Account();
		account.setAccountBalance(new BigDecimal(0.0));
		account.setAccountNumber(accountGen());

		accountRepository.save(account);
		Account acct = accountRepository.findByAccountNumber(account.getAccountNumber());
		return acct;
	}

	@Override
	public synchronized void deposit(Integer accountNumber, double amount) throws UnsupportedData, NoAccountFoundException {
		Account account = accountRepository.findByAccountNumber(accountNumber);
		if(account==null) {
			throw new NoAccountFoundException("No account is found with ID : "+account);
		}
		
		
		BigDecimal balance = account.getAccountBalance().add(new BigDecimal(amount));
		if (amount < 0) {
			throw new UnsupportedData("Sorry, please enter a non zero positive amount .");
		}

		account.setAccountBalance(balance);
		accountRepository.save(account);

	}

	@Override
	public synchronized void withdraw(Integer accountNumber, double amount) throws NotSufficientBalance, NoAccountFoundException {
		Account account = accountRepository.findByAccountNumber(accountNumber);
		
		if(account==null) {
			throw new NoAccountFoundException("No account is found with ID : "+account);
		}
		BigDecimal balance = account.getAccountBalance().subtract(new BigDecimal(amount));
		if (balance.doubleValue() < 50.00 || amount < 0) {
			throw new NotSufficientBalance("Sorry you don't have suffient balance to with draw.");
		}

		account.setAccountBalance(balance);
		accountRepository.save(account);

	}

	@Override
	public List<Account> displayAllAccounts() {
		return accountRepository.findAll();
	}

	private int accountGen() {
		return ++nextAccountNumber;
	}

	@Override
	public void deleteaccount(Integer accountNumber) throws NotSufficientBalance, NoAccountFoundException {
		Account account = accountRepository.findByAccountNumber(accountNumber);
		if(account==null) {
			throw new NoAccountFoundException("No account found with id : "+account);
		}
		
	}

}
