package com.tesfai.onlinebanking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesfai.onlinebanking.dto.AccountDto;
import com.tesfai.onlinebanking.exception.NoAccountFoundException;
import com.tesfai.onlinebanking.exception.NotSufficientBalance;
import com.tesfai.onlinebanking.exception.UnsupportedData;
import com.tesfai.onlinebanking.model.Account;
import com.tesfai.onlinebanking.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/list")
	public List<Account> displayAccounts(Model model) {

		return accountService.displayAllAccounts();
	}

	@PostMapping("/create")
	public ResponseEntity<Account> createAccount() {
		Account account = accountService.createAccount();
		return ResponseEntity.ok(account);
	}

	@PostMapping(value = "/deposit")
	public ResponseEntity<Map<String,Boolean>> deposit(@RequestBody AccountDto account) throws NumberFormatException, UnsupportedData, NoAccountFoundException {
		
		accountService.deposit(account.getAccountNumber(), Double.parseDouble(account.getAccountBalance()));
		Map<String, Boolean> response=new HashMap<>();
		response.put("deposted",Boolean.TRUE);
		return  ResponseEntity.ok(response);
	}

	@PostMapping(value = "/withdraw")
	public ResponseEntity<Map<String,Boolean>> withdraw(@RequestBody AccountDto account) throws NumberFormatException, NotSufficientBalance, NoAccountFoundException {
		
		accountService.withdraw(account.getAccountNumber(), Double.parseDouble(account.getAccountBalance()));
		Map<String, Boolean> response=new HashMap<>();
		response.put("withdrawed",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
