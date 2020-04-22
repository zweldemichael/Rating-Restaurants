package provider;

import java.sql.*;
import java.util.ArrayList;
public class RestaurantDAOImpl {
	
	static Connection con;
	static PreparedStatement ps;
	ArrayList<Restaurant> rests; // restaurants for body of table
	ArrayList<String> restCol;  // colmn for table
	int restID =-1; // rest id

	public Restaurant getRestaurantList() {
		
		Restaurant res = new Restaurant();
		
		try {
			
			con=ConnectionProvider.getConnection();
			ps=con.prepareStatement("Select name from restaurant ");
			
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				//res.setName("NIGO");
				res.setRestList(rs.getString(1));
//				String temp = rs.getString(1);
//				System.out.print(" hhahaha "+temp + " ,  "); 
				
			}
			
				}
		catch(Exception e){
			System.out.println(e);
			
		}
		return res;
		
		
		
	}
	
	public ArrayList<Restaurant> getRestLoc(String name) {
		

		rests = new ArrayList<Restaurant>();
		restCol = new ArrayList<String>();
		
Restaurant res ;


int ctype = -1;
		try {
			
			con=ConnectionProvider.getConnection();
			ps=con.prepareStatement("Select * from restaurant inner join location on restaurant.restaurant_id = location.restaurant_id "
					+ "Where restaurant.name=?" );
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ctype = rs.getInt(3);
				res = new Restaurant();
				
				String c = getCuisine(ctype);
				res.setCuisine(c);
				res.setURL(rs.getString(4));
				//res.restLocDetail.add(rs.getString(4));
				res.setOpenDate(rs.getString(6));
				//res.restLocDetail.add(rs.getString(6));
				res.setMgrName(rs.getString(7));
				//res.restLocDetail.add(rs.getString(7));
				res.setPhone(rs.getString(8));
				//res.restLocDetail.add(rs.getString(8));
				res.setStreet(rs.getString(9));
				//res.restLocDetail.add(rs.getString(9));
				res.setOpenHour((rs.getString(10)));
				//res.restLocDetail.add(rs.getString(10));
				res.setCloseHour(rs.getString(11));
				//res.restLocDetail.add(rs.getString(11));
				
				rests.add(res);
			// getting column name
				if (rs.isLast()) {
				ResultSetMetaData md = rs.getMetaData();
				  int col = md.getColumnCount();
				  System.out.println("Number of Column : "+ col);
				  System.out.println("Columns Name: ");
				  for (int i = 1; i <= col; i++){
				  String col_name = md.getColumnName(i);
				  col_name.replaceAll("[^a-zA-Z]"," "); 
				  restCol.add(col_name);
				  System.out.println("This is colmn : "+col_name);}	
				}
			}
			
				}
		catch(Exception e){
			System.out.println(e);
			
		}
		
		restCol.remove(0);
		restCol.remove(0);
		restCol.remove(2);
		restCol.remove(restCol.size() -1);
		

		
//res.restLocDetail.add("TRIALLLLLLL ");
		
		return rests;
		
		
	}
	
	public String getCuisine(int ctype) {
		String c = "fake cuisine" ;
		
try {
			
			con=ConnectionProvider.getConnection();
			ps=con.prepareStatement("select description from cuisinetype where cuisine_id = ?" );
			ps.setInt(1, ctype);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				c = rs.getString(1);
			}
			
				}
		catch(Exception e){
			System.out.println(e);
			
		}
return c;
	}
	
	// returns col names for table
	public ArrayList<String> getRestLocCol() {
		return restCol;
	}
	
	// returns array of restaurants
	public ArrayList<Restaurant> getRests() {
		System.out.println("no rests" + rests.size());
		 for (int i = 0; i <= rests.size()-1; i++){		
			  System.out.println("This is mgr : "+ rests.get(i).mgrName ) ;
		 }
		
		return rests;
	}
	
// getting restaurants form restaurant types
	public ArrayList<Restaurant> getRestFromCuisine(String resType) {
		
		rests = new ArrayList<Restaurant>();
		restCol = new ArrayList<String>();
		
		Restaurant res ;

				try {
					
					con=ConnectionProvider.getConnection();
ps=con.prepareStatement("select name,first_open_date,manager_name from location inner join \r\n" + 
		"(select name ,restaurant_id from restaurant inner join\r\n" + 
		" (select cuisine_id from cuisinetype where description = ?) as l on\r\n" + 
		"restaurant.cuisine = l.cuisine_id) as m on location.restaurant_id = m.restaurant_id\r\n" + 
		"\r\n" + 
		"" );
	ps.setString(1, resType);
					
					ResultSet rs = ps.executeQuery();
					
					while (rs.next()) {
						res = new Restaurant();
						
						
						res.setName(rs.getString(1));;
						res.setOpenDate(rs.getString(2));
						res.setMgrName(rs.getString(3));
						
						rests.add(res);
					// getting column name
						if (rs.isLast()) {
						ResultSetMetaData md = rs.getMetaData();
						  int col = md.getColumnCount();
						  System.out.println("Number of Column : "+ col);
						  System.out.println("Columns Name: ");
						  for (int i = 1; i <= col; i++){
						  String col_name = md.getColumnName(i);
						  col_name.replaceAll("[^a-zA-Z]"," "); 
						  restCol.add(col_name);
						  System.out.println("This is colmn : "+col_name);}	
						}
					}
					
						}
				catch(Exception e){
					System.out.println(e);
					
				}

				return rests;
	
	}
	
	// adding location to existing restaurant -  1st getting rest ID
	
	public void addLocation(Restaurant rest) {
		

		
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("Select * from restaurant where name =?");
			ps.setString(1,rest.getName());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				restID = (rs.getInt(1));	
			}
		}
		
	catch(Exception e){
			System.out.println(e);
		}
		
		addLocationReal(rest,restID);
	}
	
	// adding location to existing restaurant 
	
	public int addLocationReal (Restaurant rest, int rID) {
	

int status = 0;

		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("Insert into location(first_open_date, manager_name, phone_number, street_address, hour_open, hour_close, restaurant_id) values('"+rest.getOpenDate()+"','"+rest.getMgrName()+"','"+rest.getPhone()+"','"+rest.getStreet()+"','"+rest.getOpenHour()+"','"+rest.getCloseHour()+"','"+rID+"')");
			
			//ps = con.prepareStatement("INSERT INTO Location(first_open_date, manager_name, phone_number, street_address, hour_open, hour_close, restaurant_id) VALUES ('"+x+"','"+x+"','"+x+"','"+x+"','"+x+"','"+x+",'"+x+"')");
			//ps = con.prepareStatement("INSERT INTO Rater(email, name, join_date, type_id, password) VALUES ('"+r.getEmail()+"','"+r.getUsername()+"','"+r.getDate()+"','"+r.getType()+"','"+r.getPass()+"')");

			//ps.setString(1, rest.getPhone());
			status=ps.executeUpdate();
			System.out.println(status);
			//System.out.println("email "+r.getEmail() + " \n join :" +r.getDate());
		}
		
	catch(Exception e){
			System.out.println(e);
			
		}
		return status;

	}
	
	// add to Restaurant Table
	public void addNewRest(Restaurant rest, boolean newType) {
		int status = 0;
					if (newType) {
						try {
							con = ConnectionProvider.getConnection();
							ps=con.prepareStatement("Insert into cuisinetype(description)values('"+rest.getCuisine()+"')");
							status=ps.executeUpdate();
						}
						
					catch(Exception e){
							System.out.println(e);
							
						}
					}
					int cID = getCuisineId(rest.getCuisine());
					
					try {
						con = ConnectionProvider.getConnection();
						ps=con.prepareStatement("Insert into restaurant(name,cuisine,url)values('"+rest.getName()+"','"+cID+"','"+rest.getURL()+"')");
						status=ps.executeUpdate();
					}
					
				catch(Exception e){
						System.out.println(e);
						
					}
					
		
	}
	
	public int getCuisineId(String cuisine) {
		int cID = -1;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("Select * from cuisinetype where description =?");
			ps.setString(1,cuisine);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				cID = (rs.getInt(1));	
			}
		}
		
	catch(Exception e){
			System.out.println(e);
		}
		
		
		return cID;
	}
	
	// delete restaurant
	public void deleteRest(String name) {
		
		
		try {
			System.out.println("BOUT TO DELETE rest "+name);
			con=ConnectionProvider.getConnection();
			ps=con.prepareStatement("DELETE FROM restaurant WHERE name = ?");
			ps.setString(1, name);
			ps.executeQuery();
			
			ps=con.prepareStatement("DELETE FROM cuisinetype WHERE NOT EXISTS(SELECT * FROM restaurant WHERE restaurant.cuisine_id = cuisinetype.cuisine_id)");
			ps.executeQuery();
	}
			
		catch(Exception e){
				System.out.println(e);
				
			}
		
		try {
			System.out.println("BOUT TO DELETE rest "+name);
			con=ConnectionProvider.getConnection();
			ps=con.prepareStatement("DELETE FROM cuisinetype WHERE NOT EXISTS(SELECT * FROM restaurant WHERE restaurant.cuisine = cuisinetype.cuisine_id)");
			ps.executeQuery();
	}
			
		catch(Exception e){
				System.out.println(e);
				
			}
	}
	
	// getting most expensive item

	public ArrayList<Restaurant> getMostExpsv(String restName) {
		ArrayList<Restaurant> expsvItem = new ArrayList<Restaurant>();
		Restaurant mostExpsv;
		
		int restID =-1;
		// getting restID;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("Select * from restaurant where name =?");
			ps.setString(1,restName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				restID = (rs.getInt(1));	
			}
		}
		
	catch(Exception e){
			System.out.println(e);
		}
		
		// getting most expsv item
		try {
			//con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT item.name, item.price, loc.manager_name, loc.hour_open, rest.url FROM Restaurant AS rest INNER JOIN Location AS loc ON rest.restaurant_id=loc.restaurant_id INNER JOIN MenuItem AS item ON rest.restaurant_id=item.restaurant_id WHERE rest.restaurant_id= ? AND item.price >= ALL (SELECT item2.price FROM MenuItem as item2 WHERE item2.restaurant_id= ? )");
			ps.setInt(1,restID);
			ps.setInt(2,restID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mostExpsv = new Restaurant();
				mostExpsv.setMostExpsvItem(rs.getString(1));
				mostExpsv.setMostExpsvItemPrice(rs.getString(2));
				mostExpsv.setMgrName(rs.getString(3));
				mostExpsv.setOpenHour(rs.getString(4));
				mostExpsv.setURL(rs.getString(5));
				expsvItem.add(mostExpsv);
				

			}
		}
		
	catch(Exception e){
			System.out.println(e);
		}
		
		return expsvItem;
		
	}
		
	
	
}
