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
            doctorModel.setDr_id(rs.getInt("dr_id"));
            doctorModel.setNo_sk(rs.getString("no_sk"));
            doctorModel.setSip(rs.getString("sip"));
            doctorModel.setName(rs.getString("name"));
            doctorModel.setBirthday(rs.getString("birthday"));
            doctorModel.setAddress(rs.getString("address"));
            doctorModel.setGender(rs.getString("gender"));
            doctorModel.setEmail(rs.getString("email"));
            doctorModel.setPassword(rs.getString("password"));
            doctorModel.setSpecialist(rs.getString("specialist"));
            doctorModel.setCreated_by(rs.getString("created_by"));
            doctorModel.setCreated_on(rs.getString("created_on"));
            doctorModel.setUpdated_by(rs.getString("updated_by"));
            doctorModel.setUpdated_on(rs.getString("updated_on"));
            doctorModel.setStatus(rs.getInt("status"));
            return doctorModel;
        }
    }

    @Override
    public List<DoctorModel> getDataDoctor() {
        String sql = "SELECT * FROM mtr_doctor WHERE status = 1";
        RowMapper<DoctorModel> rowMapper = new DoctorRowMapper();
        return this.jdbcTemplate.query(sql,rowMapper);
    }


    @Override
    public boolean insertDoctor(DoctorModel doctorModel) {

        String sql = new StringBuilder().append("INSERT INTO mtr_doctor (").
                append("no_sk,").
                append("sip,").
                append("name,").
                append("birthday,").
                append("address,").
                append("gender,").
                append("email,").
                append("password,").
                append("specialist,").
                append("created_by,").
//                append("created_on,").
                append("updated_by,").
//                append("updated_on,").
//                append("status)").
                append("VALUES (?,?,?,?,?,?,?,MD5(?),?,?,NOW(),?,NOW(),1)").toString();
        jdbcTemplate.update(sql,
                doctorModel.getNo_sk(),
                doctorModel.getSip(),
                doctorModel.getName(),
                doctorModel.getBirthday(),
                doctorModel.getAddress(),
                doctorModel.getGender(),
                doctorModel.getEmail(),
                doctorModel.getPassword(),
                doctorModel.getSpecialist(),
                doctorModel.getCreated_by(),
//                doctorModel.getCreated_on(),
                doctorModel.getUpdated_by()
//                doctorModel.getUpdated_on(),
//                doctorModel.getStatus()
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
        String sql = "SELECT * FROM mtr_doctor WHERE name = ? AND status = 1";
        RowMapper<DoctorModel> rowMapper = new DoctorRowMapper();
        DoctorModel doctorModel = jdbcTemplate.queryForObject(sql, rowMapper, name);
        return doctorModel;
    }

    @Override
    public void updateDoctor(DoctorModel doctorModel) {
        String sql = "UPDATE mtr_doctor SET " +
                "no_sk = ?, " +
                "sip = ?, " +
                "name = ?, " +
                "birthday = ?, " +
                "address = ?, " +
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
                doctorModel.getName(),
                doctorModel.getBirthday(),
                doctorModel.getAddress(),
                doctorModel.getGender(),
                doctorModel.getEmail(),
                doctorModel.getPassword(),
                doctorModel.getSpecialist(),
                doctorModel.getCreated_by(),
                doctorModel.getUpdated_by(),
                doctorModel.getDr_id());
    }


    @Override
    public void deleteDoctor(int dr_id) {
        String sql = "UPDATE mtr_doctor SET status = 0 where dr_id = ? ";
        jdbcTemplate.update(sql, dr_id);
    }
}
