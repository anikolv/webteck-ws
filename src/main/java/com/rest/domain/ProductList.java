package com.rest.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "products")
public class ProductList {
	
	@XmlElement(name = "product")
	public List<Product> products = new ArrayList<>();
	
	public ProductList(List<Product> products) {
		this.products = products;
	}
	
	public ProductList(){}

}
