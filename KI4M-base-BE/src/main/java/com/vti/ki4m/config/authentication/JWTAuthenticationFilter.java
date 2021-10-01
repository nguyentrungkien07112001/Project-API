package com.vti.ki4m.config.authentication;

import com.vti.ki4m.entity.Account;
import com.vti.ki4m.service.IAccountService;
import com.vti.ki4m.service.serviceImpl.JWTTokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private IAccountService accountService;

    public JWTAuthenticationFilter(String url, AuthenticationManager authManager, IAccountService accountService) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
        this.accountService = accountService;
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request,
            HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getParameter("username"),
                        request.getParameter("password"),
                        Collections.emptyList()
                )
        );
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authResult) throws IOException, ServletException {

        // infor account
        Account account = accountService.findAccountByUsername(authResult.getName());

        JWTTokenService.addJWTTokenAndAccountInforToBody(response, account);
    }
}