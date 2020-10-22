package com.cts.learning.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.learning.model.Appointment;
import com.cts.learning.service.AppointmentService;

@RestController
@RequestMapping("appointment")
public class ApptController {
	
	@Autowired
	AppointmentService appointmentService;
	
	@GetMapping
	public String getAppointment () {
		return "Get Appointment by Id";
	}
	
	@PostMapping
	public ResponseEntity<Appointment> createAppointment (@RequestBody Appointment appointment) {
		ResponseEntity<Appointment> response = null;
		Appointment responseModel = appointmentService.createAppointment(appointment);
		if (null != responseModel) {
			response = ResponseEntity.status(HttpStatus.CREATED).body(responseModel) ;
		} else {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body(null);
		}
		return response;
	}
	
	@PutMapping
	public String updateAppointment () {
		return "update appointment";
	}
	
	@DeleteMapping
	public String deleteAppointment () {
		return "delete appointment";
	}

}
