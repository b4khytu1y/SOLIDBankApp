package com.bank.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.Account;

@Repository
public interface AccountDAO extends CrudRepository<Account, String> {
    List<Account> findAllByClientId(String clientId);
}
