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
public class ClassRename extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
	        JavaBean sql01=new JavaBean();
	        HttpServletResponse httpResponse = (HttpServletResponse) response;
	        String bjbh=request.getParameter("bjbh");
			String bjmc=request.getParameter("bjmc");
			String newbjbh=request.getParameter("newbjbh");
			String newbjmc=request.getParameter("newbjmc");
	        sql01.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=student01");
	        sql01.setUser("sa");
	        sql01.setPassword("123456");  
	        try{
	        sql01.openConnection();						
			String	sql = "UPDATE class SET bjbh = ?,bjmc = ? WHERE bjbh = ? AND bjmc = ? ";
			PreparedStatement pstmt = sql01.getConnection().prepareStatement(sql);
			pstmt.setString(1, newbjbh);
			pstmt.setString(2, newbjmc);
			pstmt.setString(3, bjbh);
			pstmt.setString(4, bjmc);
			int n = pstmt.executeUpdate();
			      if (n > 0) {
			    	  PrintWriter out = httpResponse.getWriter();	        
				        out.println("<script>");
				        out.println("alert('班级修改成功');");
				        out.println("window.location.href='" + ((HttpServletRequest)request).getContextPath()+ "/classMove.jsp';");
				        out.println("</script>");
			    } else {
			    	PrintWriter out = httpResponse.getWriter();	        
			        out.println("<script>");
			        out.println("alert('班级修改失败');");
			        out.println("window.location.href='" + ((HttpServletRequest)request).getContextPath()+ "/ClassRename.jsp';");
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
