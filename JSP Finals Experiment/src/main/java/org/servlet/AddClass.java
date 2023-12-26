package org.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.bean.JavaBean;
public class AddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
        JavaBean sql01=new JavaBean();
        sql01.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=student01");
        sql01.setUser("sa");
        sql01.setPassword("123456");
		String bjbh=request.getParameter("bjbh");
		String bjmc=request.getParameter("bjmc");
		HttpServletResponse httpResponse = (HttpServletResponse) response;
			try{
				sql01.openConnection();
				String sql = "INSERT INTO class (bjbh, bjmc) VALUES (?, ?)";
				PreparedStatement pstmt = sql01.getConnection().prepareStatement(sql); 
	            pstmt.setString(1, bjbh);
	            pstmt.setString(2, bjmc);	        
	            response.flushBuffer();
				int n = pstmt.executeUpdate();
				if(n>0){
					PrintWriter out = httpResponse.getWriter();	        
			        out.println("<script>");
			        out.println("alert('班级添加成功');");
			        out.println("window.location.href='" + ((HttpServletRequest)request).getContextPath()+ "/setting.jsp';");
			        out.println("</script>");
				}
				else{
					PrintWriter out = httpResponse.getWriter();	        
			        out.println("<script>");
			        out.println("alert('班级添加失败');");
			        out.println("window.location.href='" + ((HttpServletRequest)request).getContextPath()+ "/addClass.jsp';");
			        out.println("</script>");
				}
	       }
	       catch(ClassNotFoundException e){
	    	   e.printStackTrace();
	    	   PrintWriter out = httpResponse.getWriter();	        
		        out.println("<script>");
		        out.println("alert(\"发生异常：\" + e.getMessage());");
		        out.println("window.location.href='" + ((HttpServletRequest)request).getContextPath()+ "/setting.jsp';");
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
			finally {
	            // 在 finally 块中确保关闭连接
	            try {
	                if (sql01 != null) {
	                    sql01.closeConnection();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace(); // 记录到日志
	            }
			}  
	}
	
}
