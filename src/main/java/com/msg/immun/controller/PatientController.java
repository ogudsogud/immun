package com.msg.immun.controller;

import com.msg.immun.model.ErrCode;
import com.msg.immun.model.PatientModel;
import com.msg.immun.model.VerificationForm;
import com.msg.immun.service.PatientService;
import com.msg.immun.service.VerifyTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by yoga.wiguna on 12/09/2018.
 */

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;
    private VerifyTokenService verifyTokenService;

    @GetMapping("/")
    public String index() {
        return "redirect:/email-verification";
    }

    @GetMapping("/email-verification")
    public String formGet(Model model) {
        model.addAttribute("verificationForm", new VerificationForm());
        return "verification-form";
    }

    @PostMapping("/email-verification")
    public String formPost(@Valid VerificationForm verificationForm, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            model.addAttribute("noErrors", true);
        }
        model.addAttribute("verificationForm", verificationForm);
        verifyTokenService.createVerification(verificationForm.getEmail());
        return "verification-form";
    }

    @GetMapping("/verify-email")
    @ResponseBody
    public String verifyEmail(String code) {
        return verifyTokenService.verifyEmail(code).getBody();
    }





    @RequestMapping("/list")
    public ResponseEntity<List<PatientModel>> getAll(){
        if (patientService.getDataPatient().isEmpty()) {
            return  new ResponseEntity(new ErrCode("409", "Data Pasien Kosong"), HttpStatus.NOT_FOUND);
        }
        List<PatientModel> list = patientService.getDataPatient();
        return new ResponseEntity<List<PatientModel>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<Void> createCluster(@RequestBody PatientModel patientModel, UriComponentsBuilder uriComponentsBuilder) {
        if (patientService.isEmailExist(patientModel.getEmail()) == true) {
            patientService.insertPatient(patientModel);
            return new ResponseEntity(new ErrCode("201", "Data Pasien berhasil Disimpan"), HttpStatus.CREATED);
        }
        return  new ResponseEntity(new ErrCode("409", "Data Email sudah ada"), HttpStatus.CONFLICT);
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
