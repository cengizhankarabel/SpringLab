package com.karabel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.karabel.model.Account;
import com.karabel.repository.AccountRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("transferService")
public class TransferServiceImpl implements TransferService {

	private AccountRepository accountRepository;

	@Autowired
	public TransferServiceImpl(@Qualifier("jpaAccountRepository") AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		log.info("TransferServiceImpl instance created...");
	}

	public void transfer(double amount, String fromAccNum, String toAccNum) {
		log.info("transfer initiated..");

		Account fromAccount = accountRepository.loadAccount(fromAccNum);
		Account toAccount = accountRepository.loadAccount(toAccNum);

		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		accountRepository.updateAccount(fromAccount);
		accountRepository.updateAccount(toAccount);

		log.info("transfer finished..");

	}
}
