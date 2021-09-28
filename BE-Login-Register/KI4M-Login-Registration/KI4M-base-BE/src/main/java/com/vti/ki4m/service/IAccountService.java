package com.vti.ki4m.service;

import com.vti.ki4m.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAccountService extends UserDetailsService {
    void createAccount(Account account);

    Account findAccountByEmail(String email);

    String activeAccount(String token);

    String resetPassword(String token, String password);

    List<Account> getAccountUser();

    Account getAccountByUsername(String username);

}
