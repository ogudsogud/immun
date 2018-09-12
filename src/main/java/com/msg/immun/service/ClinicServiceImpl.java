package com.msg.immun.service;

import com.msg.immun.model.ClinicModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yoga.wiguna on 12/09/2018.
 */
public class ClinicServiceImpl implements ClinicService {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    class ClinicRowMapper implements RowMapper<ClinicModel> {

        @Override
        public ClinicModel mapRow(ResultSet rs, int i) throws SQLException {
            ClinicModel clinicModel = new ClinicModel();
            clinicModel.setId_clinic(rs.getInt("id_clinic"));
            clinicModel.setClinic_name(rs.getString("clinic_name"));
            clinicModel.setClinic_address(rs.getString("clinic_address"));
            clinicModel.setCreated_by(rs.getString("created_by"));
            clinicModel.setCreated_on(rs.getString("created_on"));
            clinicModel.setUpdated_by(rs.getString("updated_by"));
            clinicModel.setUpdated_on(rs.getString("updated_on"));
            clinicModel.setStatus(rs.getInt("status"));
            return clinicModel;
        }
    }

    @Override
    public List<ClinicModel> getDataClinic() {
        String sql = "SELECT * FROM mtr_clinic WHERE status = 1";
        RowMapper<ClinicModel> rowMapper = new ClinicRowMapper();
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public boolean insertClinic(ClinicModel clinicModel) {

        String sql = new StringBuilder().append("INSERT INTO mtr_clinic (").
                append("clinic_name,").
                append("clinic_address,").
                append("created_by,").
//                append("created_on,").
        append("updated_by,").
//                append("updated_on,").
//                append("status)").
        append("VALUES (?,?,?,NOW(),?,NOW(),1)").toString();
        jdbcTemplate.update(sql,
                clinicModel.getClinic_name(),
                clinicModel.getClinic_address(),
                clinicModel.getCreated_by(),
//                clinicModel.getCreated_on(),
                clinicModel.getUpdated_by()
//                clinicModel.getUpdated_on(),
//                clinicModel.getStatus()
        );
        return false;
    }


    @Override
    public boolean isName(String name) {
        String sql = "SELECT count(*) from mtr_clinic WHERE clinic_name = ? AND status = 1";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, name);
        return count == 0;
    }

    @Override
    public void updateClinic(ClinicModel clinicModel) {
        String sql = "UPDATE mtr_clinic SET " +
                "clinic_name = ?, " +
                "clinic_address = ?, " +
                "updated_by = ?, " +
                "updated_on = now() WHERE " +
                "id_clinic = ? AND status = 1";
        jdbcTemplate.update(sql,
                clinicModel.getClinic_name(),
                clinicModel.getClinic_address(),
                clinicModel.getUpdated_by(),
                clinicModel.getId_clinic());
    }


}
