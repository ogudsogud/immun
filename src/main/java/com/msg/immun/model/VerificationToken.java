package com.msg.immun.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Ogudsogud on 9/15/2018.
 */

@Entity
public class VerificationToken {
    public static final String STATUS_PENDING = "PENDING";
    public static final String STATUS_VERIFIED = "VERIFIED";

    private Long id;
    private String token;
    private String status;
    private LocalDateTime expired_date;
    private LocalDateTime create_date;
    private LocalDateTime confirm_date;
    private PatientModel patientModel;

    public VerificationToken() {
        this.token = UUID.randomUUID().toString();
        this.create_date = LocalDateTime.now();
        this.expired_date = this.create_date.plusDays(1);
        this.status = STATUS_PENDING;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getExpired_date() {
        return expired_date;
    }

    public void setExpired_date(LocalDateTime expired_date) {
        this.expired_date = expired_date;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public LocalDateTime getConfirm_date() {
        return confirm_date;
    }

    public void setConfirm_date(LocalDateTime confirm_date) {
        this.confirm_date = confirm_date;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_patient")
    public PatientModel getPatientModel() {
        return patientModel;
    }

    public void setPatientModel(PatientModel patientModel) {
        this.patientModel = patientModel;
    }
}
