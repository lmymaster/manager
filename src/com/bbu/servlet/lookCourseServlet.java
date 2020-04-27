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
@WebServlet("/lookCourseServlet")
public class lookCourseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sel = request.getParameter("sel");
		CourseService courseService = new CourseService();
		ArrayList<CourseBean> allcourse = courseService.getAllcourse();
		request.setAttribute("allcourse",allcourse);
		request.setAttribute("sel",sel);
		if(sel.equals("student")) {
		request.getRequestDispatcher("/lookCourse/lookCourse.jsp").forward(request,response);
		}else {
		request.getRequestDispatcher("/lookCourse/adminlookCourse.jsp").forward(request,response);	
		}
	}
	

}
