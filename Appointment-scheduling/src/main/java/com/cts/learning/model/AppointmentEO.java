package com.cts.learning.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sun.istack.internal.NotNull;

@Entity(name="appointment")
public class AppointmentEO {
	
	@Id
    @NotNull
    @GeneratedValue
    @Column(name = "id")
	private Integer id;
	
	@NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "truck_id")
	private TruckEO truck;
	
	@NotNull
    @Column(name = "dc_number")
	private String dcNumber;
	
	@NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "slot_id")
	private DCSlotsEO dcSlots;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TruckEO getTruck() {
		return truck;
	}

	public void setTruck(TruckEO truck) {
		this.truck = truck;
	}

	public String getDcNumber() {
		return dcNumber;
	}

	public void setDcNumber(String dcNumber) {
		this.dcNumber = dcNumber;
	}

	public DCSlotsEO getDcSlots() {
		return dcSlots;
	}

	public void setDcSlots(DCSlotsEO dcSlots) {
		this.dcSlots = dcSlots;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	@NotNull
	@Column(name = "appointment_date")
	private Date appointmentDate;
	
/*	@OneToMany(mappedBy="appointment", cascade = CascadeType.ALL)
	private List<AppointmentPOEO> appointmentPOs; */

}
