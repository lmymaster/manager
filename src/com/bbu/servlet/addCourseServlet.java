package com.bbu.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbu.model.CourseBean;
import com.bbu.service.CourseService;

/**
 * Servlet implementation class addCourseServlet
 */
@WebServlet("/addCourseServlet")
public class addCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String type1 = request.getParameter("type");
		CourseService courseService = new CourseService();
		if("add".equals(type1)) {
			String cid = request.getParameter("cid");
			String cname = request.getParameter("cname");
			String type = request.getParameter("type");
			String credit = request.getParameter("credit");
			//封装数据
			CourseBean nn = new CourseBean();
			nn.setCid(cid);
			nn.setCname(cname);
			nn.setType(type);                                                                                                                                                                                                                                                                                                                                                                 
			nn.setCredit(credit);
			ArrayList<CourseBean> allcourse = courseService.getAllcourse();
			if(cid.length()==0||cname.length()==0){
						courseService.wrong2();
						request.getRequestDispatcher("/lookCourse/addcourse.jsp").forward(request, response);
			}else if(courseService.addCourse(nn)) {
				request.setAttribute("message", "课程添加成功");
				request.getRequestDispatcher("/adminmain.jsp").forward(request, response);
	        }
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
