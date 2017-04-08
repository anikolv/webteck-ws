package com.rest.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xmlData")
public class XmlDataDTO {
	
	@XmlElement
	private Status status;
	
	@XmlElement(name = "product")
	private List<Product> products = new ArrayList<>();
	
	@XmlElement
	private String message;
	
	public XmlDataDTO(){}
	
	public XmlDataDTO(List<Product> products, Status status) {
		this.products = products;
		this.status = status;
	}
	
	public XmlDataDTO(Status status, String message) {
		this.status = status;
		this.message = message;
	}
}
