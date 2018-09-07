package com.msg.immun.model;

/**
 * Created by yoga.wiguna on 06/09/2018.
 */
public class PatientModel {
    private int patient_id;
    private String name;
    private String address;
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

    public PatientModel(int patient_id, String name, String address, String age, String gender, String email, String password, String Phone, String birthday, String blood_type, int weight, int height, String addict, String allergic, String created_by, String created_on, String updated_by, String updated_on, int status) {
        this.patient_id = patient_id;
        this.name = name;
        this.address = address;
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
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
