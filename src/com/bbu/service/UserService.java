package com.bbu.service;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.bbu.dao.impl.UserDaoimpl;
import com.bbu.model.UserBean;

public class UserService {
	private UserDaoimpl userDao = new UserDaoimpl();
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
	//checkUser
		public boolean checkUser(UserBean user) {
			return userDao.checkUser(user);
		}
		//checkadmin
		public boolean checkUser1(UserBean user) {
			return userDao.checkUser1(user);
		}
		//addUsers
		public boolean addUser(UserBean user) {
			return userDao.addUser(user);
		}
		//updateUser
		public boolean updateUser(UserBean user) {
			return userDao.updateUser(user);
		}
		//updatePassword
		public boolean updatePassword(UserBean user) {
			return userDao.updatePassword(user);
		}
		//deleteUser
		public boolean deleteUser(String id) {
			return userDao.deleteUser(id);
		}
		//getAllUsers
		public ArrayList<UserBean> getAllUsers(){
			return userDao.getAllUsers();
		}
		//getpersonUser
		public ArrayList<UserBean> getPersonUser(UserBean user){
			return userDao.getPersonUser(user);
		}
		//getAllxxxByPage
		public ArrayList<UserBean> getAllUsersByPage(int currentPage, int pageSize){
			return userDao.getAllUsersByPage(currentPage,pageSize);
		}
		//getAllXXXCount
		public int getAllUsersCount() {
			return userDao.getAllUsersCount();
		}
}
