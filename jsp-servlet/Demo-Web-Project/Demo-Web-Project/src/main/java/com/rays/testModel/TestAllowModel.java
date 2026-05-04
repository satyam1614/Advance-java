package com.rays.testModel;

import java.util.List;

import com.rays.bean.AllowBean;
import com.rays.model.AllowModel;

public class TestAllowModel {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		testSearch();
	}

	public static void testAdd() throws Exception {

		AllowModel model = new AllowModel();

		AllowBean bean = new AllowBean();
		bean.setAllowCode("A101");
		bean.setUserName("Rahul");
		bean.setSource("Web");
		bean.setStatus("Active");

		model.add(bean);

		System.out.println("Data inserted with ID: " + bean.getId());
	}

	public static void testUpdate() throws Exception {

		AllowModel model = new AllowModel();

		AllowBean bean = new AllowBean();
		bean.setId(1); // existing ID
		bean.setAllowCode("A102");
		bean.setUserName("Amit");
		bean.setSource("Mobile");
		bean.setStatus("Inactive");

		model.update(bean);

		System.out.println("Data updated...");
	}

	public static void testDelete() throws Exception {

		AllowModel model = new AllowModel();

		AllowBean bean = new AllowBean();
		bean.setId(1); // existing ID

		model.delete(bean);

		System.out.println("Data deleted...");
	}

	public static void testFindByPk() throws Exception {

		AllowModel model = new AllowModel();

		AllowBean bean = model.findByPk(1);

		if (bean != null) {
			System.out.println("ID: " + bean.getId());
			System.out.println("AllowCode: " + bean.getAllowCode());
			System.out.println("UserName: " + bean.getUserName());
			System.out.println("Source: " + bean.getSource());
			System.out.println("Status: " + bean.getStatus());
		} else {
			System.out.println("Record not found");
		}
	}

	public static void testSearch() throws Exception {

		AllowModel model = new AllowModel();

		AllowBean bean = new AllowBean();
		bean.setUserName("R"); // search by username starting with R

		List<AllowBean> list = model.search(bean, 1, 5);

		for (AllowBean b : list) {
			System.out.println("-----------------------------");
			System.out.println("ID: " + b.getId());
			System.out.println("AllowCode: " + b.getAllowCode());
			System.out.println("UserName: " + b.getUserName());
			System.out.println("Source: " + b.getSource());
			System.out.println("Status: " + b.getStatus());
		}
	}
}
