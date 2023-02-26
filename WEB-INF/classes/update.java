import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.*;
import java.sql.*;
import java.sql.Connection;


@WebServlet("/update")

public class update extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
	res.setContentType("text/html");		
	PrintWriter out= res.getWriter();
    RequestDispatcher dis2=req.getRequestDispatcher("now");
    RequestDispatcher dis1=req.getRequestDispatcher("/header.html");
    dis1.include(req, res);

   
	HttpSession hs=req.getSession(true);
    String uid=(String)hs.getAttribute("log");
    String nid=req.getParameter("id2");
    String nemail=req.getParameter("email2");
    String npassword=req.getParameter("pasword2");
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		Statement stat=con.createStatement();
		stat.execute("update login set id='"+nid+"',email='"+nemail+"',password='"+npassword+"' where id='"+uid+"'");
      dis2.forward(req, res);
		
	}
		catch(Exception ex)
		{
			out.println(ex);
		}
	}
}	

