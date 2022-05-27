package com.karabel.repository;

import com.karabel.entity.Account;

public interface AccountRepository {

	public Account loadAccount(String number);

	public void updateAccount(Account account);
}
