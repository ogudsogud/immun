package com.msg.immun.model;

import javax.persistence.*;


/**
 * Created by yoga.wiguna on 06/09/2018.
 */
public class PatientModel {
    private int id_patient;
    private String patient_name;
    private String patient_address;
    private String age;
    private String gender;
    private String email;
    private String password;
    private String phone;
    private String birthday;
    private String blood_type;
    private int weight;
    private int height;
    private String addict;
    private String allergic;
    private String created_by;
    private String created_on;
    private String updated_by;
    private String updated_on;
    private int status;
    private String number_otp;
    private String enabled;

    public PatientModel(int id_patient, String patient_name, String patient_address,
                        String age, String gender, String email,
                        String password, String Phone, String birthday,
                        String blood_type, int weight, int height,
                        String addict, String allergic, String created_by,
                        String created_on, String updated_by, String updated_on,
                        int status, String number_otp) {
        this.id_patient = id_patient;
        this.patient_name = patient_name;
        this.patient_address = patient_address;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.birthday = birthday;
        this.blood_type = blood_type;
        this.weight = weight;
        this.height = height;
        this.addict = addict;
        this.allergic = allergic;
        this.created_by = created_by;
        this.created_on = created_on;
        this.updated_by = updated_by;
        this.updated_on = updated_on;
        this.status = status;
        this.number_otp = number_otp;


    }

    public PatientModel() {

    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }


    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_address() {
        return patient_address;
    }

    public void setPatient_address(String patient_address) {
        this.patient_address = patient_address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getAddict() {
        return addict;
    }

    public void setAddict(String addict) {
        this.addict = addict;
    }

    public String getAllergic() {
        return allergic;
    }

    public void setAllergic(String allergic) {
        this.allergic = allergic;
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


    public String getNumber_otp() {
        return number_otp;
    }

    public void setNumber_otp(String number_otp) {
        this.number_otp = number_otp;
    }


    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
}
