package com.hms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hms.model.Patient;
import com.hms.service.PatientService;

@Controller
public class PatientController {

	@Autowired
	private PatientService patientService;

	@RequestMapping("/home")
	public String showTestJsp(Model m) {

		System.out.println("Inside show TestJsp");
		m.addAttribute("editPatient",new Patient());
		return "/patient/addPatient";
	}


	@RequestMapping(path="/getSave", method=RequestMethod.POST) 
	public String save(@Valid @ModelAttribute("editPatient") Patient newPatient, BindingResult errors) {

		System.out.println("Inside save mvcFlow");
		if(errors.hasErrors())
		{
			/*
			 * if(true) throw new RuntimeException();
			 */
			return "/patient/addPatient";
		}
		System.out.println(newPatient); 
		patientService.save(newPatient); 

		return "redirect:getAllPatient";
	}

	@RequestMapping(path="/getAllPatient", method=RequestMethod.GET) 
	public String allPatient(Model m) {

		System.out.println("Inside allPatient Controller");
		List<Patient> allPatient = patientService.allPatient(); 

		m.addAttribute("allPatient", allPatient);

		System.out.println("after getAllPatient");
		return "/patient/allPatient";

	}

	@RequestMapping(path="/getEdit", method=RequestMethod.GET) 
	public String getEditPatient(@RequestParam int id,Model m) {

		System.out.println("Inside editPatient Controller"+id);
		Patient editPatient = patientService.editPatient(id); 

		m.addAttribute("editPatient",editPatient);

		System.out.println("after editPatient");

		return "/patient/addPatient";

	}

	@RequestMapping(path="/getDelete", method=RequestMethod.GET) 
	public String getDeletePatientById(@RequestParam int id,Model m) {

		System.out.println("Inside getDeletePatientById Controller"+id);
		patientService.deletePatientById(id); 
		System.out.println("after getDeletePatientById");

		return "redirect:getAllPatient";

	}


	@ExceptionHandler(value = Exception.class) 
	public String handleException() {
		return "error"; 
	}



}
