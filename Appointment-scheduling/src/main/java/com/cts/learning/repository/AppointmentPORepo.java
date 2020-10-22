package com.cts.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.learning.model.AppointmentPOEO;

@Repository
public interface AppointmentPORepo extends JpaRepository<AppointmentPOEO, Integer>{

}
