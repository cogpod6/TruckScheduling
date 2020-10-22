package com.cts.learning.service;

import org.springframework.stereotype.Service;

import com.cts.learning.model.AppointmentPO;
import com.cts.learning.model.AppointmentPOEO;

@Service
public class AppointmentPOService {
	
	public AppointmentPO mapToModel (AppointmentPOEO appointmentPOEntity) {
		AppointmentPO appointmentPOModel = new AppointmentPO();
		
		return appointmentPOModel;
	}
	
	public AppointmentPOEO mapToEntity (AppointmentPO appointmentPOModel) {
		AppointmentPOEO appointmentPOEntity =  new AppointmentPOEO();
		
		return appointmentPOEntity;
	}

}
