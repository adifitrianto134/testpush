package com.adi.testCrudRest1;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SqlResultSetMapping;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
//@NamedNativeQuery(
//    name = "find_all_d_order_joined",
//    query =
//    		"SELECT b.order_id, c.customer_id, c.name as customer_name, a.item_code, d.name as item_name, a.qty "
//    				+ "FROM d_order a "
//    				+ "left join h_order b on a.order_id=b.order_id "
//    				+ "left join customer c on b.customer_id = c.customer_id "
//    				+ "left join item d on a.item_code = d.code",
//    resultSetMapping = "d_order_joined"
//)
//@SqlResultSetMapping(
//    name = "d_order_joined",
//    classes = @ConstructorResult(
//        targetClass = DetailOrderModel.class,
//        columns = {
//            @ColumnResult(name = "order_id", type = Integer.class),
//            @ColumnResult(name = "customer_id", type = Integer.class),
//            @ColumnResult(name = "customer_name", type = String.class),
//            @ColumnResult(name = "item_code", type = Integer.class),
//            @ColumnResult(name = "item_name", type = String.class),
//            @ColumnResult(name = "qty", type = Integer.class)
//        }
//    )
//)

public class d_order {
	
	private Integer id;
	private Integer order_id;
	private Integer item_code;
	private Integer qty;
	
	@ManyToOne
	private h_order headerOrder;
	
	@ManyToOne
	private Item item;
	
	public d_order() {
		
	}
	
	public d_order(Integer id, Integer order_id, Integer item_code, Integer qty) {
		super();
		this.id = id;
		this.order_id = order_id;
		this.item_code = item_code;
		this.qty = qty;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Integer getItem_code() {
		return item_code;
	}
	public void setItem_code(Integer item_code) {
		this.item_code = item_code;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	

}
