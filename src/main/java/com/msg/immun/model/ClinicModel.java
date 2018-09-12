package com.msg.immun.model;

/**
 * Created by yoga.wiguna on 12/09/2018.
 */
public class ClinicModel {

    private int id_clinic;
    private String clinic_name;
    private String clinic_address;
    private String created_by;
    private String created_on;
    private String updated_by;
    private String updated_on;
    private int status;


    public ClinicModel(int id_clinic, String clinic_name, String clinic_address, String created_by, String created_on, String updated_by, String updated_on, int status) {
        this.id_clinic = id_clinic;
        this.clinic_name = clinic_name;
        this.clinic_address = clinic_address;
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


    public String getClinic_name() {
        return clinic_name;
    }

    public void setClinic_name(String clinic_name) {
        this.clinic_name = clinic_name;
    }

    public String getClinic_address() {
        return clinic_address;
    }

    public void setClinic_address(String clinic_address) {
        this.clinic_address = clinic_address;
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
