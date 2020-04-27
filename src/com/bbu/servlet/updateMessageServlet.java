package com.bbu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbu.model.UserBean;
import com.bbu.service.UserService;
@WebServlet("/updateMessageServlet")
public class updateMessageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String username =(String)request.getParameter("username");
		String phone = request.getParameter("phone");
		String place = request.getParameter("place");
		String email = request.getParameter("email");
		String sel = request.getParameter("sel");
		System.out.println(sel);
		System.out.println(username);//测试username的值是否传值成功
		UserBean user = new UserBean();
		user.setUsername(username);
		user.setPhone(phone);
		user.setPlace(place);
		user.setEmail(email);
		UserService userService = new UserService();
		if(phone.length()==0||place.length()==0||email.length()==0) {
			    userService.wrong5();
			    request.getRequestDispatcher("/lookMessage/updateMessage.jsp").forward(request, response);
			}else if(userService.updateUser(user)) {
				request.setAttribute("sel", sel);
				userService.right();
				request.getRequestDispatcher("/main.jsp").forward(request, response);
			}
	}

}
