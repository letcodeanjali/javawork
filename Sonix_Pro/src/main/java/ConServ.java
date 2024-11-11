

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/*
 * Servlet implementation class ConServ
 */
@WebServlet("/ConServ")
public class ConServ extends GenericServlet {
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		pw.print("Hello everyone I connected to my server");
	}

}
