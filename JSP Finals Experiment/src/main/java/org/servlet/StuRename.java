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
public class StuRename extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
	        JavaBean sql01=new JavaBean();
	        HttpServletResponse httpResponse = (HttpServletResponse) response;
	        String newbh=request.getParameter("newbh");
	        String newxm=request.getParameter("newxm");
	        String newxh=request.getParameter("newxh");
	        String newyw=request.getParameter("newyw");
	        String newsx=request.getParameter("newsx");
	        String newyy=request.getParameter("newyy");
	        String newzf=request.getParameter("newzf");	        
	        String bh=request.getParameter("bh");
	        String xm=request.getParameter("xm");
	        String xh=request.getParameter("xh");	        
	        sql01.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=student01");
	        sql01.setUser("sa");
	        sql01.setPassword("123456");  
	        try{
	        sql01.openConnection();						
			String	sql = 
			"UPDATE score SET bh = ?,xm = ?,xh = ?,yw = ?,sx = ?,yy = ?,zf = ? WHERE bh = ? AND xm = ? AND xh = ? ";
			PreparedStatement pstmt = sql01.getConnection().prepareStatement(sql);
			pstmt.setString(1, newbh);
			pstmt.setString(2, newxm);
			pstmt.setString(3, newxh);
			pstmt.setString(4, newyw);
			pstmt.setString(5, newsx);
			pstmt.setString(6, newyy);
			pstmt.setString(7, newzf);
			pstmt.setString(8, bh);
			pstmt.setString(9, xm);
			pstmt.setString(10, xh);
			int n = pstmt.executeUpdate();
			      if (n > 0) {
			    	  PrintWriter out = httpResponse.getWriter();	        
				        out.println("<script>");
				        out.println("alert('学生信息修改成功');");
				        out.println("window.location.href='" + ((HttpServletRequest)request).getContextPath()+ "/stuMove.jsp';");
				        out.println("</script>");
			    } else {
			    	PrintWriter out = httpResponse.getWriter();	        
			        out.println("<script>");
			        out.println("alert('学生信息修改失败');");
			        out.println("window.location.href='" + ((HttpServletRequest)request).getContextPath()+ "/stuRename.jsp';");
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
