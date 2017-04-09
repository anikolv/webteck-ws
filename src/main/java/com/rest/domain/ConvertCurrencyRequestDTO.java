package com.rest.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class ConvertCurrencyRequestDTO {
	
	@XmlElement
	private String fromCurrency;
	
	@XmlElement
	private String toCurrency;
	
	@XmlElement
	private double amount = 0;
	
	public ConvertCurrencyRequestDTO(String fromCurrency, String toCurrency, double amount) {
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.amount = amount;
	}
	
	public ConvertCurrencyRequestDTO(){}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public double getAmount() {
		return amount;
	}
}
