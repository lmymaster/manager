package com.bbu.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbu.model.PageBean;
import com.bbu.model.UserBean;
import com.bbu.service.UserService;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService userService = new UserService();
//		ArrayList<UserBean> allusers = new ArrayList<UserBean>();
		String currentPage = request.getParameter("currentPage");
		int pageSize = 5;
		//int currentPage,int pageSize,int recordCount,List recordList
		int recordCount = userService.getAllUsersCount();
		ArrayList<UserBean>  allusers = userService.getAllUsersByPage(Integer.parseInt(currentPage), pageSize);
		PageBean pageBean = new PageBean(1,pageSize,recordCount,allusers);
		request.setAttribute("pageBean", pageBean);	
		 request.getRequestDispatcher("/lookMessage/adminlookMessage.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
