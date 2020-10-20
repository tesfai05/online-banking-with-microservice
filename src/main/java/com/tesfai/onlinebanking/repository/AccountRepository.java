package com.tesfai.onlinebanking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tesfai.onlinebanking.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Account findByAccountNumber (int accountNumber);
}
