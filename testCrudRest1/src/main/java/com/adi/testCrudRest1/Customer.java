package com.adi.testCrudRest1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	private Integer customer_id;
	private String name;
	private String email;
	
	@OneToOne(mappedBy = "customer_id")
	private h_order headerOrder;
	
	public Customer() {
		
	}
	
	public Customer(Integer customer_id, String name, String email) {
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
