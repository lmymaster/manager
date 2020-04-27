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
		private static PreparedStatement ps = null; //PreparedStatementʵ�������Ա����SQL��䡣��������䡰׼���á���
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
		//����������try ����catch  ѡ��Ҫ���ӵĴ���Σ�Ȼ��������Ҽ�ѡ��Sourround with��
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
						ps.setString(i+1,parameters[i]);    // 1����sql�ĵ�һ����������˼��ps.setString(1,id); ���ǰ�Parameters[i]���1�ĵ�һ���ʺ�
						 
					}
					
				}
				rs = ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
			
		}
		//parameters --����
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