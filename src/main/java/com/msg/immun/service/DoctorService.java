package com.msg.immun.service;

import com.msg.immun.model.DoctorModel;

import java.util.List;

/**
 * Created by yoga.wiguna on 06/09/2018.
 */
public interface DoctorService {
    List<DoctorModel> getDataDoctor();

    boolean insertDoctor(DoctorModel doctorModel);

    boolean isEmailExist(String email);

    DoctorModel getByDrName(String name);

    void updateDoctor(DoctorModel doctorModel);

    void deleteDoctor(int dr_id);
}
