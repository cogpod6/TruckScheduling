package com.cts.learning.model;

import java.util.Date;

import lombok.Data;

@Data
public class PO {
	
	private String poNumber;
	private Date poDate;
	private String poAddress;
	private Integer orderQuantity;

}
