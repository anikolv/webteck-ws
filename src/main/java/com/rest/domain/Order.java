package com.rest.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="carts")
@XmlRootElement(name="order")
public class Order {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Float cost;
	
	private String status;
	
	private Date paidAt;
	
	private Date createdAt = new Date();
	
	private Date updatedAt = new Date();
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "order")
	@XmlElement(name = "details")
	private OrderDetail orderDetails;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	@XmlElement(name = "products")
	private List<OrderProduct> orderProducts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getPaidAt() {
		return paidAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setPaidAt(Date paidAt) {
		this.paidAt = paidAt;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}
}
