package com.bbu.util;

	import java.io.IOException;
	import java.io.InputStream;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Properties;

	public class SQLHelper {
		private static Connection ct = null;
		private static PreparedStatement ps = null; //PreparedStatement实例包含以编译的SQL语句。就是是语句“准备好”。
		private static ResultSet rs = null;
		private static String driver = "";
		private static String url = "";
		private static String user = "";
		private static String password = "";
		private static Properties pp = null;
		private static InputStream fis = null;
		
		static {
			try {
				pp = new Properties();
				fis = SQLHelper.class.getClassLoader().getResourceAsStream("dbinfo.properties");
				pp.load(fis);
				driver = pp.getProperty("driver");
				url = pp.getProperty("url");
				user = pp.getProperty("user");
				password = pp.getProperty("password");
				Class.forName(driver);
			}catch(Exception e) {
			e.printStackTrace();
			}finally {
				if(fis!=null) {
					try {
						fis.close();
					}catch(IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		//给代码添加try ……catch  选中要添加的代码段，然后点击鼠标右键选择【Sourround with】
		public static Connection getConnection() {
			try {
				ct = DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ct;
			
		}
		public static void close(ResultSet rs,Statement ps,Connection ct) {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ct!=null) {
				try {
					ct.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public static Connection getCt() {
			return ct;
		}
		public static PreparedStatement getPs() {
			return ps;
		}
		public static ResultSet getRs() {
			return rs;
		}
		public static ResultSet executeQuery(String sql,String []parameters) {
			try {
		
				ct = getConnection();
				ps = ct.prepareStatement(sql);
				if(parameters!=null) {
					for(int i=0;i<parameters.length;i++) {
						ps.setString(i+1,parameters[i]);    // 1就是sql的第一个参数的意思，ps.setString(1,id); 就是把Parameters[i]替代1的第一个问号
						 
					}
					
				}
				rs = ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
			
		}
		//parameters --参数
		public static void executeUpdate(String sql,String []parameters) {
			try {
				ct = getConnection();
				ps = ct.prepareStatement(sql);
				if(parameters!=null) {
					for(int i=0;i<parameters.length;i++) {
						ps.setString(i+1,parameters[i]);
					}
					 ps.executeUpdate();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException();
			}finally {
				close(rs,ps,ct);
			}
			
		}
		
}
