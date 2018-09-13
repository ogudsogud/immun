package com.msg.immun.controller;

import com.msg.immun.model.ClinicModel;
import com.msg.immun.model.ErrCode;
import com.msg.immun.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by yoga.wiguna on 13/09/2018.
 */

@RestController
@RequestMapping("/clinic")
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    @RequestMapping("/list")
    public ResponseEntity<List<ClinicModel>> getAll(){
        if (clinicService.getDataClinic().isEmpty()) {
            return  new ResponseEntity(new ErrCode("409", "Data Klinik Kosong"), HttpStatus.NOT_FOUND);
        }
        List<ClinicModel> list = clinicService.getDataClinic();
        return new ResponseEntity<List<ClinicModel>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<Void> createCluster(@RequestBody ClinicModel clinicModel, UriComponentsBuilder uriComponentsBuilder) {
        if (clinicService.isName(clinicModel.getClinic_name()) == true) {
            clinicService.insertClinic(clinicModel);
            return new ResponseEntity(new ErrCode("201", "Data Klinik berhasil Disimpan"), HttpStatus.CREATED);
        }
        return  new ResponseEntity(new ErrCode("409", "Data Klinik sudah ada"), HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<ClinicModel> updateUser(@RequestBody ClinicModel clinicModel) {
        clinicService.updateClinic(clinicModel);
        return new ResponseEntity(new ErrCode("201", "Data Klinik berhasil diubah"), HttpStatus.OK);
    }

    @DeleteMapping("/delete={clinicid}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable("clinicid") int id_clinic) {
        clinicService.deleteClinic(id_clinic);
        return new ResponseEntity(new ErrCode("201", "Data Dokter berhasil Dihapus"), HttpStatus.OK);
    }
}
