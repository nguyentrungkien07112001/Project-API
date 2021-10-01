package com.vti.ki4m.service;

import com.vti.ki4m.entity.Account;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface IAccountService extends UserDetailsService {
    void createAccount(Account account);

    Account findAccountByEmail(String email);

    String activeAccount(HttpServletResponse response, String token) throws IOException, InterruptedException;

    String resetPassword(String token, String password);

    List<Account> getAccountUser();

    Account findAccountByUsername(String username);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
