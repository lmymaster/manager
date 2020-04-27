package com.bbu.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbu.model.UserBean;
import com.bbu.service.UserService;
import com.bbu.model.PageBean;

@WebServlet("/lookMessageServlet")
public class lookMessageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sel = request.getParameter("sel");
		String username = request.getParameter("username");
		//System.out.println(username);
		UserService userService = new UserService();
		
		if(sel.equals("student")) {
			//·â×°user£¬µÇÂ½¶ÔÏó
			UserBean user = new UserBean();
			user.setUsername(username);
			ArrayList<UserBean> allusers = userService.getPersonUser(user);
			request.setAttribute("allusers",allusers);
			request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("sel", sel);
			request.getRequestDispatcher("/lookMessage/lookMessage.jsp").forward(request,response);
		
		}else {
			 //ArrayList<UserBean> allusers = userService.getAllUsers();
			int pageSize = 5;
			//int currentPage,int pageSize,int recordCount,List recordList
			int recordCount = userService.getAllUsersCount();
			System.out.println(recordCount);
			ArrayList<UserBean>  allusers = userService.getAllUsersByPage(1, pageSize);
			PageBean pageBean = new PageBean(1,pageSize,recordCount,allusers);
			request.setAttribute("pageBean", pageBean);	
			// request.setAttribute("allusers",allusers);
			 request.getRequestDispatcher("/lookMessage/adminlookMessage.jsp").forward(request,response);
		}
	}

}
