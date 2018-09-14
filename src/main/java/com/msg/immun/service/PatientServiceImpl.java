package com.msg.immun.service;

import com.msg.immun.model.PatientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 * Created by yoga.wiguna on 12/09/2018.
 */

@Transactional
@Repository
public class PatientServiceImpl implements PatientService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class PatientRowMapper implements RowMapper<PatientModel> {

        @Override
        public PatientModel mapRow(ResultSet rs, int i) throws SQLException {
            PatientModel patientModel = new PatientModel();
            patientModel.setId_patient(rs.getInt("id_patient"));
            patientModel.setPatient_name(rs.getString("patient_name"));
            patientModel.setPatient_address(rs.getString("patient_address"));
            patientModel.setAge(rs.getString("age"));
            patientModel.setGender(rs.getString("gender"));
            patientModel.setEmail(rs.getString("email"));
            patientModel.setPassword(rs.getString("password"));
            patientModel.setPhone(rs.getString("phone"));
            patientModel.setBirthday(rs.getString("birthday"));
            patientModel.setBlood_type(rs.getString("blood_type"));
            patientModel.setWeight(rs.getInt("weight"));
            patientModel.setHeight(rs.getInt("height"));
            patientModel.setAddict(rs.getString("addict"));
            patientModel.setAllergic(rs.getString("allergic"));
            patientModel.setCreated_by(rs.getString("created_by"));
            patientModel.setCreated_on(rs.getString("created_on"));
            patientModel.setUpdated_by(rs.getString("updated_by"));
            patientModel.setUpdated_on(rs.getString("updated_on"));
            patientModel.setStatus(rs.getInt("status"));
            patientModel.setNumber_otp(rs.getString("number_otp"));
            return patientModel;
        }
    }



    @Override
    public List<PatientModel> getDataPatient() {
        String sql = "SELECT * FROM mtr_patient WHERE status = 1";
        RowMapper<PatientModel> rowMapper = new PatientRowMapper();
        return this.jdbcTemplate.query(sql,rowMapper);
    }



        Random random = new Random();
    @Override
    public boolean insertPatient(PatientModel patientModel) {

        String sql = new StringBuilder().append("INSERT INTO mtr_patient (").
                append("patient_name,").
                append("patient_address,").
                append("age,").
                append("gender,").
                append("email,").
                append("password,").
                append("phone,").
                append("birthday,").
                append("blood_type,").
                append("weight,").
                append("height,").
                append("addict,").
                append("allergic,").
                append("created_by,").
                append("created_on,").
                append("updated_by,").
                append("updated_on,").
                append("status,").
                append("number_otp").
                append(")").
        append("VALUES (?,?,?,?,?,MD5(?),?,?,?,?,?,?,?,?,NOW(),?,NOW(),1,"+patientModel.getPhone().substring(4,4)+random.nextInt(9999)+")").toString();
        jdbcTemplate.update(sql,
                patientModel.getPatient_name(),
                patientModel.getPatient_address(),
                patientModel.getAge(),
                patientModel.getGender(),
                patientModel.getEmail(),
                patientModel.getPassword(),
                patientModel.getPhone(),
                patientModel.getBirthday(),
                patientModel.getBlood_type(),
                patientModel.getWeight(),
                patientModel.getHeight(),
                patientModel.getAddict(),
                patientModel.getAllergic(),
//                patientModel.getCreated_by(),
//                patientModel.getCreated_on(),
                patientModel.getUpdated_by()
//                patientModel.getUpdated_on(),
//                patientModel.getStatus()
        );
        return false;
    }


    @Override
    public void updatePatient(PatientModel patientModel) {
        String sql = "UPDATE mtr_patient SET " +
                "patient_name = ?, " +
                "patient_address = ?, " +
                "age = ?, " +
                "gender = ?, " +
                "email = ?, " +
                "password = ?, " +
                "phone = ?, " +
                "birthday = ?, " +
                "blood_type = ?, " +
                "weight = ?, " +
                "height = ?, " +
                "addict = ?, " +
                "allergic = ?, " +
                "updated_by = ?, " +
                "updated_on = now() WHERE " +
                "id_patient = ? AND status = 1";
        jdbcTemplate.update(sql,
                patientModel.getPatient_name(),
                patientModel.getPatient_address(),

                patientModel.getAge(),
                patientModel.getGender(),
                patientModel.getEmail(),
                patientModel.getPassword(),
                patientModel.getPhone(),
                patientModel.getBirthday(),
                patientModel.getBlood_type(),
                patientModel.getWeight(),
                patientModel.getHeight(),
                patientModel.getAddict(),
                patientModel.getAllergic(),
                patientModel.getUpdated_by(),
//                patientModel.getUpdated_on(),
                patientModel.getId_patient());
    }


    @Override
    public boolean isEmailExist(String email) {
        String sql = "SELECT count(*) from mtr_patient WHERE email = ? AND status = 1";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, email);
        if(count == 1) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean getByDrOtp(String number_otp) {
        String sql = "SELECT count(*) from mtr_patient WHERE number_otp = ? AND status = 1";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, number_otp);
        if(count == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deletePatient(int id_patient) {
        String sql = "UPDATE mtr_patient SET status = 0 where id_patient = ? ";
        jdbcTemplate.update(sql, id_patient);
    }

}
