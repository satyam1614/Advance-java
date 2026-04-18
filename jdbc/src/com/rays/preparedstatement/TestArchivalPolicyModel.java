package com.rays.preparedstatement;

import java.util.Iterator;
import java.util.List;

public class TestArchivalPolicyModel {
	
	public static void main(String[] args) throws Exception{
		
		//testadd();
		//testupdate();
		//testdelete();
		testfindByPk();
		
	}
	
	public static void testadd()throws Exception {
		
		ArchivalPolicyBean bean = new ArchivalPolicyBean();
		ArchivalPolicyModel model = new ArchivalPolicyModel();
		
		bean.setPolicyId(2);
		bean.setPolicyCode("202");
		bean.setDataType("anjali");
		bean.setArchiveAfterDays("3");
		bean.setStatus("private");
		
		model.add(bean);
	}
	
	public static void testupdate()throws Exception {
		
		ArchivalPolicyBean bean = new ArchivalPolicyBean();
		ArchivalPolicyModel model = new ArchivalPolicyModel();
		
		bean.setPolicyId(1);
		bean.setPolicyCode("203");
		bean.setDataType("pankej");
		bean.setArchiveAfterDays("4");
		bean.setStatus("public");
		
		model.update(bean);
	}
	
	public static void testdelete()throws Exception {
		
		ArchivalPolicyBean bean = new ArchivalPolicyBean();
		ArchivalPolicyModel model =new ArchivalPolicyModel();
		
		bean.setPolicyId(1);
		
		model.delete(bean);
	}
	
	public static void testfindByPk ()throws Exception {
		
		ArchivalPolicyBean bean = new ArchivalPolicyBean();
		ArchivalPolicyModel model = new ArchivalPolicyModel();
		
		bean = model.findBypk(2);
		System.out.println(bean.getPolicyId());
		System.out.println(bean.getPolicyCode());
		System.out.println(bean.getDataType());
		System.out.println(bean.getArchiveAfterDays());
		System.out.println(bean.getStatus());
	}
	
public static void testsearch()throws Exception {
		
		ArchivalPolicyBean bean = new ArchivalPolicyBean();
		ArchivalPolicyModel model = new ArchivalPolicyModel();
		
		bean.setDataType("rakesh");
		
		List list = model.search(bean);
		
		Iterator<ArchivalPolicyBean> it =  list.iterator();
		
		while(it.hasNext()) {
			bean = it.next();
			
			System.out.println(bean.getPolicyId());
			System.out.println(bean.getPolicyCode());
			System.out.println(bean.getDataType());
			System.out.println(bean.getArchiveAfterDays());
			System.out.println(bean.getStatus());
		}
}
}
