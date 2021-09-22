package com.vti.ki4m.mapper;

import com.vti.ki4m.dto.AccountDTO;
import com.vti.ki4m.entity.Account;
import com.vti.ki4m.form.AccountIn;
import com.vti.ki4m.form.AccountUpdateIn;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    // Map Entity vs DTO
    public AccountDTO map(Account account) {
        // To do code
        return null;
    }

    // Map Entity vs form
    public Account map(AccountIn accountIn) {
        // To do code
        return null;
    }

    // Map Entity vs form
    public Account map(AccountUpdateIn accountUpdateIn, Account account) {
        // To do code
        return null;
    }
}
