package provider;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Query
 */
@WebServlet("/Query")
public class Query extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String restName = request.getParameter("restName");
		String restType = request.getParameter("restType");
		String submitType = request.getParameter("submit");
		 
		
		if (submitType.equals("restList")) {
		
		RestaurantDAOImpl restCD = new RestaurantDAOImpl(); 	
		ArrayList<Restaurant> rest = restCD.getRestLoc(restName);
		
		// can delete
//		for (int i = 0; i <= rest.size()-1; i++){		
//			  System.out.println("This is cuisine : "+rest.get(i).mgrName ) ;
//		 }
		
		request.setAttribute("restDet", rest); // send rest details
		request.setAttribute("restLocCol", restCD.getRestLocCol()); // send restRows
		request.getRequestDispatcher("QueryResultjsp.jsp").forward(request, response);
		
		//System.out.println(rest.getMgrName());
		
		System.out.println(restName);
		}
		else if (submitType.equals("menuItem")) {
			MenuItemDAOImpl restCD = new MenuItemDAOImpl(); 
			ArrayList<MenuItem> main = restCD.getMain(restName);
			ArrayList<MenuItem> starter = restCD.getStarter(restName);	
			ArrayList<MenuItem> dessert = restCD.getDessert(restName);
			ArrayList<String> colName = restCD.getColName();
			
			int s = starter.size();
			System.out.println("SIZE " + s);
			//System.out.println("NAME ITEM 1 "+starter.get(0).name);
			//System.out.println("NAME ITEM 2 "+starter.get(1).name);
			
			String restNameMenu = restName;
			
			request.setAttribute("starter", starter);
			request.setAttribute("main", main);
			request.setAttribute("dessert", dessert);
			request.setAttribute("StarterName", "Starter");
			request.setAttribute("MainName", "Main");
			request.setAttribute("DessertName", "Dessert");
			request.setAttribute("colName", colName);
			request.setAttribute("restName", restNameMenu);
			request.getRequestDispatcher("QueryResultjsp.jsp").forward(request, response);
			// System.out.println("This is menuitem name : "+starter.get(1).name ) ;
			
			System.out.println("N E X T ");
		}
		else if (submitType.equals("restType")) {
			
			RestaurantDAOImpl restCD = new RestaurantDAOImpl(); 	
			ArrayList<Restaurant> restTypeQ = restCD.getRestFromCuisine(restType);
			
			request.setAttribute("restType", restTypeQ); // send rest details
			request.setAttribute("restTypeCol", restCD.getRestLocCol()); // send restRows
			request.getRequestDispatcher("QueryResultjsp.jsp").forward(request, response);	
		}
		else if (submitType.equals("addLoc")) {
			String addLocName = restName;
			HttpSession session = request.getSession();
			session.setAttribute("addLocRestName", addLocName);
			
			response.sendRedirect("AddRest.jsp");
//			request.setAttribute("addLocRestName", restName);
//			request.getRequestDispatcher("AddRest.jsp").forward(request, response);
		}
		else if (submitType.equals("submitLoc")) {
			RestaurantDAOImpl restCD = new RestaurantDAOImpl();
			Restaurant rest = new Restaurant();
			
			rest.setOpenDate(request.getParameter("openDate"));
			rest.setMgrName(request.getParameter("mgrName"));
			rest.setPhone(request.getParameter("phoneNo"));
			rest.setStreet(request.getParameter("street"));
			rest.setOpenHour(request.getParameter("openHr"));
			rest.setCloseHour( request.getParameter("closeHr"));
			
			HttpSession session = request.getSession();
			String addLocName = session.getAttribute("addLocRestName").toString();
			rest.setName(addLocName);
			
			restCD.addLocation(rest);
			boolean newRest = Restaurant.isNewRest();
			System.out.println("NEW REST ?  b4 if "+newRest);
			
			if (newRest) {
				Restaurant.setNewRest(false);
				System.out.println("NEW REST ?  inside if "+newRest);
				response.sendRedirect("AddMenuItem.jsp");
			}
	
			//flag = session.getAttribute("addItemNewRest").toString();
			else  {
				//response.sendRedirect("AddMenuItem.jsp");
			}
			
		}
		else if (submitType.equals("addItem")) {
			String addLocName = restName;
			HttpSession session = request.getSession();
			session.setAttribute("addLocRestName", addLocName);
			
			response.sendRedirect("AddMenuItem.jsp");
			
		}
		else if (submitType.equals("submitMitem")){
			HttpSession session = request.getSession();
			String restaurantName = session.getAttribute("addLocRestName").toString();
		MenuItemDAOImpl cdMI = new MenuItemDAOImpl();
		MenuItem mi = new MenuItem();
		
		int menuType;
		int menuCateg;
		
		if (request.getParameter("itemFB").equals("Food")) {
			menuType = 1;
		}
		else {
			menuType = 2;
		}
		
		if (request.getParameter("itemCat").equals("Starter")) {
			menuCateg = 0;
		}
		else if (request.getParameter("itemCat").equals("Main")) {
			menuCateg =1;
		}
		else {
			menuCateg = 2;
		}
		
		mi.setName(request.getParameter("itemName"));
		mi.setIntType(menuType);
		mi.setDesc(request.getParameter("itemDesc"));
		mi.setPrice(request.getParameter("itemPrice"));
		mi.setIntCateg(menuCateg);
		
		cdMI.addMenuItem(mi,restaurantName);
	}
		else if (submitType.equals("submitNewRest")) {
			
			RestaurantDAOImpl restCD = new RestaurantDAOImpl();
			Restaurant rest = new Restaurant();
			//String newRestName = request.getParameter("restName");
			boolean newType = true;
			String newRestType = request.getParameter("cuisineType");
			rest.setName(request.getParameter("restName"));
			rest.setURL(request.getParameter("url"));
			
			if (newRestType.equals("")) {
				newRestType = request.getParameter("RestType");
				newType = false;
			}
			
			rest.setCuisine(newRestType);
			
			restCD.addNewRest(rest,newType);
			
			Restaurant.setNewRest(true);
			System.out.println("FIRST NEW REST VAL =  "+Restaurant.isNewRest());
			
			HttpSession session = request.getSession();
			session.setAttribute("addLocRestName", rest.getName());
			response.sendRedirect("AddRest.jsp");
		}
		else if(submitType.equals("newRest")) {
			ResTypeDAOImpl restTypeCD = new ResTypeDAOImpl();
			ResType resType = restTypeCD.getResType();
			ArrayList<String> a =  resType.getRestTypeList();
			//Restaurant rest = new Restaurant();
	
			request.setAttribute("restType", a);
			request.getRequestDispatcher("AddRestLoc.jsp").forward(request, response);
	
		}
		else if(submitType.equals("delAcc")) {
			RaterDAOImpl cd = new RaterDAOImpl();
			
			
			String name= request.getParameter("uname");
			cd.deleteAcc(name);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		//System.out.println("USER NAME 2 DELETE "+ name);	
		}
		else if(submitType.equals("delRest")) {
			RestaurantDAOImpl cd = new RestaurantDAOImpl();
			String name = request.getParameter("restName");
	
			cd.deleteRest(name);
			response.sendRedirect("Login.jsp");
			//request.getRequestDispatcher("welcome.jsp").forward(request, response);
		//System.out.println("USER NAME 2 DELETE "+ name);	
		}
		else if(submitType.equals("delete")) {
			MenuItemDAOImpl cd = new MenuItemDAOImpl();
			String name = request.getParameter("restNameFromMitem");
			String mName = request.getParameter("restToDelete");
			System.out.println("rest to delete "+ name);	
			System.out.println("mItem to delete "+ mName);
			
			cd.deleteMenuItem(name,mName);
			//cd.deleteRest(name);
		//	response.sendRedirect("Login.jsp");
			//request.getRequestDispatcher("welcome.jsp").forward(request, response);
		//System.out.println("USER NAME 2 DELETE "+ name);	
		}
		else if(submitType.equals("mostExpsve")) {
			RestaurantDAOImpl cd = new RestaurantDAOImpl();
			ArrayList<Restaurant> mstExpsv = new ArrayList<Restaurant>();
			String name = request.getParameter("restName");
	
			mstExpsv = cd.getMostExpsv(name);
			
			request.setAttribute("mstExpsvName", "Listing most expesnsive menu item");
			request.setAttribute("mstExpsvItemName", "Name");
			request.setAttribute("mstExpsvPrice", "Price");
			request.setAttribute("mstExpsvmgrName", "Manager Name");
			request.setAttribute("mstExpsvOpenHR", "Open Hour");
			request.setAttribute("mstExpsvURL", "URL");
			request.setAttribute("mstExpsv", mstExpsv); // send rest details
			request.getRequestDispatcher("QueryResultjsp.jsp").forward(request, response);
		}
		else if(submitType.equals("rateRest")) {
			String uname = request.getParameter("uname");
			String rateRest = request.getParameter("restName");
			request.setAttribute("name",uname);
			request.setAttribute("restName", rateRest);
			request.getRequestDispatcher("RateRest.jsp").forward(request, response);
		
		}
		else if(submitType.equals("submitRestRating")) {
			RatingDAOImpl cd = new RatingDAOImpl();
			Rating rating = new Rating();
			String uname = request.getParameter("uname");
			String rateRest = request.getParameter("rateRest");
			System.out.println("USERNAME RATING  : "+uname);
			System.out.println("Rating restaurant : "+rateRest);
			rating.setUname(uname);
			rating.setRestName(rateRest);
			rating.setPrice( request.getParameter("price"));
			rating.setFood( request.getParameter("food"));
			rating.setMood( request.getParameter("mood"));
			rating.setStaff( request.getParameter("mood"));
			rating.setStaff( request.getParameter("staff"));
			rating.setComment( request.getParameter("comments"));
			cd.addRating(rateRest,uname,rating);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		
		}
		else if(submitType.equals("qE")) {
			QueryResultDAOImpl cd = new QueryResultDAOImpl();
			ArrayList<Queries> que = cd.queryE();
			request.setAttribute("Qe", "Query E");
			request.setAttribute("cuisine", "cuisine");
			request.setAttribute("category", "category");
			request.setAttribute("avgPrice", "average price");
			request.setAttribute("e", que); // send rest details
			request.getRequestDispatcher("QueryResultjsp.jsp").forward(request, response);
		
		}
		else if(submitType.equals("qF")) {
			QueryResultDAOImpl cd = new QueryResultDAOImpl();
			ArrayList<Queries> que = cd.queryF();
			request.setAttribute("Qf", "Query F");
			request.setAttribute("uname", "user name");
			request.setAttribute("restName", "Restaurant name");
			request.setAttribute("count", "count");
			request.setAttribute("avgPrice", "average price");
			request.setAttribute("f", que); // send rest details
			request.getRequestDispatcher("QueryResultjsp.jsp").forward(request, response);
		}
		else if(submitType.equals("qH")) {
			QueryResultDAOImpl cd = new QueryResultDAOImpl();
			ArrayList<Queries> que = cd.queryH();
			request.setAttribute("Qh", "Query H");
			request.setAttribute("restName", "Restaurant name");
			request.setAttribute("oDate", "open date");
			request.setAttribute("h", que); // send rest details
			request.getRequestDispatcher("QueryResultjsp.jsp").forward(request, response);
		}
		else if(submitType.equals("qG")) {
			QueryResultDAOImpl cd = new QueryResultDAOImpl();
			ArrayList<Queries> que = cd.queryG();
			request.setAttribute("Qg", "Query G");
			request.setAttribute("restNameG", "Restaurant name");
			request.setAttribute("phone", "Phone Number");
			request.setAttribute("cuisineG", "cuisine No.");
			request.setAttribute("g", que); // send rest details
			request.getRequestDispatcher("QueryResultjsp.jsp").forward(request, response);
		}
		else if(submitType.equals("qI")) {
			QueryResultDAOImpl cd = new QueryResultDAOImpl();
			ArrayList<Queries> que = cd.queryI();
			request.setAttribute("QI", "Query I");
			request.setAttribute("restNameI", "Restaurant name");
			request.setAttribute("unameI", "User Name");
			request.setAttribute("I", que); // send rest details
			request.getRequestDispatcher("QueryResultjsp.jsp").forward(request, response);
		}
		else if(submitType.equals("qM")) {
			QueryResultDAOImpl cd = new QueryResultDAOImpl();
			ArrayList<Queries> que = cd.queryM();
			request.setAttribute("QM", "Query M");
			request.setAttribute("unameM", "User Name");
			request.setAttribute("repM", "Reputaion");
			request.setAttribute("commentM", "Comments");
			request.setAttribute("M", que); // send rest details
			request.getRequestDispatcher("QueryResultjsp.jsp").forward(request, response);
		}
		
		else if(submitType.equals("qN")) {
			QueryResultDAOImpl cd = new QueryResultDAOImpl();
			ArrayList<Queries> que = cd.queryN();
			request.setAttribute("QN", "Query N");
			request.setAttribute("unameN", "User Name");
			request.setAttribute("emailN", "eMail");
			request.setAttribute("totalN", "Total");
			request.setAttribute("N", que); // send rest details
			request.getRequestDispatcher("QueryResultjsp.jsp").forward(request, response);
		}
		else if(submitType.equals("qK")) {
			QueryResultDAOImpl cd = new QueryResultDAOImpl();
			ArrayList<Queries> que = cd.queryK();
			request.setAttribute("QK", "Query K");
			request.setAttribute("unameK", "User Name");
			request.setAttribute("joinK", "Join Date");
			request.setAttribute("repK", "Total");
			request.setAttribute("restK", "Restaurant Name");
			request.setAttribute("postK", "Post Date");
			request.setAttribute("K", que); // send rest details
			request.getRequestDispatcher("QueryResultjsp.jsp").forward(request, response);
		}
		else if(submitType.equals("qJ")) {
			QueryResultDAOImpl cd = new QueryResultDAOImpl();
			ArrayList<Queries> que = cd.queryJ();
			request.setAttribute("QJ", "Query J");
			request.setAttribute("desJ", "Description");
			request.setAttribute("unameJ", "User Name");
			request.setAttribute("restJ", "Restaurant Name");
			request.setAttribute("avgJ", "Average");
			request.setAttribute("J", que); // send rest details
			request.getRequestDispatcher("QueryResultjsp.jsp").forward(request, response);
		}
	}
}



