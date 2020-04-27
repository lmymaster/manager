package com.bbu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bbu.dao.inter.UserDaointer;
import com.bbu.model.UserBean;
import com.bbu.util.SQLHelper;

public class UserDaoimpl implements UserDaointer{

	@Override
	public boolean checkUser(UserBean user) {
		boolean flag = false;
		String sql = "select * from user where username = ? and password = ?";  
		String []parameters = {user.getUsername(),user.getPassword()};
		ResultSet rst = SQLHelper.executeQuery(sql, parameters);
		try {
			if(rst.next()) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SQLHelper.close(rst, SQLHelper.getPs(), SQLHelper.getCt());
		}
		return flag;
	}

	@Override
	public boolean checkUser1(UserBean user) {
		boolean flag = false;  
		String sql = "select * from admin where admin_id = ? and password = ?";  
		String []parameters = {user.getUsername(),user.getPassword()};
		ResultSet rst = SQLHelper.executeQuery(sql, parameters);
		try {
			if(rst.next()) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SQLHelper.close(rst, SQLHelper.getPs(), SQLHelper.getCt());
		}
		return flag;
	}

	@Override
	public boolean addUser(UserBean user) {
		boolean b = false;
		String sql = "insert into user(username,password,name,sex,birth,nation,edu,work,phone,place,email) "
				+ "value(?,?,?,?,?,?,?,?,?,?,?)";
			String []parameters = {user.getUsername(), user.getPassword(), user.getName(),
				user.getSex(),user.getBirth(), user.getNation(), user.getEdu(),
				user.getWork(), user.getPhone(), user.getPlace(), user.getEmail()};
				
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
	public boolean updateUser(UserBean user) {
		boolean b = false;
		String sql = "update user set phone=?,place=?,email=? where username=?";
			String []parameters = {user.getPhone(), user.getPlace(), user.getEmail(),user.getUsername()};
				
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
	public boolean updatePassword(UserBean user) {
		boolean b = false;
		String sql = "update user set password=? where username=?";
			String []parameters = {user.getPassword(),user.getUsername()};
				
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
	public boolean deleteUser(String id) {
		boolean b = false;
		String sql = "delete from user where username =?";
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
	public ArrayList<UserBean> getAllUsers() {
		ArrayList<UserBean> allusers = new ArrayList<UserBean>();	/*ArrayList<User>()方法是ArrayList的构造方法，即为创建一个ArrayList的对象，只允许存放User对象的容器。
		实例化一个user用户集合对象*/
        String sql = "select * from user";
        String []parameters = null;
        ResultSet rs = SQLHelper.executeQuery(sql, parameters);
        try {
        while(rs.next()) {
        UserBean user1 = new UserBean();
        user1.setUsername(rs.getString(1));
        user1.setPassword(rs.getString(2));
		user1.setName(rs.getString(3));
		user1.setSex(rs.getString(4));
		user1.setBirth(rs.getString(5));
		user1.setNation(rs.getString(6));
		user1.setEdu(rs.getString(7));
		user1.setWork(rs.getString(8));
		user1.setPhone(rs.getString(9));
		user1.setPlace(rs.getString(10));
		user1.setEmail(rs.getString(11));
		allusers.add(user1);   //把个人信息保存到列表里
		}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}finally {
		SQLHelper.close(rs, SQLHelper.getPs(), SQLHelper.getCt());
		}
		return allusers;
	}

	@Override
	public ArrayList<UserBean> getPersonUser(UserBean user) {
		ArrayList<UserBean> allusers = new ArrayList<UserBean>();	/*ArrayList<User>()方法是ArrayList的构造方法，即为创建一个ArrayList的对象，只允许存放User对象的容器。
		实例化一个user用户集合对象*/
		String sql = "select * from user where username= ? ";
		String []parameters = { user.getUsername()};
		ResultSet rs = SQLHelper.executeQuery(sql, parameters);
		try {
		while(rs.next()) {
		UserBean user2 = new UserBean();
		user2.setUsername(rs.getString(1));
		user2.setPassword(rs.getString(2));
		user2.setName(rs.getString(3));
		user2.setSex(rs.getString(4));
		user2.setBirth(rs.getString(5));
		user2.setNation(rs.getString(6));
		user2.setEdu(rs.getString(7));
		user2.setWork(rs.getString(8));
		user2.setPhone(rs.getString(9));
		user2.setPlace(rs.getString(10));
		user2.setEmail(rs.getString(11));
		allusers.add(user2);   //把个人信息保存到列表里
		}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}finally {
		SQLHelper.close(rs, SQLHelper.getPs(), SQLHelper.getCt());
		}
		return allusers;
	}

	@Override
	public ArrayList<UserBean> getAllUsersByPage(int currentPage, int pageSize) {
		ArrayList<UserBean> allusers = new ArrayList<UserBean>();
		String sql =  "select * from user limit "+(currentPage-1)*pageSize +","+pageSize;
		String []parameters = null;
		 ResultSet rs = SQLHelper.executeQuery(sql, parameters);	
		 try {
				while(rs.next()) {
					UserBean user1 = new UserBean();
					user1.setUsername(rs.getString(1));
					user1.setPassword(rs.getString(2));
					user1.setName(rs.getString(3));
					user1.setSex(rs.getString(4));
					user1.setBirth(rs.getString(5));
					user1.setNation(rs.getString(6));
					user1.setEdu(rs.getString(7));
					user1.setWork(rs.getString(8));
					user1.setPhone(rs.getString(9));
					user1.setPlace(rs.getString(10));
					user1.setEmail(rs.getString(11));
				    allusers.add(user1);   //把个人信息保存到列表里
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
			SQLHelper.close(rs, SQLHelper.getPs(), SQLHelper.getCt());
		}
			return allusers;
	}

	@Override
	public int getAllUsersCount() {
		int count = 0;
		String sql = "select count(*) from user";
		String []parameters = null;
		ResultSet rs = SQLHelper.executeQuery(sql, parameters);
		try {
			if(rs.next()) {
				count =Integer.parseInt(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			SQLHelper.close(SQLHelper.getRs(), SQLHelper.getPs(), SQLHelper.getCt());
		}
		return count;
	}

}
