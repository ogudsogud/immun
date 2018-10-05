package com.msg.immun.service;

import com.msg.immun.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by Ogudsogud on 9/15/2018.
 */
public interface VerifyTokenService extends JpaRepository<VerificationToken, String>{

    List<VerificationToken> findByUserEmail(String email);
    List<VerificationToken> findByToken(String token);
    void createVerification(String email);
    ResponseEntity<String>verifyEmail(String code);

}
