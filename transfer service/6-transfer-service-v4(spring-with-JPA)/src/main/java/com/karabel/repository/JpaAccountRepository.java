package com.karabel.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.karabel.entity.Account;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JpaAccountRepository implements AccountRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public JpaAccountRepository() {
		this.entityManager = entityManager;
		log.info("JpaAccountRepository instance created..");
	}

	public Account loadAccount(String number) {
		log.info("loading account.." + number);
		return entityManager.find(Account.class, number);
	}

	public void updateAccount(Account account) {
		log.info("updating account.." + account.getNumber());
		entityManager.merge(account);

	}

}
