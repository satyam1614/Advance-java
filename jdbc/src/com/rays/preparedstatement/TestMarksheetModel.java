package com.rays.preparedstatement;



public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

		//testAdd();
		//testUpdate();
		// testDelete();
		  testfindByRollNo(); 
		   
	}

	public static void testAdd() throws Exception {

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();
		
		bean.setId(15);
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
		 
		    bean = model.findByRollNo(115);
		   System.out.println(bean.getId());
		   System.out.println(bean.getRollNo());
		   System.out.println(bean.getName());
		   System.out.println(bean.getPhy());
		   System.out.println(bean.getHindi());
		   System.out.println(bean.getMaths());
		   System.out.println(bean.getDept_id());
		   
	 }
}
