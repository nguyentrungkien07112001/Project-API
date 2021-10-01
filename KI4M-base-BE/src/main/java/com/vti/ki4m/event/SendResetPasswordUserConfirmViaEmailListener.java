package com.vti.ki4m.event;

import com.vti.ki4m.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

public class SendResetPasswordUserConfirmViaEmailListener implements ApplicationListener<OnSendResetPasswordConfirmViaEmailEvent> {

    @Autowired
    private IEmailService emailService;

    @Override
    public void onApplicationEvent(OnSendResetPasswordConfirmViaEmailEvent event) {
        sendResetPasswordConfirmViaEmail(event.getEmail());
    }

    private void sendResetPasswordConfirmViaEmail(String email) {
        emailService.sendResetPasswordConfirm(email);
    }
}
