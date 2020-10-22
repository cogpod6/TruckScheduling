package com.cts.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.learning.model.AppointmentEO;

@Repository
public interface AppointmentRepo extends JpaRepository<AppointmentEO, Integer> {

}
