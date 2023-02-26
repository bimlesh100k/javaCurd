import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;

@WebServlet("/main1")

public class first extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
	res.setContentType("text/html");		
	PrintWriter out= res.getWriter();
	out.println("<table><tr><td>userID</td><td>UserName</td><td>Password</td>");
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		Statement stat=con.createStatement();
		ResultSet rs=stat.executeQuery("select *from login");
		while(rs.next())
		{
			out.println("<tr><td>"+rs.getString(1)+"</td>");
			out.println("<td>"+rs.getString(2)+"</td>");
			out.println("<td>"+rs.getString(3)+"</td>");
			out.println("</tr></table>");
		}
	}
		catch(Exception ex)
		{
			out.println(ex);
		}
	}
}	