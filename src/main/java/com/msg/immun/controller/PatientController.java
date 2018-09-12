package com.msg.immun.controller;

import com.msg.immun.model.ErrCode;
import com.msg.immun.model.PatientModel;
import com.msg.immun.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by yoga.wiguna on 12/09/2018.
 */

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping("/list")
    public ResponseEntity<List<PatientModel>> getAll(){
        if (patientService.getDataPatient().isEmpty()) {
            return  new ResponseEntity(new ErrCode("409", "Data Pasien Kosong"), HttpStatus.NOT_FOUND);
        }
        List<PatientModel> list = patientService.getDataPatient();
        return new ResponseEntity<List<PatientModel>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/insert-new", method = RequestMethod.POST)
    public ResponseEntity<Void> createCluster(@RequestBody PatientModel patientModel, UriComponentsBuilder uriComponentsBuilder) {
        if (patientService.isEmailExist(patientModel.getEmail()) == true) {
            patientService.insertPatient(patientModel);
            return new ResponseEntity(new ErrCode("201", "Data Pasien berhasil Disimpan"), HttpStatus.CREATED);
        }
        return  new ResponseEntity(new ErrCode("409", "Data Pasien sudah ada"), HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<PatientModel> updateUser(@RequestBody PatientModel patientModel) {
        patientService.updatePatient(patientModel);
        return new ResponseEntity(new ErrCode("201", "Data Pasien berhasil diubah"), HttpStatus.OK);
    }

    @DeleteMapping("/delete={patientid}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable("patientid") int id_patient) {
        patientService.deletePatient(id_patient);
        return new ResponseEntity(new ErrCode("201", "Data Pasien berhasil Dihapus"), HttpStatus.OK);
    }
}
