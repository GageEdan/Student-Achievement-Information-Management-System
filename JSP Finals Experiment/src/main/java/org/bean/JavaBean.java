package org.bean;
import java.sql.*;
public class JavaBean {
	private Connection conn;
	private	String url;
	private	String user;
	private	String password;
	private ResultSet rs;
	public JavaBean() {
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void openConnection() throws ClassNotFoundException,SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn=DriverManager.getConnection(url,user,password);
		//System.out.println("数据库连接成功");
	}
	public void closeConnection() throws SQLException {
		 if (conn != null && !conn.isClosed()) {
			 conn.close();
	        }
	}
	public Connection getConnection() {
		return conn;
	}
	public ResultSet executeQueryClass() {
	    String sql = "select * from class where bjbh is not null order by bjbh";
	    try {
	    	PreparedStatement preparedStatement = conn.prepareStatement(sql);
	        rs = preparedStatement.executeQuery();
	        	      
	    } catch (SQLException e) {
	        // 处理异常，可以记录日志或者抛出自定义异常
	        e.printStackTrace();
	    }
	    return rs;
	}
	public ResultSet executeQueryStu() {
	    String sql = "select * from score where xh is not null order by xh";
	    try {
	    	PreparedStatement preparedStatement = conn.prepareStatement(sql);
	        rs = preparedStatement.executeQuery();
	        	      
	    } catch (SQLException e) {
	        // 处理异常，可以记录日志或者抛出自定义异常
	        e.printStackTrace();
	    }
	    return rs;
	}
	public ResultSet executeQueryUser() {
	    String sql = "select * from users where username is not null order by username";
	    try {
	    	PreparedStatement preparedStatement = conn.prepareStatement(sql);
	        rs = preparedStatement.executeQuery();
	        	      
	    } catch (SQLException e) {
	        // 处理异常，可以记录日志或者抛出自定义异常
	        e.printStackTrace();
	    }
	    return rs;
	}
}
