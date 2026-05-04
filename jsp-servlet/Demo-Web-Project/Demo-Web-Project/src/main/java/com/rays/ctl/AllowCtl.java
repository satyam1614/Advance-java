package com.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.AllowBean;
import com.rays.model.AllowModel;

public class AllowCtl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("AllowView.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String op = request.getParameter("opertion");
		
		AllowModel model = new AllowModel();
		AllowBean bean = new AllowBean();
		
		String allowCode = request.getParameter("allowCode");
		String userName = request.getParameter("userName");
		String source = request.getParameter("source");
		String status = request.getParameter("status");
		
		try {
			bean.setAllowCode(allowCode);
			bean.setUserName(userName);
			bean.setSource(source);
			bean.setStatus(status);
			if (op.equals("save")) {
				model.add(bean);
				request.setAttribute("successMsg", "Allow Added successfully");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());	
		}
		RequestDispatcher rd = request.getRequestDispatcher("AllowView.jsp");
		rd.forward(request, response);
	   
	}

}
