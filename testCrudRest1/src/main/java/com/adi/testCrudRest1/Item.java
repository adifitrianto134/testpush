package com.adi.testCrudRest1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Item {
	
	private Integer code;
	private String name;
	private String desc;
	
	@ManyToMany
	private h_order detailOrder;
	
	public Item() {
		
	}
	
	public Item(Integer code, String name, String desc) {
		super();
		this.code = code;
		this.name = name;
		this.desc = desc;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
