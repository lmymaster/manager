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
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		UserService userService = new UserService();
		if("add".equals(type)) {
			String username = request.getParameter("username");
			String password1 = request.getParameter("password1");
			String password2 = request.getParameter("password2");
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			String birth = request.getParameter("year")+"-"+request.getParameter("month")+"-"+request.getParameter("day");
			String nation = request.getParameter("nation");
			String edu = request.getParameter("edu");
			String work = request.getParameter("work");
			String phone = request.getParameter("phone");
			String place = request.getParameter("place");
			String email = request.getParameter("email");
			System.out.println(birth);
		/*	ArrayList<UserBean> allusers = userService.getAllUsers(); 
		     for(int i=0;i<allusers.size();i++){
		    UserBean user1 = allusers.get(i); }                  //�����ݿ���ȡ��ȫ������;�����ݿ��ȡusername��ֵ�������ж�ע���û����Ƿ��Ѵ�
		    System.out.println(user1.getUsername());*/
			UserBean user = new UserBean();
			user.setUsername(username);
			user.setPassword(password1);
			user.setPassword(password2);                                                                                                                                                                                                                                                                                                                                                                 
			user.setName(name);
			user.setSex(sex);
			user.setBirth(birth);
			user.setNation(nation);
			user.setEdu(edu);
			user.setWork(work);
			user.setPhone(phone);
			user.setPlace(place);
			user.setEmail(email);
			ArrayList<UserBean> allusers = userService.getAllUsers(); 
		    for(int i=0;i<allusers.size();i++){
		    	UserBean user1 = allusers.get(i);                 //�����ݿ���ȡ��ȫ������;�����ݿ��ȡusername��ֵ�������ж�ע���û����Ƿ����           	
		    	if(username.length()==0||password1.length()==0||password2.length()==0
				||name.length()==0||phone.length()==0||place.length()==0){
					userService.wrong2();
					request.getRequestDispatcher("/register.jsp").forward(request, response);
				}else if(!(password1.equals(password2))) {
					userService.wrong4();
					request.getRequestDispatcher("/register.jsp").forward(request, response);
				
			   }else if(username.equals(user1.getUsername())){ 
				    request.setAttribute("message1", "�û��Ѵ��ڣ�������ע��");
				    request.getRequestDispatcher("/register.jsp").forward(request, response);
					      
			   }else if(userService.addUser(user)) {
					request.setAttribute("message", "ע��ɹ��������µ�¼");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					    }
					       
			      }
		    }    
	  }
}


