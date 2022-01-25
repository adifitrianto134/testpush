package com.adi.testCrudRest1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private DetailOrderService detailOrderService;
	
	@Autowired
	private DetailOrderRepository repoDetailOrder;
	
	@GetMapping("/items")
	public List<Item> getAllItem(){
		return itemService.getAllItem();
	}
	
	@GetMapping("/items/{id}")
	public Item getItem(@PathVariable Integer id) {
		return itemService.getItem(id);
	}
	
	@PostMapping("/AddItem")
	public void addItem(@RequestBody Item item) {
		itemService.saveItem(item);
	}
	
	
	
	//JPQL and Native Query testing
	//========================================================================================
	@GetMapping("/item3")
	public List<Item> getItem3(){
		List<Item> item3 = itemService.getItem3();
		for(int a=0;a<item3.size();a++) {
			System.out.println("code : "+item3.get(a).getCode());
			System.out.println("name : "+item3.get(a).getName());
			System.out.println("desc : "+item3.get(a).getDesc());
		}
		return itemService.getItem3();
	}
	
	@GetMapping("/item2Native")
	public List<Item> item2Native(){
		List<Item> item2Native = itemService.getItem2Native();
		for(int a=0;a<item2Native.size();a++) {
			System.out.println("code : "+item2Native.get(a).getCode());
			System.out.println("name : "+item2Native.get(a).getName());
			System.out.println("desc : "+item2Native.get(a).getDesc());
		}
		return itemService.getItem2Native();
	}
	
	@GetMapping("/itemNames")
	public List<String> getAllItemName(){
		return itemService.getAllItemName();
	}
	
	@GetMapping("/itemDesc")
	public List<String> getAllItemDesc(){
		return itemService.getAllItemDess();
	}
	
	@GetMapping("/pagedItem")
	public List<Item> getAllItemWithPage(){
		return itemService.getAllItemPaged(2);
	}
	
	@GetMapping("/sortedItem")
	public List<Item> getAllItemWithSorted(){
		return itemService.getAllItemSorted();
	}
	
	@GetMapping("/getItemAa")
	public List<String> getItemNameAaNative(){
		return itemService.getItemNameAa();
	}
	
	@GetMapping("/codeIndexedItem")
	public Item getItemIndexedWIthNative() {
		return itemService.getItemCodeIndexedWIthNative(5);
	}
	
	@GetMapping("/getIndexedItem2Param")
	public Item getIndexedItem2ParamJpql() {
		return itemService.getItemIndexedJpql(3, "item3");
	}
	
	@GetMapping("/getItemIndexSort")
	public List<Item> getItemIndexedSort() {
		return itemService.getItemIndexedSorted("2", "name");
	}
	
	@GetMapping("/getDetailOrderNativeTest1")
	public List<DetailOrderModel> getDetailOrderNtvetst() {
		return detailOrderService.getDetailOrderNtve();
	}
	
	//---------------------------------------NATIVE SUCC----------------------------------------------
	//List MAP fill to model
	@GetMapping("/getDetailOrderNativeTest2")
	public List<DetailOrderModel> getDetailOrderNtvets2() {
		
		List<Map> dOrderJoinedData = detailOrderService.getDetailOrderNvte2();
		List<DetailOrderModel> listDetailOrderModel = new ArrayList<DetailOrderModel>();
		
		for(int a=0;a<dOrderJoinedData.size();a++) {
			DetailOrderModel oneDetailOrderModel = new DetailOrderModel();
			oneDetailOrderModel.setOrder_id(Integer.parseInt(dOrderJoinedData.get(a).get("order_id").toString()));
			oneDetailOrderModel.setCustomer_id(Integer.parseInt(dOrderJoinedData.get(a).get("customer_id").toString()));
			oneDetailOrderModel.setCustomer_name(dOrderJoinedData.get(a).get("customer_name").toString());
			oneDetailOrderModel.setItem_code(Integer.parseInt(dOrderJoinedData.get(a).get("item_code").toString()));
			oneDetailOrderModel.setItem_name(dOrderJoinedData.get(a).get("item_name").toString());
			oneDetailOrderModel.setQty(Integer.parseInt(dOrderJoinedData.get(a).get("qty").toString()));
			listDetailOrderModel.add(oneDetailOrderModel);
		}
				
		return listDetailOrderModel;
	}
	
	@GetMapping("/getDetailOrderNativeTestSorted")
	public List<DetailOrderModel> getDetailOrderNtvetSorted(){
		List<Map> dOrderJoinedData = detailOrderService.getDetailOrderNvteSorted();
		List<DetailOrderModel> listDetailOrderModel = new ArrayList<DetailOrderModel>();
		
		for(int a=0;a<dOrderJoinedData.size();a++) {
			DetailOrderModel oneDetailOrderModel = new DetailOrderModel();
			oneDetailOrderModel.setOrder_id(Integer.parseInt(dOrderJoinedData.get(a).get("order_id").toString()));
			oneDetailOrderModel.setCustomer_id(Integer.parseInt(dOrderJoinedData.get(a).get("customer_id").toString()));
			oneDetailOrderModel.setCustomer_name(dOrderJoinedData.get(a).get("customer_name").toString());
			oneDetailOrderModel.setItem_code(Integer.parseInt(dOrderJoinedData.get(a).get("item_code").toString()));
			oneDetailOrderModel.setItem_name(dOrderJoinedData.get(a).get("item_name").toString());
			oneDetailOrderModel.setQty(Integer.parseInt(dOrderJoinedData.get(a).get("qty").toString()));
			listDetailOrderModel.add(oneDetailOrderModel);
		}
		return listDetailOrderModel;
	}
	
	@GetMapping("/GetAllItemPaginationTest1")
	public Page<d_order> getAllItemPaginationTest1(@RequestParam Integer page, @RequestParam Integer size){
		Page<d_order> pageItem = detailOrderService.getAllItemWithPaginationTest1Srvc(page, size);
		System.out.println("msk as");
		return pageItem;
	}
	
	@GetMapping("/GetDorderJoinedPaginationTest1")
	public List<Map> GetDorderJoinedPagedTest1(@RequestParam Integer page, @RequestParam Integer size){
		List<Map> pageDorder = detailOrderService.getDorderJoinedPaginatedTest1(page, size);
		return pageDorder;
	}
	
	@GetMapping("/GetDorderJoinedPaginationTest2")
	public Page<DetailOrderModel> getDorderJoinedPagedTest2(@NotNull final Pageable pageable) {
		List<Map> dOrderJoinedData = detailOrderService.getDetailOrderNvte2();
		List<DetailOrderModel> listDetailOrderModel = new ArrayList<DetailOrderModel>();
		
		for(int a=0;a<dOrderJoinedData.size();a++) {
			DetailOrderModel oneDetailOrderModel = new DetailOrderModel();
			oneDetailOrderModel.setOrder_id(Integer.parseInt(dOrderJoinedData.get(a).get("order_id").toString()));
			oneDetailOrderModel.setCustomer_id(Integer.parseInt(dOrderJoinedData.get(a).get("customer_id").toString()));
			oneDetailOrderModel.setCustomer_name(dOrderJoinedData.get(a).get("customer_name").toString());
			oneDetailOrderModel.setItem_code(Integer.parseInt(dOrderJoinedData.get(a).get("item_code").toString()));
			oneDetailOrderModel.setItem_name(dOrderJoinedData.get(a).get("item_name").toString());
			oneDetailOrderModel.setQty(Integer.parseInt(dOrderJoinedData.get(a).get("qty").toString()));
			listDetailOrderModel.add(oneDetailOrderModel);
		}
		//System.out.println("the size : " + listDetailOrderModel.size());
		
		final int start = (int)pageable.getOffset();
		final int end = Math.min((start + pageable.getPageSize()), listDetailOrderModel.size());
		final Page<DetailOrderModel> resultAsPage = new PageImpl<>(listDetailOrderModel.subList(start, end), pageable, listDetailOrderModel.size());
		
		return resultAsPage;
	}
	
	
//	@GetMapping("/GetDetailOrderTest1")
//	public List<d_order> getDetailOrderTest_1() {
//		return detailOrderService.getDetailOrderTest1();
//	}
	
//	@GetMapping("/getdorderjoinedwithnamedquery")
//	public List<DetailOrderModel> dorderjoinednamedquery(){
//		return detailOrderService.finddorderjoinednamedqry();
//	}

	//custom repo
//	@GetMapping("/getItemsByEmailCustom")
//	public List<Item> findItemByEmailsCustm(){
//		List<String> names = new ArrayList<>();
//		names.add("z");
//		names.add("3");
//		return itemService.findItemByEmailsCust(names);
//	}
	
	//contoh 2 param
	/*@RequestMapping(path = "/mno/objectKey/{id}/{name}", method = RequestMethod.GET)
	public Book getBook(@PathVariable int id, @PathVariable String name) {
	    // code here
	}*/
}
