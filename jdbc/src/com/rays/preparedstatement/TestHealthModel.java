package com.rays.preparedstatement;

import java.util.Iterator;
import java.util.List;

public class TestHealthModel {

	public static void main(String[] args) throws Exception {

		//testadd();
		//testupdate();
		//testdelete();
		//findByPk();
		testsearch();
	}

	public static void testadd() throws Exception {

		HealthBean bean = new HealthBean();
		HealthModel model = new HealthModel();

		bean.setId(2);
		bean.setCode("203");
		bean.setName("satyam");
		bean.setUptime("01:30");
		bean.setStatus("general ward");
		
		model.add(bean);

	}
	
	public static void testupdate()throws Exception {
	
		HealthBean bean = new HealthBean();
		HealthModel model = new HealthModel();
		
		bean.setId(1);
		bean.setCode("202");
		bean.setName("rakesh");
		bean.setUptime("12;45");
		bean.setStatus("general ward");
		
		model.update(bean);
		
	}
	
	public static void testdelete()throws Exception {
		
		HealthBean bean = new HealthBean();
		HealthModel model = new HealthModel();
		
		bean.setId(2);
		
		model.delete(bean);
		
	}
	
	public static void findByPk()throws Exception {
		
		HealthBean bean = new HealthBean();
		HealthModel model = new HealthModel();
		
		bean = model.findByPk(1);
		System.out.println(bean.getId());
		System.out.println(bean.getCode());
		System.out.println(bean.getName());
		System.out.println(bean.getUptime());
		System.out.println(bean.getStatus());
		
	}
	
	public static void testsearch()throws Exception {
		
		HealthBean bean = new HealthBean();
		HealthModel model = new HealthModel();
		
		bean.setName("rakesh");
		
		List list = model.search(bean);
		
		Iterator<HealthBean> it =  list.iterator();
		
		while(it.hasNext()) {
			bean = it.next();
			
			System.out.println(bean.getId());
			System.out.println(bean.getCode());
			System.out.println(bean.getName());
			System.out.println(bean.getUptime());
			System.out.println(bean.getUptime());
		}
	}

}
