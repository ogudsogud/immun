package com.msg.immun.service;

import com.msg.immun.model.PatientModel;

import java.util.List;

/**
 * Created by yoga.wiguna on 12/09/2018.
 */
public interface PatientService {


    List<PatientModel> getDataPatient();

    boolean insertPatient(PatientModel patientModel);

    void updatePatient(PatientModel patientModel);

    boolean isEmailExist(String email);

    boolean getByDrOtp(String number_otp);

    void deletePatient(int id_patient);
}
