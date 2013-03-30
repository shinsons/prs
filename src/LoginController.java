import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/service/login") 
public class LoginController extends HttpServlet {
   
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {

      response.setContentType("application/json");
	  // Get the authentication parameters
	  String username = request.getParameter("username");
	  String passwd = request.getParameter("password");
	  
      PrintWriter out = response.getWriter(); 
	  // TODO: Persistenance mechanism goes here.
	  // STUB it out for now.
	  if (username == null || username.intern() != "admin" || 
          passwd == null || passwd.intern() != "changeit") {
	     response.sendError(response.SC_UNAUTHORIZED);	 
	  }
      out.println("{success:'success'}");
   }
}
