

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.Connection;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class LoginDemo
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/sur" })
public class LoginDemo extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String u=request.getParameter("t1");
		String p=request.getParameter("t2");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","Suryamona2000");
			Statement st=con.createStatement();
			String sql="insert into users values('"+u+"',"+p+")";
			int ctr=st.executeUpdate(sql);
			if(ctr>0)
			{
				out.println("DATA INSERTED");
			}
			else
			{
				out.println("NOT INSERT");
			}
		}
		catch(Exception e)
		{
			out.println(e);		
		}
	}
}
