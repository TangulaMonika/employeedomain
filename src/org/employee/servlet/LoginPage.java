package org.employee.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class FirstPage
 */
@WebServlet("/FirstPage")
public class LoginPage extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String n = request.getParameter("Sign In");
		String p = request.getParameter("Password");
		System.out.println(String.format("Sign In:%s,Password:%s", n, p));
		// todo validate cridentals
		RequestDispatcher rd = request.getRequestDispatcher("nav.html");
		rd.include(request, response);
		out.close();
	}
}