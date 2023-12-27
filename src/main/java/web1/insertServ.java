package web1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web1.fstDAO;

@WebServlet("/NO")
public class insertServ extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		
		String Name = req.getParameter("name");
		String Mail = req.getParameter("mail");
		
		fstDAO s=new fstDAO();
		try {
			s.getdata(Name, Mail);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setContentType("text/html");
		writer.write("<h1><font style='color:red'>USER INSERT SUCCESS</font></h1>");
		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		rd.include(req, resp);
		
		writer.close();
	
		
		
	}
	

}
