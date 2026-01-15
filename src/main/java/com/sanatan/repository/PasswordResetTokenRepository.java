package com.sanatan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanatan.model.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
	PasswordResetToken findByToken(String token);
}
