package com.cts.learning.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.learning.model.Appointment;
import com.cts.learning.model.AppointmentEO;
import com.cts.learning.model.AppointmentPO;
import com.cts.learning.model.AppointmentPOEO;
import com.cts.learning.repository.AppointmentPORepo;
import com.cts.learning.repository.AppointmentRepo;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepo appointmentRepo;
	
	@Autowired
    AppointmentPORepo appointmentPORepo;
	
	@Autowired
	DCService dcService;
	
	@Autowired
	DCSlotService dcSlotService;
	
	@Autowired
	TruckService truckService;
	
	public Appointment createAppointment (Appointment appointmentModel) {
		// check whether the slot count is reached
		// check whether the po is present
		AppointmentEO appointmentEntity = mapToEntity(appointmentModel);
		
		AppointmentEO responseEntity = appointmentRepo.save(appointmentEntity);
		
		List<AppointmentPOEO> appointmentPOEntityList = new ArrayList<>(); 
		for (AppointmentPO appointmentPO : appointmentModel.getAppointmentPOs()) {
			AppointmentPOEO appointmentPOEntity = new AppointmentPOEO();
			
			appointmentPOEntity.setId(appointmentPO.getId());
			appointmentPOEntity.setPoNumber(appointmentPO.getPoNumber());
			appointmentPOEntity.setAppointment(responseEntity);
			
			appointmentPOEntityList.add(appointmentPOEntity);
		}
		
		Iterable<AppointmentPOEO> iterable = () -> new Iterator<AppointmentPOEO>() {
			private int index = 0;
			
			@Override
			public boolean hasNext() {
				return appointmentPOEntityList.size() > index;
			}
			
			@Override
			public AppointmentPOEO next() {
				return appointmentPOEntityList.get(index++);
			}
		};
		
		appointmentPORepo.saveAll(iterable);
		return mapToModel(responseEntity);
	}
	
	public Appointment updateAppointment (Appointment appointmentModel) {
		
		return null;
		
	}
	
	public Appointment deleteAppointment () {
		
		return null;
	}
	
	public AppointmentEO mapToEntity (Appointment appointmentModel) {
		AppointmentEO appointmentEntity =  new AppointmentEO();
		
		appointmentEntity.setId(appointmentModel.getId());
		appointmentEntity.setDcNumber(appointmentModel.getDcNumber());
		appointmentEntity.setDcSlots(dcSlotService.mapToEntity(appointmentModel.getDcSlots()) );
		appointmentEntity.setTruck(truckService.mapToEntity(appointmentModel.getTruck()) );
		try {
			appointmentEntity.setAppointmentDate(new SimpleDateFormat("yyyy-MM-dd").parse(appointmentModel.getDate()) );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return appointmentEntity;
	}
	
	public Appointment mapToModel (AppointmentEO appointmentEntity) {
		Appointment appointmentModel = new Appointment();
		
		appointmentModel.setId(appointmentEntity.getId());
		appointmentModel.setDcNumber(appointmentEntity.getDcNumber());
		appointmentModel.setDcSlots(dcSlotService.mapTOModel(appointmentEntity.getDcSlots()) );
		appointmentModel.setTruck(truckService.mapToModel(appointmentEntity.getTruck()) );
		appointmentModel.setDate(new SimpleDateFormat("yyyy-MM-dd").format(appointmentEntity.getAppointmentDate()) );
		
		return appointmentModel;
	}
	
}
