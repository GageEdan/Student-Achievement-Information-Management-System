package org.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bean.JavaBean;
public class UserRename extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
	        JavaBean sql01=new JavaBean();
	        HttpServletResponse httpResponse = (HttpServletResponse) response;
	        String username=request.getParameter("username");
			String password=request.getParameter("password");
			String newusername=request.getParameter("newusername");
			String newpassword=request.getParameter("newpassword");
	        sql01.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=student01");
	        sql01.setUser("sa");
	        sql01.setPassword("123456");  
	        try{
	        sql01.openConnection();						
			String	sql = "UPDATE users SET username = ?,password = ? WHERE username = ? AND password = ? ";
			PreparedStatement pstmt = sql01.getConnection().prepareStatement(sql);
			pstmt.setString(1, newusername);
			pstmt.setString(2, newpassword);
			pstmt.setString(3, username);
			pstmt.setString(4, password);
			int n = pstmt.executeUpdate();
			      if (n > 0) {
			    	  PrintWriter out = httpResponse.getWriter();	        
				        out.println("<script>");
				        out.println("alert('用户信息修改成功');");
				        out.println("window.location.href='" + ((HttpServletRequest)request).getContextPath()+ "/setting.jsp';");
				        out.println("</script>");
			    } else {
			    	PrintWriter out = httpResponse.getWriter();	        
			        out.println("<script>");
			        out.println("alert('用户信息修改失败');");
			        out.println("window.location.href='" + ((HttpServletRequest)request).getContextPath()+ "/userRename.jsp';");
			        out.println("</script>");
			    }						  
		sql01.closeConnection();
		}
		catch(ClassNotFoundException e){			
			e.printStackTrace();
	    	   PrintWriter out = httpResponse.getWriter();	        
		        out.println("<script>");
		        out.println("alert(\"发生异常：\" + e.getMessage());");
		        out.println("window.location.href='" + ((HttpServletRequest)request).getContextPath()+ "/addClass.jsp';");
		        out.println("</script>");
		}
		catch(SQLException e){			
			e.printStackTrace();
	    	   PrintWriter out = httpResponse.getWriter();	        
		        out.println("<script>");
		        out.println("alert(\"发生异常：\" + e.getMessage());");
		        out.println("window.location.href='" + ((HttpServletRequest)request).getContextPath()+ "/addClass.jsp';");
		        out.println("</script>");
		}
		
	}

}
