package provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RaterDAO cd = new RaterDAOImpl();
		int type = 0;
		
			String rtype = request.getParameter("rtype");
			String email = request.getParameter("email");
			String uname = request.getParameter("uname");
			String pass = request.getParameter("pass");
			String submitType = request.getParameter("submit");
			
			
			System.out.println(rtype);
			if (rtype == null) {
				// do nothing
			}else {
				if (rtype.equals("online")) {
					type = 0;
				}
				else if (rtype.equals("food critic")) {
					type = 1;
				}
				else  {
				type = 2;	
				}
			}
			
			Rater r = new Rater();
			 r = cd.getRater(uname, pass);
			 System.out.println("user" + r.getUsername()+ " pass"+r.getPass()+ " email"+r.getEmail());
			System.out.println("Printing username "+ r.getUsername());
			
			if (r == null || r.getUsername() == null) {
				System.out.println("R IS NULL HOOW? ");
			}
			
			
			if (submitType.equals("login") && r!= null && r.getUsername()!=null){
				
				System.out.println("WE IN LOGIN ");
				RestaurantDAOImpl restCD = new RestaurantDAOImpl(); 
				ResTypeDAOImpl restTypeCD = new ResTypeDAOImpl();
				
				Restaurant rest = restCD.getRestaurantList();
				
				ResType resType = restTypeCD.getResType();
				
				
			//	rest = restCD.getRestaurantList();
				ArrayList<String> b =  resType.getRestTypeList();
				
				request.setAttribute("username", r.getUsername());
				request.setAttribute("restList", rest.getRestList());
				request.setAttribute("restTypeList", resType.getRestTypeList());
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			
			}
		
			else if (submitType.equals("register")) {
				System.out.println("WE IN register ");
				r = new Rater();
				System.out.println("email "+r.getEmail() + "join :" +r.getDate());
				r.setUsername(uname);
				r.setPass(pass);
				r.setEmail(email);
				r.setType(type);
				cd.insertRater(r);
				System.out.println("email "+r.getEmail() + "join :" +r.getDate());
				request.setAttribute("successMessage", "Registration Done, please login " );
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
			else {
				System.out.println("WE IN error ");
				request.setAttribute("message", "Data Not Found, Click on Register NOW " );
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
			
	}
	


	
}
