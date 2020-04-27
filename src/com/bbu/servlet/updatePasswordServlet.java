package com.bbu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbu.model.UserBean;
import com.bbu.service.UserService;
@WebServlet("/updatePasswordServlet")
public class updatePasswordServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username1 = request.getParameter("username");
		String sel = request.getParameter("sel");
		String username = java.net.URLDecoder.decode(username1,"UTF-8"); //URLDecoder.decode(String str,String ecn)方法有两个参数，第一个参数为待解码的字符串，
		                                                                    // 第二个参数为解码时的对应编码。 传过来的username为 类此（%E9%BD%90%E5%B3%B0），要进行解码
		System.out.println(username);
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		UserService userService = new UserService();
		UserBean user = new UserBean();
		user.setUsername(username);
		user.setPassword(password1);
		user.setPassword(password2);
		if(password1.length()==0||password2.length()==0){
			userService.wrong2();
			request.getRequestDispatcher("/lookMessage/updatePassword.jsp").forward(request, response);
		}else if(!(password1.equals(password2))) {
			userService.wrong4();
			request.getRequestDispatcher("/lookMessage/updatePassword.jsp").forward(request, response);
		 }else if(userService.updatePassword(user)){
			 userService.right();
			 request.setAttribute("sel", sel);
			 request.getRequestDispatcher("/main.jsp").forward(request, response);
			}
			
	}

}
