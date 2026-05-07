package com.smartparking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartparking.entity.User;
import com.smartparking.entity.Account;
import com.smartparking.repository.AccountRepository;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AccountRepository accountRepository;

    public User login(String username, String password) {

        Optional<Account> optional = accountRepository.findByUsername(username);

        if (optional.isEmpty())
            return null;

        Account acc = optional.get();

        if (!acc.getPassword().equals(password))
            return null;

        User user = acc.getUser();

        if (user == null) {
            throw new RuntimeException("User not linked to account");
        }

        return user;
    }
}