package com.rest.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="cart_details")
@XmlRootElement(name="details")
public class OrderDetail {

	@Id
	private Long cartid;
	
	@OneToOne
	@JoinColumn(name = "cartid")
	private Order order;
	
	private String name;
	
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public Long getCartId() {
		return cartid;
	}

	public void setCartId(Long cartid) {
		this.cartid = cartid;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
