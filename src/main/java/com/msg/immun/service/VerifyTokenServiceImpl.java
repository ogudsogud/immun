package com.msg.immun.service;

import com.msg.immun.model.PatientModel;
import com.msg.immun.model.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Ogudsogud on 9/15/2018.
 */

@Service
public class VerifyTokenServiceImpl {
    private PatientService patientService;
    private VerifyTokenService verifyTokenService;
    private EmailService emailService;

    @Autowired
    public VerifyTokenServiceImpl(PatientService patientService,
                                  VerifyTokenService verifyTokenService, EmailService emailService){
        this.patientService = patientService;
        this.verifyTokenService = verifyTokenService;
        this.emailService = emailService;
    }


    public void createVerification(String email) {
        List<PatientModel> patientModelList = patientService.getPatientEmail(email);
        PatientModel patientModel = null;
        if (patientModel.equals(null)) {
            patientModel = new PatientModel();
            patientModel.setEmail(email);
            patientService.insertPatient(patientModel);
        } else {
            patientModel = patientModelList.get(0);
        }


        List<VerificationToken> tokenList = verifyTokenService.findByUserEmail(email);
        VerificationToken verificationToken;
        if (tokenList.equals(null)) {
            verificationToken = new VerificationToken();
            verificationToken.setPatientModel(patientModel);
            verifyTokenService.save(verificationToken);
        } else {
            verificationToken = tokenList.get(0);
        }

        emailService.sendVerificationMail(email, verificationToken.getToken());
    }

    public ResponseEntity<String> verifyEmail(String token){
        List<VerificationToken> verificationTokens = verifyTokenService.findByToken(token);
        if (verificationTokens.isEmpty()) {
            return ResponseEntity.badRequest().body("Token tidak Valid.");
        }

        VerificationToken verificationToken = verificationTokens.get(0);
        if (verificationToken.getExpired_date().isBefore(LocalDateTime.now())) {
            return ResponseEntity.unprocessableEntity().body("Token Kadaluwarsa.");
        }

        verificationToken.setConfirm_date(LocalDateTime.now());
        verificationToken.setStatus(VerificationToken.STATUS_VERIFIED);
        verificationToken.getPatientModel().getEnabled().equals(true);
        verifyTokenService.save(verificationToken);

        return ResponseEntity.ok("Anda telah sukses verifikasi email.");
    }
}
