package com.bbu.service;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.bbu.dao.impl.CourseDaoimpl;
import com.bbu.model.CourseBean;

public class CourseService {
	private CourseDaoimpl courseDao = new CourseDaoimpl();
	public void wrong1() {
		String msg = "用户名和密码不能为空";
		int type = JOptionPane.YES_NO_CANCEL_OPTION;
		String title = "信息提示";
		JOptionPane.showMessageDialog(null, msg, title, type);    //导入Messgage对话框
	}

	public void wrong2() {
		String msg = "不许有空，失败";
		int type = JOptionPane.YES_NO_CANCEL_OPTION;
		String title = "信息提示";
		JOptionPane.showMessageDialog(null, msg, title, type);    //导入Messgage对话框
	}
	public void wrong3() {
		String msg = "用户密码不正确，登录失败";
		int type = JOptionPane.YES_NO_CANCEL_OPTION;
		String title = "信息提示";
		JOptionPane.showMessageDialog(null, msg, title, type);    //导入Messgage对话框
	}	
	public void wrong4() {
		String msg = "两次密码不同，失败";
		int type = JOptionPane.YES_NO_CANCEL_OPTION;
		String title = "信息提示";
		JOptionPane.showMessageDialog(null, msg, title, type);    //导入Messgage对话框
	}	
	public void wrong5() {
		String msg = "不能为空，修改失败";
		int type = JOptionPane.YES_NO_CANCEL_OPTION;
		String title = "信息提示";
		JOptionPane.showMessageDialog(null, msg, title, type);    //导入Messgage对话框
	}	
	public void wrong6() {
		String msg = "没有管理员权限或账户密码错误";
		int type = JOptionPane.YES_NO_CANCEL_OPTION;
		String title = "信息提示";
		JOptionPane.showMessageDialog(null, msg, title, type);    //导入Messgage对话框
	}	
	public void right() {
		String msg = "填写信息合格，修改成功";
		int type = JOptionPane.YES_NO_CANCEL_OPTION;
		String title = "信息提示";
		JOptionPane.showMessageDialog(null, msg, title, type);    //导入Messgage对话框
	}	
	//addcourse
	public boolean addCourse(CourseBean nn) {
		return courseDao.addCourse(nn);
	}
	//deleteCourse
	public boolean deleteCourse(String id) {
		return courseDao.deleteCourse(id);
	}
	//getAllcourse
	public ArrayList<CourseBean> getAllcourse(){
		return courseDao.getAllcourse();
	}
}
