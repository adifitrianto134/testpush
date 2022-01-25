package com.adi.testCrudRest1;

public class DetailOrderModel {

		private Integer order_id;
		private Integer customer_id;
		private String customer_name;
		private Integer item_code;
		private String item_name;
		private Integer qty;
		
		public DetailOrderModel() {
			
		}
		
		public Integer getOrder_id() {
			return order_id;
		}
		public void setOrder_id(Integer order_id) {
			this.order_id = order_id;
		}
		public Integer getCustomer_id() {
			return customer_id;
		}
		public void setCustomer_id(Integer customer_id) {
			this.customer_id = customer_id;
		}
		public String getCustomer_name() {
			return customer_name;
		}
		public void setCustomer_name(String customer_name) {
			this.customer_name = customer_name;
		}
		public Integer getItem_code() {
			return item_code;
		}
		public void setItem_code(Integer item_code) {
			this.item_code = item_code;
		}
		public String getItem_name() {
			return item_name;
		}
		public void setItem_name(String item_name) {
			this.item_name = item_name;
		}
		public Integer getQty() {
			return qty;
		}
		public void setQty(Integer qty) {
			this.qty = qty;
		}
		
}
