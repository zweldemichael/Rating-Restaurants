package provider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RatingDAOImpl {
	static Connection con;
	static PreparedStatement ps;
	
	public void addRating(String rateRest, String uname,Rating rating) {
		int restID =-1;
		int userID = -1;
		int status = 0;
		// getting restID;
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("Select * from restaurant where name =?");
			ps.setString(1,rateRest);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				restID = (rs.getInt(1));	
			}
		}
		
	catch(Exception e){
			System.out.println(e);
		}
		//getting userID
		try {
			ps = con.prepareStatement("Select * from rater where name =?");
			ps.setString(1,uname);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				userID = (rs.getInt(1));	
			}
		}
		
	catch(Exception e){
			System.out.println(e);
		}
		// adding rating
		long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);  
		try {
			ps=con.prepareStatement("Insert into rating(user_id,post_date,price,food,mood,staff,comments,restaurant_id)values('"+userID+"','"+date+"','"+rating.getPrice()+"','"+rating.getFood()+"','"+rating.getMood()+"','"+rating.getStaff()+"','"+rating.getComment()+"','"+restID+"')");
			status=ps.executeUpdate();
			}
		catch(Exception e){
			System.out.println(e);
		}
		
		
		
	}
}
