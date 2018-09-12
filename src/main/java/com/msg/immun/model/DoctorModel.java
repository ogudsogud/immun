package com.msg.immun.model;

/**
 * Created by yoga.wiguna on 06/09/2018.
 */
public class DoctorModel {
    private int id_dr;
    private String no_sk;
    private String sip;
    private String name;
    private String birthday;
    private String address;
    private String gender;
    private String email;
    private String password;
    private String specialist;
    private String created_by;
    private String created_on;
    private String updated_by;
    private String updated_on;
    private int status;
    private boolean enabled;

    public DoctorModel(int id_dr, String no_sk, String sip, String name, String birthday, String address, String gender, String email, String password, String specialist, String created_by, String created_on, String updated_by, String updated_on, int status, boolean enabled) {
        this.id_dr = id_dr;
        this.no_sk = no_sk;
        this.sip = sip;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.specialist = specialist;
        this.created_by = created_by;
        this.created_on = created_on;
        this.updated_by = updated_by;
        this.updated_on = updated_on;
        this.status = status;
        this.enabled = enabled;
    }

    public DoctorModel() {

    }

    public int getId_dr() {
        return id_dr;
    }

    public void setId_dr(int id_dr) {
        this.id_dr = id_dr;
    }

    public String getNo_sk() {
        return no_sk;
    }

    public void setNo_sk(String no_sk) {
        this.no_sk = no_sk;
    }

    public String getSip() {
        return sip;
    }

    public void setSip(String sip) {
        this.sip = sip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public String getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(String updated_on) {
        this.updated_on = updated_on;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
