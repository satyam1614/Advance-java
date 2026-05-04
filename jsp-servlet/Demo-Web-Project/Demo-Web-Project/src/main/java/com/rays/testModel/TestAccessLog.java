package com.rays.testModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.rays.bean.AccessLogBean;
import com.rays.model.AccessLogModel;

public class TestAccessLog {

    public static void main(String[] args) throws Exception {

        // testAdd();
        // testUpdate();
        // testDelete();
        // testFindByPk();
        testSearch();
    }

    public static void testAdd() throws Exception {

        AccessLogModel model = new AccessLogModel();
        AccessLogBean bean = new AccessLogBean();

        bean.setAccessLogCode("AL101");
        bean.setUserName("Rahul");
        bean.setAccessTime(new Date());
        bean.setStatus("Success");

        model.add(bean);

        System.out.println("Add method executed...");
    }

    public static void testUpdate() throws Exception {

        AccessLogModel model = new AccessLogModel();
        AccessLogBean bean = new AccessLogBean();

        bean.setId(1); // existing ID
        bean.setAccessLogCode("AL102");
        bean.setUserName("Amit");
        bean.setAccessTime(new Date());
        bean.setStatus("Failed");

        model.update(bean);

        System.out.println("Update method executed...");
    }

    public static void testDelete() throws Exception {

        AccessLogModel model = new AccessLogModel();
        AccessLogBean bean = new AccessLogBean();

        bean.setId(1); // existing ID

        model.delete(bean);

        System.out.println("Delete method executed...");
    }

    public static void testFindByPk() throws Exception {

        AccessLogModel model = new AccessLogModel();

        AccessLogBean bean = model.findByPk(1);

        if (bean != null) {
            System.out.println("ID: " + bean.getId());
            System.out.println("Code: " + bean.getAccessLogCode());
            System.out.println("User: " + bean.getUserName());
            System.out.println("Time: " + bean.getAccessTime());
            System.out.println("Status: " + bean.getStatus());
        } else {
            System.out.println("Record not found...");
        }
    }

    public static void testSearch() throws Exception {

        AccessLogModel model = new AccessLogModel();
        AccessLogBean bean = new AccessLogBean();

        bean.setUserName("Rah"); // search by name prefix

        List<AccessLogBean> list = model.search(bean, 1, 10);

        for (AccessLogBean b : list) {
            System.out.println("----------------------------");
            System.out.println("ID: " + b.getId());
            System.out.println("Code: " + b.getAccessLogCode());
            System.out.println("User: " + b.getUserName());
            System.out.println("Time: " + b.getAccessTime());
            System.out.println("Status: " + b.getStatus());
        }
    }
}
