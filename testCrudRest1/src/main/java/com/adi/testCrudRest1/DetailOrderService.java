package com.adi.testCrudRest1;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

@Service
public class DetailOrderService {
	
//	private static EntityManagerFactory entityManagerFactory =
//	          Persistence.createEntityManagerFactory("example-unit");
	
	@Autowired
	private DetailOrderRepository repo;
	
	@PersistenceContext
	private EntityManager em;
	
	public List<d_order> getAllDetailOrder(){
		return repo.findAll();
	}
	
//	public List<DetailOrderModel> GetDetailOrder1() {
//	      System.out.println("-- executing query --");
//	      EntityManager em = entityManagerFactory.createEntityManager();
//	      Query query = em.createQuery(
//	    		  "SELECT b.order_id, c.customer_id, c.name, a.item_code, d.name, a.qty "
//	    		          + "FROM DetailOrder a "
//	    		          + "JOIN a.HeaderOrder b "
//	    		          + "JOIN b.Customer c "
//	    		          + "JOIN a.item d "
//	    		          + "WHERE d.name IS NOT NULL");
//	      List<DetailOrderModel> resultList = query.getResultList();
//	      resultList.forEach(System.out::println);
//	      em.close();
//	      
//	      return resultList;
//	  }
	
//	public List<d_order> getDetailOrderTest1() {
//	    TypedQuery<d_order> query
//	      = em.createQuery(
//	    		  "SELECT b.order_id, c.customer_id, c.name, a.item_code, d.name, a.qty "
//		          + "FROM d_order a "
//		          + "JOIN a.h_order b "
//		          + "JOIN b.Customer c "
//		          + "JOIN a.item d "
//		          + "WHERE d.name IS NOT NULL"
//	    		  , d_order.class);
//	    List<d_order> resultList = query.getResultList();
//	    System.out.println("resultList : " + resultList);
//	    // Assertions...
//		return resultList;
//	}
	
//	public List<d_order> getDetailOrderTest1() {
//	    TypedQuery<d_order> query
//	      = em.createQuery(
//	    		  "SELECT a.id, b.order_id, b.customer_id "
//		          + "FROM d_order a "
//		          + "JOIN a.h_order b "
//	    		  , d_order.class);
//	    List<d_order> resultList = query.getResultList();
//	    System.out.println("resultList : " + resultList);
//	    // Assertions...
//		return resultList;
//	}
	
//	public List<DetailOrderModel> finddorderjoinednamedqry(){
//		return repo.finddorderjoined();
//	}
	
	//still failed
	public List<DetailOrderModel> getDetailOrderNtve(){
		return repo.getDetailOrderNative();
	}
	
	//native succ
	//normal
	public List<Map> getDetailOrderNvte2(){
		return repo.getDetailOrderNativeMap();
	}
	
	//pagination test 1
	public List<Map> getDetailOrderNvteSorted(){
		return repo.getDetailOrderNativeMapSorted(Pageable.ofSize(2));
	}
	
	public Page<d_order> getAllItemWithPaginationTest1Srvc(Integer page, Integer size){
		Pageable paging = PageRequest.of(page, size);
		return repo.findAllItemsWithPaginationTest1(paging);
	}
	
	public List<Map> getDorderJoinedPaginatedTest1(Integer page, Integer size){
		System.out.println("msk servc");
//		Pageable paging = PageRequest.of(page, size); 
//		return repo.findDorderJoinedWithPaginationTest1(paging);
		return repo.findDorderJoinedWithPaginationTest1();
	}
	

	
}
