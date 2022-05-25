package com.karabel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.karabel.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
