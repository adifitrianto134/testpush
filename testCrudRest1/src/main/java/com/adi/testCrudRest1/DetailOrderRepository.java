package com.adi.testCrudRest1;


import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DetailOrderRepository extends JpaRepository<d_order, Integer>{
	

//	public static void getDetailOrder1() {
//	    TypedQuery<d_order> query
//	      = entityManager.createQuery(
//	          "SELECT b.order_id, c.customer_id, c.name, a.item_code, d.name, a.qty "
//	          + "FROM DetailOrder a "
//	          + "JOIN a.HeaderOrder b "
//	          + "JOIN b.Customer c "
//	          + "JOIN a.item d "
//	          + "WHERE d.name IS NOT NULL", DetailOrder.class);
//	    	List<DetailOrder> resultList = query.getResultList();
//	    
//	    // Assertions...
//	    	return resultList;
//	}
	
//	 public void GetDetailOrder1() {
//	      System.out.println("-- executing query --");
//	      EntityManager em = entityManagerFactory.createEntityManager();
//	      Query query = em.createQuery(
//	    		  "SELECT b.order_id, c.customer_id, c.name, a.item_code, d.name, a.qty "
//	    		          + "FROM DetailOrder a "
//	    		          + "JOIN a.HeaderOrder b "
//	    		          + "JOIN b.Customer c "
//	    		          + "JOIN a.item d "
//	    		          + "WHERE d.name IS NOT NULL");
//	      List<DetailOrder> resultList = query.getResultList();
//	      resultList.forEach(System.out::println);
//	      em.close();
//	  }
	//test NamedNativeQuery
//	@Query(name = "find_all_d_order_joined", nativeQuery = true)
//    List<DetailOrderModel> finddorderjoined(
////       @Param("order_id") String order_id,
////       @Param("customer_id") Set<String> customer_id,
////       @Param("customer_name") String customer_name,
////       @Param("item_code") Set<String> item_code,
////       @Param("item_name") String item_name,
////       @Param("qty") Set<String> qty
//    );
	
//	private Integer order_id;
//	private Integer customer_id;
//	private String customer_name;
//	private Integer item_code;
//	private String item_name;
//	private Integer qty;
	
	
		//native, still failed
		@Query(value = "SELECT b.order_id, c.customer_id, c.name as customer_name, a.item_code, d.name as item_name, a.qty "
				+ "FROM d_order a "
				+ "left join h_order b on a.order_id=b.order_id "
				+ "left join customer c on b.customer_id = c.customer_id "
				+ "left join item d on a.item_code = d.code", 
		nativeQuery = true)
		List<DetailOrderModel> getDetailOrderNative();
			
		//native, succ
		//normal joined
		@Query(value = "SELECT b.order_id, c.customer_id, c.name as customer_name, a.item_code, d.name as item_name, a.qty "
				+ "FROM d_order a "
				+ "left join h_order b on a.order_id=b.order_id "
				+ "left join customer c on b.customer_id = c.customer_id "
				+ "left join item d on a.item_code = d.code", 
		nativeQuery = true)
		List<Map> getDetailOrderNativeMap();
		
		//pagination test 1
		@Query(value = "SELECT b.order_id, c.customer_id, c.name as customer_name, a.item_code, d.name as item_name, a.qty "
				+ "FROM d_order a "
				+ "left join h_order b on a.order_id=b.order_id "
				+ "left join customer c on b.customer_id = c.customer_id "
				+ "left join item d on a.item_code = d.code", 
		nativeQuery = true)
		List<Map> getDetailOrderNativeMapSorted(Pageable pageable);
		
		//pagination test 2
		@Query(value = "SELECT * FROM d_order", 
	    //countQuery = "SELECT count(*) FROM d_order", 
	    nativeQuery = true)
		Page<d_order> findAllItemsWithPaginationTest1(Pageable pageable);
		
		//pagination test 3
		@Query(value = "SELECT b.order_id, c.customer_id, c.name as customer_name, a.item_code, d.name as item_name, a.qty "
				+ "FROM d_order a "
				+ "left join h_order b on a.order_id=b.order_id "
				+ "left join customer c on b.customer_id = c.customer_id "
				+ "left join item d on a.item_code = d.code", 
		nativeQuery = true)
//		Page<Map> findDorderJoinedWithPaginationTest1(Pageable pageable);
		List<Map> findDorderJoinedWithPaginationTest1();
		
		
}
