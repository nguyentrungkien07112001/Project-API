package com.vti.ki4m.service.serviceImpl;

import com.vti.ki4m.entity.Account;
import com.vti.ki4m.entity.AccountStatus;
import com.vti.ki4m.entity.RegistrationUserToken;
import com.vti.ki4m.entity.ResetPasswordToken;
import com.vti.ki4m.event.OnSendRegistrationUserConfirmViaEmailEvent;
import com.vti.ki4m.event.OnSendResetPasswordConfirmViaEmailEvent;
import com.vti.ki4m.repository.IAccountRepository;
import com.vti.ki4m.repository.IRegistrationUserTokenRepository;
import com.vti.ki4m.repository.IResetPasswordTokenRepository;
import com.vti.ki4m.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private IRegistrationUserTokenRepository registrationUserTokenRepository;

    @Autowired
    private IResetPasswordTokenRepository resetPasswordTokenRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountRepository.save(account);
        createNewRegistrationUserToken(account);
        sendConfirmUserRegistrationUserToken(account.getEmail());
    }

    private void createNewRegistrationUserToken(Account account) {
        final String newToken = UUID.randomUUID().toString();
        RegistrationUserToken token = new RegistrationUserToken(newToken, account);
        registrationUserTokenRepository.save(token);
    }

    private void createNewResetPasswordToken(Account account) {
        final String newToken = UUID.randomUUID().toString();
        ResetPasswordToken token = new ResetPasswordToken(newToken, account);
        resetPasswordTokenRepository.save(token);
    }

    private void sendConfirmUserRegistrationUserToken(String email) {
        eventPublisher.publishEvent(new OnSendRegistrationUserConfirmViaEmailEvent(email));
    }

    private void sendResetPasswordConfirmViaEmail(String email) {
        eventPublisher.publishEvent(new OnSendResetPasswordConfirmViaEmailEvent(email));
    }

    @Override
    public Account findAccountByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public String activeAccount(String token) {
        RegistrationUserToken registrationUserToken = registrationUserTokenRepository.findByToken(token);
        Account account = registrationUserToken.getAccount();
        Date timeNow = new Date(System.currentTimeMillis());
        Date expiryDate = registrationUserToken.getExpiryDate();
        // Token hết hạn
        if (timeNow.getTime() >= expiryDate.getTime()) {
            account.setStatus(AccountStatus.NOT_ACTIVE);
            accountRepository.save(account);
            registrationUserTokenRepository.deleteById(registrationUserToken.getId());
            createNewRegistrationUserToken(account);
            sendConfirmUserRegistrationUserToken(account.getEmail());
            return "Kích hoạt thất bại";
        } else {
            account.setStatus(AccountStatus.ACTIVE);
            accountRepository.save(account);
            registrationUserTokenRepository.deleteById(registrationUserToken.getId());
            createNewResetPasswordToken(account);
            return "Kích hoạt thành công";
        }
    }

    @Override
    public String resetPassword(String token, String password) {
        ResetPasswordToken resetPasswordToken = resetPasswordTokenRepository.findByToken(token);
        Account account = resetPasswordToken.getAccount();
        Date timeNow = new Date(System.currentTimeMillis());
        Date tokenExpiryDate = resetPasswordToken.getExpiryDate();
        // Token hết hạn
        if (timeNow.getTime() >= tokenExpiryDate.getTime()) {
            resetPasswordTokenRepository.deleteById(resetPasswordToken.getId());
            createNewResetPasswordToken(account);
            sendResetPasswordConfirmViaEmail(account.getEmail());
            return "Đường dẫn này đã hết hạn. Chúng tôi đã gửi bạn môt email mới. Vui lòng kiểm tra email của bạn. ";
        } else {
            account.setPassword(passwordEncoder.encode(password));
            accountRepository.save(account);
            resetPasswordTokenRepository.deleteById(resetPasswordToken.getId());
            return "Mật khẩu đã được thay đổi";
        }
    }

    @Override
    public List<Account> getAccountUser() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);

        if (account == null) {
            throw new UsernameNotFoundException(username);
        }

        return new org.springframework.security.core.userdetails.User(account.getUsername(), account.getPassword(),
                AuthorityUtils.createAuthorityList(account.getRole()));
    }
}
