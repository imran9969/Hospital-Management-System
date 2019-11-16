package com.hms.dao;

import java.util.List;

import com.hms.model.Patient;

public interface PatientDao {

	public Patient save(Patient newPatient);
	
	public List<Patient> allPatient();
	
	public Patient editPatient(int id); 
	
	public void deletePatientById(int id);
	
	
}
