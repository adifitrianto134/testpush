package com.adi.testCrudRest1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class h_order {
	
	private Integer order_id;
	private Integer customer_code;
	private String notes;
	
	@OneToOne(mappedBy = "customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy = "order_id")
	private d_order detailOrder;
	
	public h_order() {
		
	}
	
	public h_order(Integer order_id, Integer customer_code, String notes) {
		super();
		this.order_id = order_id;
		this.customer_code = customer_code;
		this.notes = notes;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Integer getCustomer_code() {
		return customer_code;
	}
	public void setCustomer_code(Integer customer_code) {
		this.customer_code = customer_code;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
