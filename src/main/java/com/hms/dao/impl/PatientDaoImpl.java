package com.hms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.hms.dao.PatientDao;
import com.hms.model.Patient;

public class PatientDaoImpl implements PatientDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("Inside setJdbcTemplate Constructor");
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Patient save(Patient newPatient) {
		System.out.println("inside PatientDaoImpl save");
		System.out.println(jdbcTemplate);
		System.out.println(newPatient);

		if(newPatient.getId() != null) {
			int update = jdbcTemplate.update("UPDATE hms_db.patient SET first_name = ?, last_name = ?, email = ?, mobile_no = ?, gender = ? WHERE id=?", 
					newPatient.getFirstName(),
					newPatient.getLastName(),
					newPatient.getEmail(),
					newPatient.getMobileNo(),
					newPatient.getGender(),
					newPatient.getId()
					);
		}else {
			int update = jdbcTemplate.update("INSERT INTO hms_db.patient VALUES(?,?,?,?,?,?)", 
					newPatient.getId(),
					newPatient.getFirstName(),
					newPatient.getLastName(),
					newPatient.getEmail(),
					newPatient.getMobileNo(),
					newPatient.getGender()
					);	
		}


		return null;
	}

	@Override
	public List<Patient> allPatient() {
		System.out.println("Inside allPatient Dao");
		//List<Patient> qry = jdbcTemplate.query("SELECT * FROM hms_db.patient", new BeanPropertyRowMapper<>(Patient.class)); 
		//Patient queryForObject = jdbcTemplate.queryForObject("SELECT * FROM hbms_db.patient WHERE id=?", new PatientRowMapper());
		List<Patient> query = jdbcTemplate.query("SELECT * FROM hms_db.patient", new PatientRowMapper());
		System.out.println(query);
		return query;
	}

	private static final class PatientRowMapper implements RowMapper<Patient>
	{

		@Override
		public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {

			Patient p =new Patient();
			p.setId(rs.getInt("id"));
			p.setFirstName(rs.getString("first_name"));
			p.setLastName(rs.getString("last_name"));
			p.setEmail(rs.getString("email"));
			p.setMobileNo(rs.getString("mobile_no"));
			p.setGender(rs.getString("gender"));

			return p;
		}

	}

	@Override
	public Patient editPatient(int id) {
		System.out.println("Inside editPatient Dao");
		Patient queryForObject = jdbcTemplate.queryForObject("SELECT * FROM hms_db.patient WHERE id=?",
				new PatientRowMapper(),
				id);
		System.out.println("Inside editPatient Dao"+queryForObject);
		return queryForObject;
	}

	@Override
	public void deletePatientById(int id) {
		System.out.println("Inside deletePatientById Dao");
		jdbcTemplate.update("DELETE FROM hms_db.patient WHERE id=?",
				id);		
	}

}
