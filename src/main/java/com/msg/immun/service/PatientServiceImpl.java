package com.msg.immun.service;

import com.msg.immun.model.PatientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 * Created by yoga.wiguna on 12/09/2018.
 */
public class PatientServiceImpl implements PatientService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class PatientRowMapper implements RowMapper<PatientModel> {

        @Override
        public PatientModel mapRow(ResultSet rs, int i) throws SQLException {
            PatientModel patientModel = new PatientModel();
            patientModel.setId_patient(rs.getInt("id_patient"));
            patientModel.setName(rs.getString("name"));
            patientModel.setAddress(rs.getString("address"));
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
            patientModel.setEnabled(rs.getInt("enabled"));
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
    String hasil = String.format("%04d", random.nextInt(10000));
    @Override
    public boolean insertPatient(PatientModel patientModel) {

        String sql = new StringBuilder().append("INSERT INTO mtr_patient (").
                append("name,").
                append("address,").
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
//                append("created_on,").
        append("updated_by,").
//                append("updated_on,").
//                append("status)").
//                append("number_otp)").
        append("VALUES (?,?,?,?,?,MD5(?),?,?,?,?,?,?,?,?,NOW(),?,NOW(),1,"+hasil+")").toString();
        jdbcTemplate.update(sql,
                patientModel.getName(),
                patientModel.getAddress(),
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
}
