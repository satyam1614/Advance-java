package com.rays.preparedstatement;

import java.util.Iterator;
import java.util.List;

public class TestUsageModel {
	
	public static void main(String[] args) throws Exception {
		
		//testadd();
		//testupdate();
		//testdelete();
		//testfindByPk();
		testSearch();
	}
	
	public static void testadd()throws Exception {
		
		UsageModel model = new UsageModel();
		UsageBean bean = new UsageBean();
		
		bean.setId(2);
		bean.setCode("3003");
		bean.setName("abhi");
		bean.setType("public");
		bean.setStatus("add");
		
		model.add(bean);
	}
	
	public static void testupdate() throws Exception {
		
		UsageModel model= new UsageModel();
		UsageBean bean = new UsageBean();
		
		bean.setId(1);
		bean.setCode("3001");
		bean.setName("satyam");
		bean.setType("public");
		bean.setType("update");
		
		model.update(bean);
		
	}
	
	public static void testdelete() throws Exception {
		
		UsageBean bean  = new UsageBean();
		UsageModel model =  new UsageModel();
		
		bean.setId(2);
		
		model.delete(bean);
	}
	
	public static void testfindByPk ()throws Exception {
		
		UsageModel model = new UsageModel();
		UsageBean bean = new UsageBean();
		
		bean =model.findByPk(1);
		System.out.println(bean.getId());
		System.out.println(bean.getCode());
		System.out.println(bean.getName());
		System.out.println(bean.getType());
		System.out.println(bean.getStatus());
	}
	
	public static void  testSearch()throws Exception {
		
		UsageBean bean = new UsageBean();
		UsageModel model = new UsageModel();
		
		bean.setName("satyam");
		
		List list = model.search(bean);
		
		Iterator<UsageBean> it = list.iterator();
		
		while (it.hasNext()) {
			bean = it.next();
			
			System.out.println(bean.getId());
			System.out.println(bean.getCode());
			System.out.println(bean.getName());
			System.out.println(bean.getType());
			System.out.println(bean.getStatus());
		}
		
	}

}
