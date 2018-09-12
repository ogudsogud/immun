package com.msg.immun.service;

import com.msg.immun.model.ClinicModel;

import java.util.List;

/**
 * Created by yoga.wiguna on 12/09/2018.
 */
public interface ClinicService {
    List<ClinicModel> getDataClinic();

    boolean insertClinic(ClinicModel clinicModel);

    boolean isName(String name);

    void updateClinic(ClinicModel clinicModel);
}
