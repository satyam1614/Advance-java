package com.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.MarksheetBean;
import com.rays.bean.UserBean;
import com.rays.model.MarksheetModel;
import com.rays.model.UserModel;

@WebServlet("/MarksheetCtl.do")
public class MarksheetCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();
		String id = request.getParameter("id");

		if (id != null) {
			try {
				bean = model.findByPk(Integer.parseInt(id));
				request.setAttribute("bean", bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("MarksheetView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		try {

			String rollNo = request.getParameter("rollNo");
			String name = request.getParameter("name");
			String phy = request.getParameter("phy");
			String maths = request.getParameter("maths");
			String hindi = request.getParameter("hindi");

			// Debug
			System.out.println("RollNo from form: " + rollNo);

			if (rollNo != null && !rollNo.isEmpty()) {
				bean.setRollNo(Integer.parseInt(rollNo));
			}

			bean.setName(name);
			bean.setPhy(Integer.parseInt(phy));
			bean.setMaths(Integer.parseInt(maths));
			bean.setHindi(Integer.parseInt(hindi));

			if ("update".equals(op)) {
				bean.setId(Integer.parseInt(request.getParameter("id")));
				model.update(bean);
				request.setAttribute("successMsg", "Updated Successfully");
			} else {
				model.add(bean);
				request.setAttribute("successMsg", "Saved Successfully");
			}

		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("MarksheetView.jsp");
		rd.forward(request, response);
	}

}
