package com.adi.testCrudRest1;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	//------------------------Basic Select-----------------------//
	//jpql 
	@Query("SELECT u FROM Item u WHERE u.code = 3")
	List<Item> findItemWithCode3();
	
	//jpql
	@Query("SELECT u.desc FROM Item u")
	List<String> getAllItemDescJpql();
	
	//native 
	@Query(value = "SELECT * FROM item WHERE name = 'item2zz'", 
	nativeQuery = true)
	List<Item> findItem2Native();
	
	//netive 
	@Query(value = "SELECT name from item", 
	nativeQuery = true)
	List<String> getAllItemNameNative();
	
	
	//---------------------Pagination / Pageable ---------------------------//
	//jpql
	@Query("SELECT u FROM Item u")
	List<Item> getAllItemPagedJpql(Pageable pageable);
	
	//native
	@Query(value="SELECT name FROM item WHERE name like '%2%'", nativeQuery = true)
	List<String> getItemNameaa(Pageable pageable);
	
	
	//----------------------------Sort------------------------------//
	//jpql
	@Query("SELECT u FROM Item u")
	List<Item> getAllItemSortedJpql(Sort sort);
	
	
	//-----------------------native with indexed parameter------------------------------//
	//native
	@Query(value = "SELECT * FROM item WHERE code = ?1", 
	 nativeQuery = true)
	Item getItemCodeIndexedNative(Integer code);
	
	//jpql
	@Query("SELECT u FROM Item u WHERE u.code = ?1 and u.name = ?2")
	Item getItemCodeNameIndexedJpql(Integer code, String name);
	
	//jpql
	@Query("SELECT u FROM Item u WHERE u.name like '%2%'")
	List<Item> getItemIndexedSortedJpql(String name, Sort sort);

	
	//custom repo
//	List<Item> findItemByNameCustom(List<String> emails);
	
	/*
	//native with param 2
	@Query(value = "SELECT * FROM Users u WHERE u.status = :status and u.name = :name", 
	nativeQuery = true)
	Item findUserByStatusAndNameNamedParamsNative(
	@Param("status") Integer status, @Param("name") String name);
	
	//jpql with more than 1 param
	@Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
	Item findUserByStatusAndNameNamedParams(
    @Param("status") Integer status, 
    @Param("name") String name);
	
	*/
	
	
	/*public List<User> findUserByEmails(Set<String> emails) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> user = query.from(User.class);

        Path<String> emailPath = user.get("email");

        List<Predicate> predicates = new ArrayList<>();
        for (String email : emails) {
            predicates.add(cb.like(emailPath, email));
        }
        query.select(user)
            .where(cb.or(predicates.toArray(new Predicate[predicates.size()])));

        return entityManager.createQuery(query)
            .getResultList();
    }*/
}
