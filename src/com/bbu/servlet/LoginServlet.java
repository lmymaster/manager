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

  @WebServlet("/LoginServlet")   /*ע��  ��Servlet3.0�У�����ʹ�ñ�ע��Annotation������֪������ЩServlet���ṩ�����Լ�������Ϣ��
                                    ֻҪ��Servlet������@webServlet��ע�������ͻ��Զ���ȡ���е���Ϣ��
                                    �����@webServlet������������������URL�ǡ�/LoginServlet��������LoginServlet��ʵ���ṩ����*/
    
public class LoginServlet extends HttpServlet {
	  private  static final long serialVersionUID = 1L;
	 
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   /*������������ͣ�������form����method������������������ͣ�Ĭ��Ϊdoget().��
		                                                                                                                   HTTPServlet���excute������ѡ����ö�Ӧ�ķ�����*/
		// ��login.jspҳ���ȡ��½�û��������롢
		request.setCharacterEncoding("utf-8"); //��ֹ����
		String sel=request.getParameter("sel");
		
		HttpSession session=request.getSession(true);
        String svcode = (String)session.getAttribute("vcode");
		 System.out.println(svcode);  //��֤ vcode�Ƿ�ֵ����
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String vcode = request.getParameter("vcode");
		System.out.println(vcode);
		
		//����userService�࣬ҵ���߼���
		UserService userService = new UserService();
		//��װuser����½����
			UserBean user = new UserBean();
			user.setUsername(username);
			user.setPassword(password);
		//��֤��¼�Ƿ�Ϸ�	
		if(username.trim().length()==0||password.trim().length()==0){
			userService.wrong1();
			request.setAttribute("message", "�������û���������");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
			return;
		
		}else if(vcode.equals(svcode.toLowerCase())) {
		    if(sel.equals("student")) { 
			if(userService.checkUser(user)) {
			//�Ϸ���������ݿ���ȡ��ȫ�����ݣ�ֲ��request��attribute���У�ҳ����ת��main.jsp
		  /*  ArrayList<UserBean> allusers = userService.getAllUsers();
			request.setAttribute("allusers",allusers);  */
			ArrayList<UserBean> allusers = userService.getPersonUser(user);
		  session.setAttribute("sel", sel);
			request.setAttribute("allusers",allusers);
			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			}else {
				//�Ƿ��������¶�λ����¼ҳ��
				userService.wrong3();
				request.setAttribute("message", "��������ȷ�û���������");
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
			request.setAttribute("message", "�������֤��");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}
	  } 
	
}
