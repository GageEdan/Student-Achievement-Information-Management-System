package org.servlet;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.bean.JavaBean;
public class LoginDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
        JavaBean sql01=new JavaBean();
        sql01.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=student01");
        sql01.setUser("sa");
        sql01.setPassword("123456");
		String user=request.getParameter("username");
		String password=request.getParameter("password");
			try{
				sql01.openConnection();
				String sql = "select * from users where username=? and password=?";
				PreparedStatement pstmt = sql01.getConnection().prepareStatement(sql); 
	            pstmt.setString(1, user);
	            pstmt.setString(2, password);
	            ResultSet rs=pstmt.executeQuery();
	            if(rs.next()) {
	            	HttpSession session = request.getSession(true);
	                session.setAttribute("user", user);
	                RequestDispatcher dispatcher =request.getRequestDispatcher("setting.jsp");	
	                dispatcher.forward(request, response);
	            }
	            else {
	            	RequestDispatcher dispatcher =request.getRequestDispatcher("main.jsp");
	            	request.setAttribute("error", "请输入正确的账号密码");
	            	dispatcher.forward(request, response);	            	
				}
	       }
	       catch(ClassNotFoundException e){
	    	   e.printStackTrace();
	    	   response.getWriter().println("发生异常：" + e.getMessage());
	       }
	       catch(SQLException e){
	    	   e.printStackTrace();
	    	   response.getWriter().println("发生异常：" + e.getMessage());
	       }
	}
}
