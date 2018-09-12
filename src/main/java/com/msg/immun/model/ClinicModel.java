package com.msg.immun.model;

/**
 * Created by yoga.wiguna on 12/09/2018.
 */
public class ClinicModel {

    private int id_clinic;
    private String name;
    private String address;
    private String created_by;
    private String created_on;
    private String updated_by;
    private String updated_on;
    private int status;


    public ClinicModel(int id_clinic, String name, String address, String created_by, String created_on, String updated_by, String updated_on, int status) {
        this.id_clinic = id_clinic;
        this.name = name;
        this.address = address;
        this.created_by = created_by;
        this.created_on = created_on;
        this.updated_by = updated_by;
        this.updated_on = updated_on;
        this.status = status;
    }

    public ClinicModel() {

    }


    public int getId_clinic() {
        return id_clinic;
    }

    public void setId_clinic(int id_clinic) {
        this.id_clinic = id_clinic;
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
