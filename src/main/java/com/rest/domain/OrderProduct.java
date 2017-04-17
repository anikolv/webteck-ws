package com.rest.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="carts_products")
@XmlRootElement(name="products")
public class OrderProduct {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "product_id")
	@XmlElement(name="product")
	private Product product;
	
	@OneToOne
	@JoinColumn(name = "cart_id")
	private Order order;
	
	@Column(name="product_qty")
	private Integer qantity;
	
	@Column(name="product_cost")
	private Float amount;
	
	private Date createdAt = new Date();
	
	private Date updatedAt = new Date();

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getQantity() {
		return qantity;
	}

	public void setQantity(Integer qantity) {
		this.qantity = qantity;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}
}
