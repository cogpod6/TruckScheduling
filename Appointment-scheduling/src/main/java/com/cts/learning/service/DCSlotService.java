package com.cts.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.learning.model.DCSlots;
import com.cts.learning.model.DCSlotsEO;

@Service
public class DCSlotService {
	
	@Autowired
	DCService dcService;
	
	public DCSlots mapTOModel (DCSlotsEO dcSlotsEntity) {
		DCSlots dcSlotsModel = new DCSlots();
		
		dcSlotsModel.setId(dcSlotsEntity.getId());
		dcSlotsModel.setDc(dcService.mapTOModel(dcSlotsEntity.getDc()) );
		dcSlotsModel.setTimeSlots(dcSlotsEntity.getTimeSlots());
		dcSlotsModel.setMaxTrucks(dcSlotsEntity.getMaxTrucks());
		
		return dcSlotsModel;
	}
	
	public DCSlotsEO mapToEntity (DCSlots dcSlotsModel) {
		DCSlotsEO dcSlotsEntity = new DCSlotsEO();
		
		dcSlotsEntity.setId(dcSlotsModel.getId());
		dcSlotsEntity.setDc(dcService.mapToEntity(dcSlotsModel.getDc()) );
		dcSlotsEntity.setTimeSlots(dcSlotsModel.getTimeSlots());
		dcSlotsEntity.setMaxTrucks(dcSlotsModel.getMaxTrucks());
		
		return dcSlotsEntity;
	}

}
