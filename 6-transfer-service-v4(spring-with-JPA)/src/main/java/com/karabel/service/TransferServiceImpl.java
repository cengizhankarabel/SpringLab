package com.karabel.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.karabel.entity.Account;
import com.karabel.repository.AccountRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component // new TransferServiceImpl()
public class TransferServiceImpl implements TransferService {

	private AccountRepository accountRepository;

	// constructor level dependency injection
	@Autowired
	public TransferServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		log.info("TransferServiceImpl instance created...");
	}

	@Transactional(transactionManager = "transactionManager")
	public void transfer(double amount, String srcAccNum, String targetAccNum) {

		log.info("transfer initiated..");

		Account srcAccount = accountRepository.loadAccount(srcAccNum);
		Account targetAccount = accountRepository.loadAccount(targetAccNum);

		srcAccount.setBalance(srcAccount.getBalance() - amount);
		targetAccount.setBalance(targetAccount.getBalance() + amount);

		accountRepository.updateAccount(srcAccount);
		accountRepository.updateAccount(targetAccount);

		log.info("transfer finished..");

	}

}
