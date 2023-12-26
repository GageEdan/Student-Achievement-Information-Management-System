package org.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.bean.JavaBean;
public class CjZjServlet extends HttpServlet {
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
		String name=request.getParameter("name");
		String num=request.getParameter("num");
		String yw=request.getParameter("yw");
		String sx=request.getParameter("sx");
		String yy=request.getParameter("yy");
		String zf=request.getParameter("zf");
		String bh=request.getParameter("bh");
		HttpServletResponse httpResponse = (HttpServletResponse) response;
			try{
				sql01.openConnection();
				String sql = "INSERT INTO score (xm, xh, yw, sx, yy, zf,bh) VALUES (?, ?, ?, ?, ?, ?,?)";
				PreparedStatement pstmt = sql01.getConnection().prepareStatement(sql); 
	            pstmt.setString(1, name);
	            pstmt.setString(2, num);
	            pstmt.setString(3, yw);
	            pstmt.setString(4, sx);
	            pstmt.setString(5, yy);
	            pstmt.setString(6, zf);
	            pstmt.setString(7, bh);
	            response.flushBuffer();
				int n = pstmt.executeUpdate();
				if(n>0){
					PrintWriter out = httpResponse.getWriter();	        
			        out.println("<script>");
			        out.println("alert('学生成绩添加成功');");
			        out.println("window.location.href='" + ((HttpServletRequest)request).getContextPath()+ "/setting.jsp';");
			        out.println("</script>");
				}
				else{
					PrintWriter out = httpResponse.getWriter();	        
			        out.println("<script>");
			        out.println("alert('学生成绩添加失败');");
			        out.println("window.location.href='" + ((HttpServletRequest)request).getContextPath()+ "/addStudent.jsp';");
			        out.println("</script>");
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
