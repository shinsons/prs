import java.io.*;
import java.net.UnknownHostException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

@WebServlet("/service/login") 
public class Login extends HttpServlet {

	private UserDAO user_ds;

	@Override
	public void init() throws ServletException {
		// setup DB connection and setup UserDAO
		Morphia morphia = new Morphia();
		morphia.map(User.class);
		try{
			Mongo mongo = new Mongo();
			user_ds = new UserDAO(morphia, mongo);
		}
		catch (UnknownHostException e) {
			throw new ServletException("Could not connect to the database.");
		}

	}
   
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		response.setContentType("application/json");
		// Get the authentication parameters
		String username = request.getParameter("username");
		String passwd = request.getParameter("password");

		PrintWriter out = response.getWriter();
		
		if (username == null || passwd == null) {
			String err = "{\"error\" : \"username and password fields are required\"}";
			response.setStatus(response.SC_UNAUTHORIZED);
			out.println(err);
			out.flush();
			return;
		}
		// query for username 
		User this_user = user_ds.findOne("username", username.intern());
		if(this_user == null){
			String err = "{\"error\" : \"Username not found.\"}";
			response.setStatus(response.SC_UNAUTHORIZED);
			out.println(err);
			out.flush();
			return;
		}

		if(!this_user.checkPassword(passwd.intern())) {
			String err = "{\"error\" : \"Invalid password.\"}";
			response.setStatus(response.SC_UNAUTHORIZED);
			out.println(err);
			out.flush();
			return;
		}
		// setup the session.
		request.getSession();	
		out.println("{\"success\" : \"success\"}");
		out.flush();
   }
}
