package com.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.AccessLogBean;
import com.rays.model.AccessLogModel;

@WebServlet("/AccessLogCtl.do")
public class AccessLogCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("AccessLogView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("opertion");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		AccessLogBean bean = new AccessLogBean();
		AccessLogModel model = new AccessLogModel();

		String accessLogCode = request.getParameter("accessLogCode");
		String userName = request.getParameter("userName");
		String accessTime = request.getParameter("accessTime");
		String status = request.getParameter("status");

		try {
			bean.setAccessLogCode(accessLogCode);
			bean.setUserName(userName);
			bean.setAccessTime(sdf.parse(accessTime));
			bean.setStatus(status);
			if (op.equals("save")) {
				model.add(bean);
				request.setAttribute("successMsg", "Access Log Added successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("AccessLogView.jsp");
		rd.forward(request, response);

	}

}
