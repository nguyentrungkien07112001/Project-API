package com.vti.ki4m.repository;

import com.vti.ki4m.entity.Account;
import com.vti.ki4m.entity.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface IAccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {

    public Boolean existsByUsername(String username);

    public Boolean existsByEmail(String email);

    @Query("SELECT status FROM Account WHERE email =:email")
    public AccountStatus findStatusByEmail(String email);

    public Account findByUsername(String username);

    public Account findByEmail(String email);
}
