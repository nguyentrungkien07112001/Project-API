package com.vti.ki4m.controller;

import com.vti.ki4m.dto.AccountDTO;
import com.vti.ki4m.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/accounts")
@Validated
public class AccountController {

    @Autowired
    private IAccountService accountService;

    // Tạo tài khoản
    @PostMapping("/registration")
    public ResponseEntity<?> createAccount(@Valid @RequestBody AccountDTO accountDTO) {
        accountService.createAccount(accountDTO.toEntity());
        return new ResponseEntity<>("Chúng tôi đã gửi một tin nhắn. Vui lòng kiểm tra email để kích hoạt tài khoản. ", HttpStatus.OK);
    }

    // Kích hoạt bằng Email
    @GetMapping("/registration/activeAccount")
    public ResponseEntity<?> activeAccountViaEmail(HttpServletResponse response, @RequestParam String token) throws IOException, InterruptedException {
        String message =  accountService.activeAccount(response, token);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // Đặt lại mật khẩu
    @PutMapping("/resetPassword")
    public ResponseEntity<?> resetPassword(@RequestParam String token, @RequestBody String newPassword) {
        String message =  accountService.resetPassword(token, newPassword);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // Thông tin toàn bộ user
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllAcounts() {
        return new ResponseEntity<>(accountService.getAccountUser(), HttpStatus.OK);
    }

    // Thông tin account theo username
    @GetMapping("/getOne/{username}")
    public ResponseEntity<?> getAccountByUsername(@PathVariable String username) {
        return new ResponseEntity<>(accountService.findAccountByUsername(username), HttpStatus.OK);
    }
}
