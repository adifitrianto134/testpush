package com.adi.testCrudRest1;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ItemService {
	
	@Autowired
	private ItemRepository repo;
	
	public List<Item> getAllItem(){
		return repo.findAll();
	}
	
	public void saveItem(Item item) {
		repo.save(item);
	}
	
	public Item getItem(Integer id) {
		return repo.findById(id).get();
	}
	
	public void deleteItem(Integer id) {
		repo.deleteById(id);
	}
	
	public List<Item> getItem3(){
		return repo.findItemWithCode3();
	}
	
	public List<Item> getItem2Native(){
		return repo.findItem2Native();
	}
	
	public List<String> getAllItemName(){
		return repo.getAllItemNameNative();
	}
	
	public List<String> getAllItemDess(){
		return repo.getAllItemDescJpql();
	}
	
	public List<Item> getAllItemPaged(Integer page){
		return repo.getAllItemPagedJpql(Pageable.ofSize(page));
	}
	
	public List<Item> getAllItemSorted(){
		return repo.getAllItemSortedJpql(Sort.by("desc"));
	}
	
	public List<String> getItemNameAa(){
		return repo.getItemNameaa(Pageable.ofSize(2));
	}
	
	public Item getItemCodeIndexedWIthNative(Integer code) {
		return repo.getItemCodeIndexedNative(code);
	}
	
	public Item getItemIndexedJpql(Integer code, String name) {
		return repo.getItemCodeNameIndexedJpql(code, name);
	}
	
	public List<Item> getItemIndexedSorted(String nameLike, String sortby) {
		System.out.println("nameLike : " + nameLike);
		return repo.getItemIndexedSortedJpql(nameLike, Sort.by(sortby));
	}
	
	
	
	//custom repo
//	public List<Item> findItemByEmailsCust(List<String> names){
//		return repo.findItemByNameCustom(names);
//	}
}
