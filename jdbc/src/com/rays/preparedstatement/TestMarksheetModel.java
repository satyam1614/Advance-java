package com.rays.preparedstatement;

import java.util.Iterator;
import java.util.List;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
		//testUpdate();
		// testDelete();
		 // testfindByRollNo(); 
//		   testfindByPk();
		Testsearch();
	}

	public static void testAdd() throws Exception {

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();
		
		bean.setId(16);
		bean.setRollNo(115);
		bean.setName("punnit");
		bean.setPhy(50);
		bean.setHindi(40);
		bean.setMaths(55);
		bean.setDept_id(2);
		
		model.add(bean);

	}
	
	public static void testUpdate() throws Exception {
		
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();
		
		bean.setRollNo(115);
		bean.setName("punnit yadav");
		bean.setPhy(50);
		bean.setHindi(40);
		bean.setMaths(55);
		bean.setDept_id(2);
		bean.setId(15);
		
		model.Update(bean);
		
	}
	 public static void testDelete() throws Exception {
		 
		 MarksheetModel model = new MarksheetModel();
		 MarksheetBean bean = new MarksheetBean();
		 
		 bean.setId(6);
		 
		 model.delete(bean);
		 
	 }
	 public static void testfindByRollNo() throws Exception {
		 
		 MarksheetModel model = new MarksheetModel();
		 MarksheetBean bean = new MarksheetBean();
		 
		   System.out.println(bean.getId());
		   System.out.println(bean.getRollNo());
		   System.out.println(bean.getName());
		   System.out.println(bean.getPhy());
		   System.out.println(bean.getHindi());
		   System.out.println(bean.getMaths());
		   System.out.println(bean.getDept_id());
		   
		   bean = model.findByRollNo(115);
	 }
	 public static void  testfindByPk() throws Exception {
		  
		 MarksheetModel model = new MarksheetModel ();
		 MarksheetBean bean = new MarksheetBean();
		 
		    System.out.println(bean.getId());
		    System.out.println(bean.getRollNo());
		    System.out.println(bean.getName());
			   System.out.println(bean.getPhy());
			   System.out.println(bean.getHindi());
			   System.out.println(bean.getMaths());
			   System.out.println(bean.getDept_id());
		 
			   bean = model.findBypk(10);
	 }
	 public static void Testsearch() throws Exception {

		        MarksheetBean bean = new MarksheetBean();
		        MarksheetModel model = new MarksheetModel();
		        
		        bean.setName("p");
		        
		        List list = model.search(bean);
		        
		        Iterator<MarksheetBean> it = list.iterator();
		        while(it.hasNext()) {
		        	bean = it.next();
		            System.out.println("ID: " + bean.getId());
		            System.out.println("Roll No: " + bean.getRollNo());
		            System.out.println("Name: " + bean.getName());
		            System.out.println("Physics: " + bean.getPhy());
		            System.out.println("Hindi: " + bean.getHindi());
		            System.out.println("Maths: " + bean.getMaths());
		            System.out.println("Dept_id: " + bean.getDept_id());
		          
		        }
		    }
		}

