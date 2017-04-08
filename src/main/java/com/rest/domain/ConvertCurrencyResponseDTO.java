package com.rest.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmlData")
public class ConvertCurrencyResponseDTO {
	
	@XmlElement
	private Status status;
	
	@XmlElement
	private String message; 
	
	@XmlElement
	private double amount = 0;

	public ConvertCurrencyResponseDTO(Status status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public ConvertCurrencyResponseDTO(double amount, Status status) {
		this.status = status;
		this.amount = amount;
	}
}
