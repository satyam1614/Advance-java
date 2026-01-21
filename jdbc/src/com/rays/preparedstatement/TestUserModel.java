

package com.rays.preparedstatement;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testfindByLogin();
		// testfindByPk();
		// testAuthenticate();
		testSearch();
	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(4);
		bean.setFirstname("aman");
		bean.setLastname("sharma");
		bean.setLogin("aman@gmail.com");
		bean.setPassword("aman123");
		bean.setDob(sdf.parse("2004-05-25"));

		model.add(bean);

	}

	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(1);
		bean.setFirstname("satyam");
		bean.setLastname("gupta");
		bean.setLogin("satyam@gmail.com");
		bean.setPassword("satyam1614");
		bean.setDob(sdf.parse("2000-02-16"));

		model.update(bean);
	}

	public static void testDelete() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean.setId(2);

		model.delete(bean);
	}

	public static void testfindByLogin() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.findByLogin("satyam@gmail.com");
		System.out.println(bean.getId());
		System.out.println(bean.getFirstname());
		System.out.println(bean.getLastname());
		System.out.println(bean.getLogin());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());

	}

	public static void testfindByPk() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.findBypk(1);
		System.out.println(bean.getId());
		System.out.println(bean.getFirstname());
		System.out.println(bean.getLastname());
		System.out.println(bean.getLogin());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());
	}

	public static void testAuthenticate() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.authenticate("satyam@gmail.com", "satyam1614");
		System.out.println(bean.getId());
		System.out.println(bean.getFirstname());
		System.out.println(bean.getLastname());
		System.out.println(bean.getLogin());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());

	}

	public static void testSearch() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setFirstname("satyam");

		List list = model.search(bean);

		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();

			System.out.println(bean.getId());
			System.out.println(bean.getFirstname());
			System.out.println(bean.getLastname());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		}

	}
}
