


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")


public class Login extends HttpServlet {
   
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
		 String fname=request.getParameter("fn");
		 String lname=request.getParameter("ln");
		 if(fname.equals("padma")&&lname.equals("anjali")) {
			 response.sendRedirect("wel.jsp");
		 }else response.sendRedirect("err.jsp");
	 }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate username and password (you might want to check against a database)
        boolean isValidUser = true; // Replace with your validation logic

        if (isValidUser) {
            // If login is successful, forward to registration form
            request.setAttribute("username", username);
            request.getRequestDispatcher("registration.jsp").forward(request, response);
        } else {
            // If login fails, redirect back to login page
            response.sendRedirect("form.jsp");
        }
    }
}