 package com.bbu.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bbu.model.UserBean;
import com.bbu.service.UserService;

  @WebServlet("/LoginServlet")   /*注解  在Servlet3.0中，可以使用标注（Annotation）来告知容器哪些Servlet会提供服务以及额外信息。
                                    只要在Servlet上设置@webServlet标注，容器就会自动读取当中的信息。
                                    上面的@webServlet告诉容器，如果请求的URL是“/LoginServlet”，则由LoginServlet的实例提供服务*/
    
public class LoginServlet extends HttpServlet {
	  private  static final long serialVersionUID = 1L;
	 
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   /*根据请求的类型（就是你form表单中method属性下面的那请求类型，默认为doget().）
		                                                                                                                   HTTPServlet类的excute方法会选择调用对应的方法。*/
		// 从login.jsp页面获取登陆用户名和密码、
		request.setCharacterEncoding("utf-8"); //防止乱码
		String sel=request.getParameter("sel");
		
		HttpSession session=request.getSession(true);
        String svcode = (String)session.getAttribute("vcode");
		 System.out.println(svcode);  //验证 vcode是否传值过来
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String vcode = request.getParameter("vcode");
		System.out.println(vcode);
		
		//创建userService类，业务逻辑类
		UserService userService = new UserService();
		//封装user，登陆对象
			UserBean user = new UserBean();
			user.setUsername(username);
			user.setPassword(password);
		//验证登录是否合法	
		if(username.trim().length()==0||password.trim().length()==0){
			userService.wrong1();
			request.setAttribute("message", "请输入用户名和密码");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
			return;
		
		}else if(vcode.equals(svcode.toLowerCase())) {
		    if(sel.equals("student")) { 
			if(userService.checkUser(user)) {
			//合法，则从数据库中取出全体数据，植入request的attribute域中，页面跳转到main.jsp
		  /*  ArrayList<UserBean> allusers = userService.getAllUsers();
			request.setAttribute("allusers",allusers);  */
			ArrayList<UserBean> allusers = userService.getPersonUser(user);
		  session.setAttribute("sel", sel);
			request.setAttribute("allusers",allusers);
			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			}else {
				//非法，则重新定位到登录页面
				userService.wrong3();
				request.setAttribute("message", "请输入正确用户名或密码");
				request.getRequestDispatcher("/login.jsp").forward(request,response);
			   }
			 }else if(sel.equals("admin")) {
				if(userService.checkUser1(user)) {
			    ArrayList<UserBean> allusers = userService.getAllUsers();
				request.setAttribute("sel", sel);
				request.setAttribute("allusers",allusers);
				request.getSession().setAttribute("username", username);
				request.getRequestDispatcher("/adminmain.jsp").forward(request, response);
	        }else {
	        	userService.wrong6();
	        	request.getRequestDispatcher("/login.jsp").forward(request,response);
	           }
			}
		}else {
			request.setAttribute("message", "错误的验证码");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}
	  } 
	
}
