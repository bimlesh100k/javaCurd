import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;

@WebServlet("/log")

public class log extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
	res.setContentType("text/html");		
	PrintWriter out= res.getWriter();
    String em1= req.getParameter("email");
    String pass1=req.getParameter("password");
    RequestDispatcher dis1=req.getRequestDispatcher("/now");
    RequestDispatcher dis2=req.getRequestDispatcher("/error.html");
	HttpSession hs=req.getSession(true);
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		Statement stat=con.createStatement();
		ResultSet rs=stat.executeQuery("select *from login where id='"+em1+"' && password='"+pass1+"'");
       if (rs.next()) {
				hs.setAttribute("log", em1);
             dis1.forward(req, res);
         } else {
             dis2.forward(req, res);
            
         }
		
	}
		catch(Exception ex)
		{
			out.println(ex);
		}
	}
}	