package com.bbu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bbu.dao.inter.CourseDaointer;
import com.bbu.model.CourseBean;
import com.bbu.util.SQLHelper;

public class CourseDaoimpl implements CourseDaointer {

	@Override
	public boolean addCourse(CourseBean nn) {
		boolean b = false;
		String sql = "insert into course(cid,cname,type,credit) "
				+ "value(?,?,?,?)";
			String []parameters = {nn.getCid(),nn.getCname(),nn.getType(),nn.getCredit()};			
			try {	
				SQLHelper.executeUpdate(sql, parameters);
			    b = true;
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean deleteCourse(String id) {
		boolean b = false;
		String sql = "delete from course where cid =?";
		String []parameters = {id};
		try {
			SQLHelper.executeUpdate(sql, parameters);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return b;
	}

	@Override
	public ArrayList<CourseBean> getAllcourse() {
		ArrayList<CourseBean> allcourse = new ArrayList<CourseBean>();	/*ArrayList<User>()方法是ArrayList的构造方法，即为创建一个ArrayList的对象，只允许存放User对象的容器。
		实例化一个user用户集合对象*/
		String sql = "select * from course";
		String []parameters = null;
		ResultSet rs = SQLHelper.executeQuery(sql, parameters);
		try {
			while(rs.next()) {
				CourseBean nn = new CourseBean();
				nn.setCid(rs.getString(1));
				nn.setCname(rs.getString(2));
				nn.setType(rs.getString(3));
				nn.setCredit(rs.getString(4));
			    allcourse.add(nn);   //把个人信息保存到列表里
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		SQLHelper.close(rs, SQLHelper.getPs(), SQLHelper.getCt());
	}
		return allcourse;
	}

}
