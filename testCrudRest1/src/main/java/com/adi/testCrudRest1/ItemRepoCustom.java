package com.adi.testCrudRest1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public abstract class ItemRepoCustom implements ItemRepository{
	
//		private EntityManager entityManager;
//		
//		@Override
//		public List<Item> findItemByNameCustom(List<String> names) {
//	        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//	        CriteriaQuery<Item> query = cb.createQuery(Item.class);
//	        Root<Item> user = query.from(Item.class);
//	
//	        Path<String> namePath = user.get("name");
//	
//	        List<Predicate> predicates = new ArrayList<>();
//	        for (String name : names) {
//	            predicates.add(cb.like(namePath, name));
//	        }
//	        query.select(user)
//	            .where(cb.or(predicates.toArray(new Predicate[predicates.size()])));
//	
//	        return entityManager.createQuery(query)
//	            .getResultList();
//		}
}
