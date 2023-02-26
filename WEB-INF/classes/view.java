import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;

@WebServlet("/view")

public class view extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
	res.setContentType("text/html");		
	PrintWriter out= res.getWriter();
   
    RequestDispatcher dis1=req.getRequestDispatcher("/header.html");
    dis1.include(req, res);

   
	HttpSession hs=req.getSession(true);
    String uid=(String)hs.getAttribute("log");
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		Statement stat=con.createStatement();
		ResultSet rs=stat.executeQuery("select *from login where id='"+uid+"'");
       if (rs.next()) {
            out.println("<ul>");
            out.println("<li>"+rs.getString(1)+"</li>");
            out.println("<li>"+rs.getString(2)+"</li>");    
            out.println("<li>"+rs.getString(3)+"</li>");    
            out.println("</ul>");         
         } 
		
	}
		catch(Exception ex)
		{
			out.println(ex);
		}
	}
}	