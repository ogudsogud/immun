package com.msg.immun.service;

import com.msg.immun.model.DoctorModel;
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
 * Created by yoga.wiguna on 06/09/2018.
 */

@Transactional
@Repository
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class DoctorRowMapper implements RowMapper<DoctorModel> {

        @Override
        public DoctorModel mapRow(ResultSet rs, int i) throws SQLException {
            DoctorModel doctorModel = new DoctorModel();
            doctorModel.setId_dr(rs.getInt("id_dr"));
            doctorModel.setNo_sk(rs.getString("no_sk"));
            doctorModel.setSip(rs.getString("sip"));
            doctorModel.setDoctor_name(rs.getString("doctor_name"));
            doctorModel.setBirthday(rs.getString("birthday"));
            doctorModel.setDoctor_address(rs.getString("doctor_address"));
            doctorModel.setGender(rs.getString("gender"));
            doctorModel.setEmail(rs.getString("email"));
            doctorModel.setPassword(rs.getString("password"));
            doctorModel.setPhone(rs.getString("phone"));
            doctorModel.setSpecialist(rs.getString("specialist"));
            doctorModel.setCreated_by(rs.getString("created_by"));
            doctorModel.setCreated_on(rs.getString("created_on"));
            doctorModel.setUpdated_by(rs.getString("updated_by"));
            doctorModel.setUpdated_on(rs.getString("updated_on"));
            doctorModel.setStatus(rs.getInt("status"));
            doctorModel.setNumber_otp(rs.getString("number_otp"));
            return doctorModel;
        }
    }

    @Override
    public List<DoctorModel> getDataDoctor() {
        String sql = "SELECT * FROM mtr_doctor WHERE status = 1";
        RowMapper<DoctorModel> rowMapper = new DoctorRowMapper();
        return this.jdbcTemplate.query(sql,rowMapper);
    }


    Random random = new Random();
    String hasil = String.format("%04d", random.nextInt(10000));
    @Override
    public boolean insertDoctor(DoctorModel doctorModel) {
        String sql = new StringBuilder().append("INSERT INTO mtr_doctor (").
                append("no_sk,").
                append("sip,").
                append("doctor_name,").
                append("birthday,").
                append("doctor_address,").
                append("gender,").
                append("email,").
                append("password,").
                append("phone,").
                append("specialist,").
                append("created_by,").
//                append("created_on,").
                append("updated_by,").
//                append("updated_on,").
//                append("status)").
//                append("number_otp)").
        append("VALUES (?,?,?,?,?,?,?,MD5(?),?,?,?,NOW(),?,NOW(),1," + hasil + ")").toString();
        jdbcTemplate.update(sql,
                doctorModel.getNo_sk(),
                doctorModel.getSip(),
                doctorModel.getDoctor_name(),
                doctorModel.getBirthday(),
                doctorModel.getDoctor_address(),
                doctorModel.getGender(),
                doctorModel.getEmail(),
                doctorModel.getPassword(),
                doctorModel.getPhone(),
                doctorModel.getSpecialist(),
                doctorModel.getCreated_by(),
//                doctorModel.getCreated_on(),
                doctorModel.getUpdated_by()
//                doctorModel.getUpdated_on(),
//                doctorModel.getStatus(),
//                doctorModel.getNumber_otp()
        );
        return false;
    }

    @Override
    public boolean isEmailExist(String email) {
        String sql = "SELECT count(*) from mtr_doctor WHERE email = ? AND status = 1";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, email);
        return count == 0;
    }

    @Override
    public DoctorModel getByDrName(String name) {
        String sql = "SELECT * FROM mtr_doctor WHERE doctor_name = ? AND status = 1";
        RowMapper<DoctorModel> rowMapper = new DoctorRowMapper();
        DoctorModel doctorModel = jdbcTemplate.queryForObject(sql, rowMapper, name);
        return doctorModel;
    }

    @Override
    public boolean getByDrOtp(String number_otp) {
        String sql = "SELECT count(*) from mtr_doctor WHERE number_otp = ? AND status = 1";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, number_otp);
        if(count == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void updateDoctor(DoctorModel doctorModel) {
        String sql = "UPDATE mtr_doctor SET " +
                "no_sk = ?, " +
                "sip = ?, " +
                "doctor_name = ?, " +
                "birthday = ?, " +
                "doctor_address = ?, " +
                "gender = ?, " +
                "email = ?, " +
                "password = ?, " +
                "specialist = ?, " +
                "updated_by = ?, " +
                "updated_on = now() WHERE " +
                "dr_id = ? AND status = 1";
        jdbcTemplate.update(sql,
                doctorModel.getNo_sk(),
                doctorModel.getSip(),
                doctorModel.getDoctor_name(),
                doctorModel.getBirthday(),
                doctorModel.getDoctor_address(),
                doctorModel.getGender(),
                doctorModel.getEmail(),
                doctorModel.getPassword(),
                doctorModel.getSpecialist(),
                doctorModel.getCreated_by(),
                doctorModel.getUpdated_by(),
                doctorModel.getId_dr());
    }


    @Override
    public void deleteDoctor(int dr_id) {
        String sql = "UPDATE mtr_doctor SET status = 0 where dr_id = ? ";
        jdbcTemplate.update(sql, dr_id);
    }
}
