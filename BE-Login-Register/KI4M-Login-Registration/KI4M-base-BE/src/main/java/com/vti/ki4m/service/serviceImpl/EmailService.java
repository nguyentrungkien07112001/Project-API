package com.vti.ki4m.service.serviceImpl;

import com.vti.ki4m.entity.Account;
import com.vti.ki4m.repository.IRegistrationUserTokenRepository;
import com.vti.ki4m.repository.IResetPasswordTokenRepository;
import com.vti.ki4m.service.IEmailService;
import com.vti.ki4m.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements IEmailService {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IRegistrationUserTokenRepository registrationUserTokenRepository;

    @Autowired
    private IResetPasswordTokenRepository resetPasswordTokenRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendRegistrationUserConfirm(String email) {
        Account account = accountService.findAccountByEmail(email);
        String token = registrationUserTokenRepository.findByAccountId(account.getId());
        String confirmationUrl = "http://localhost:8090/api/v1/registration/activeAccount?token=" + token;
        String subject = "Xác nhận đăng ký Account";
        String content = "Bạn đã đăng ký thành công. Click vào link dưới đây để kích hoạt tài khoản \n" + confirmationUrl;
        sendEmail(email, subject, content);
    }

    @Override
    public void sendResetPasswordConfirm(String email) {
        Account account = accountService.findAccountByEmail(email);
        String token = resetPasswordTokenRepository.findByUserId(account.getId());
        String confirmationUrl = "http://localhost:8090/api/v1/Accounts/resetPassword?token=" + token;
        String subject = "Đặt lại mật khẩu";
        String content = "Bạn hãy click vào đường dẫn để thay đổi mật khảu \n" + confirmationUrl;
        sendEmail(email, subject, content);
    }

    private void sendEmail(final String recipientEmail, final String subject, final String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject(subject);
        message.setText(content);
        javaMailSender.send(message);
    }
}
