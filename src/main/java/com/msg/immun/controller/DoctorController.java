package com.msg.immun.controller;

import com.msg.immun.model.DoctorModel;
import com.msg.immun.model.ErrCode;
import com.msg.immun.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by yoga.wiguna on 06/09/2018.
 */

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @RequestMapping("/list")
    public ResponseEntity<List<DoctorModel>> getAll(){
        if (doctorService.getDataDoctor().isEmpty()) {
            return  new ResponseEntity(new ErrCode("409", "Data Dokter Kosong"), HttpStatus.NOT_FOUND);
        }
        List<DoctorModel> list = doctorService.getDataDoctor();
        return new ResponseEntity<List<DoctorModel>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<Void> createCluster(@RequestBody DoctorModel doctorModel, UriComponentsBuilder uriComponentsBuilder) {
        if (doctorService.isEmailExist(doctorModel.getEmail()) == true) {
            doctorService.insertDoctor(doctorModel);
        return new ResponseEntity(new ErrCode("201", "Data Dokter berhasil Disimpan"), HttpStatus.CREATED);
        }
        return  new ResponseEntity(new ErrCode("409", "Data Email sudah ada"), HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<DoctorModel> updateUser(@RequestBody DoctorModel doctorModel) {
        doctorService.updateDoctor(doctorModel);
        return new ResponseEntity(new ErrCode("201", "Data Dokter berhasil diubah"), HttpStatus.OK);
    }

    @DeleteMapping("/delete={drid}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable("drid") int dr_id) {
        doctorService.deleteDoctor(dr_id);
        return new ResponseEntity(new ErrCode("201", "Data Dokter berhasil Dihapus"), HttpStatus.OK);
    }
}
