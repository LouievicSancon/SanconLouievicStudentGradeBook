import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet
{
	String user;
	String password;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		user = request.getParameter("user");
		password = request.getParameter("password");
		if(ValidateServlet.checkUser(user, password)) {
			RequestDispatcher rs = request.getRequestDispatcher("louievic");
			rs.forward(request, response);
		}
		else {
			out.write("<style> label {color:red;}</style><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><h3><center><label>Incorrect username or password</label></center></h3>");
			RequestDispatcher rs = request.getRequestDispatcher("index.html");
			rs.include(request, response);
		}
	}

	public void destroy() {
		user = null;
		password = null;
	}
}
