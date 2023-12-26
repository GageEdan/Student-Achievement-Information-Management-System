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
public class DelStu extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
	        JavaBean sql01=new JavaBean();
	        HttpServletResponse httpResponse = (HttpServletResponse) response;
	        String bh=request.getParameter("class");
			String xm=request.getParameter("name");
			String xh=request.getParameter("num");
	        sql01.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=student01");
	        sql01.setUser("sa");
	        sql01.setPassword("123456");  
	        try{
	        sql01.openConnection();						
			String	sql = "DELETE FROM score WHERE bh = ? AND xm = ? AND xh = ?;";
			PreparedStatement pstmt = sql01.getConnection().prepareStatement(sql);
			pstmt.setString(1, bh);
			pstmt.setString(2, xm);
			pstmt.setString(3, xh);
			int n = pstmt.executeUpdate();
			      if (n > 0) {
			    	  PrintWriter out = httpResponse.getWriter();	        
				        out.println("<script>");
				        out.println("alert('学生删除成功');");
				        out.println("window.location.href='" + ((HttpServletRequest)request).getContextPath()+ "/stuMove.jsp';");
				        out.println("</script>");
			    } else {
			    	PrintWriter out = httpResponse.getWriter();	        
			        out.println("<script>");
			        out.println("alert('学生删除失败');");
			        out.println("window.location.href='" + ((HttpServletRequest)request).getContextPath()+ "/stuMove.jsp';");
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
