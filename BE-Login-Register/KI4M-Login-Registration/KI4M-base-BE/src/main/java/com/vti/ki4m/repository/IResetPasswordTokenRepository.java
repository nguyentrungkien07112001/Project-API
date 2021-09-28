package com.vti.ki4m.repository;

import com.vti.ki4m.entity.ResetPasswordToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IResetPasswordTokenRepository extends JpaRepository<ResetPasswordToken, Integer> {

    public ResetPasswordToken findByToken(String token);

    public Boolean existsByToken(String token);

    @Query("SELECT token FROM ResetPasswordToken WHERE account.id = :accountId")
    public String findByUserId(Integer accountId);

    @Transactional
    @Modifying
    @Query("DELETE FROM ResetPasswordToken WHERE account.id = :accountId")
    public void deleteByUserId(Integer accountId);
}
