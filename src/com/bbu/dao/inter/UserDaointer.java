package com.bbu.dao.inter;

import java.util.ArrayList;

import com.bbu.model.CourseBean;
import com.bbu.model.UserBean;

public interface UserDaointer {
	//checkUser
	public boolean checkUser(UserBean user);
	//checkadmin
	public boolean checkUser1(UserBean user);
	//addUsers
	public boolean addUser(UserBean user);
	//updateUser
	public boolean updateUser(UserBean user) ;
	//updatePassword
	public boolean updatePassword(UserBean user);
	//deleteUser
	public boolean deleteUser(String id);
	//getAllUsers
	public ArrayList<UserBean> getAllUsers();
	//getpersonUser
	public ArrayList<UserBean> getPersonUser(UserBean user);
	//getAllxxxByPage
	public ArrayList<UserBean> getAllUsersByPage(int currentPage, int pageSize);
	//getAllXXXCount
	public int getAllUsersCount();
}
