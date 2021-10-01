package com.vti.ki4m.repository;

import com.vti.ki4m.entity.RegistrationUserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IRegistrationUserTokenRepository extends JpaRepository<RegistrationUserToken, Integer> {

    public RegistrationUserToken findByToken(String token);

    public Boolean existsByToken(String token);

    @Query("SELECT token FROM RegistrationUserToken WHERE account.id = :accountId")
    public String findByAccountId(Integer accountId);

    @Transactional
    @Modifying
    @Query("DELETE FROM RegistrationUserToken WHERE account.id =: accountId")
    public void deleteByAccount(Integer accountId);
}
