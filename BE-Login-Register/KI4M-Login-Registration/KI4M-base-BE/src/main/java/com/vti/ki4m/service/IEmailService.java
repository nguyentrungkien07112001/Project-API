package com.vti.ki4m.service;

public interface IEmailService {
    void sendRegistrationUserConfirm(String email);

    void sendResetPasswordConfirm(String email);
}
