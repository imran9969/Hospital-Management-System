package com.hms.service.impl;

import java.util.List;

import com.hms.dao.PatientDao;
import com.hms.model.Patient;
import com.hms.service.PatientService;

public class PatientServiceImpl implements PatientService {

	private PatientDao patientDao;

	public PatientServiceImpl(PatientDao patientDao) {
		super();
		this.patientDao = patientDao;
	}

	@Override
	public Patient save(Patient newPatient) {
		System.out.println("inside PatientServiceImpl save");
		patientDao.save(newPatient);
		return newPatient;
	}

	@Override
	public List<Patient> allPatient() {
		System.out.println("Inside allPatient Service");
		List<Patient> allPatient = patientDao.allPatient();
		return allPatient;
	}

	@Override
	public Patient editPatient(int id) {
		System.out.println("Inside editPatient Service");
		Patient patient = patientDao.editPatient(id);
		return patient;
	}

	@Override
	public void deletePatientById(int id) {
		System.out.println("Inside deletePatientById Service");
		patientDao.deletePatientById(id);
	}

}
