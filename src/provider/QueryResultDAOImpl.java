package provider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class QueryResultDAOImpl {
	static Connection con;
	static PreparedStatement ps;
	
	public ArrayList<Queries> queryE() {
		Queries q;
		ArrayList<Queries> que = new ArrayList<Queries>();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT R.cuisine, MI.category_id, Round(AVG(MI.price):: numeric,2) AS average_price FROM MenuItem MI, Restaurant R  where MI.restaurant_Id IN (SELECT R1.restaurant_Id FROM Restaurant R1 WHERE R1.cuisine = R.cuisine) AND MI.restaurant_Id = R.restaurant_Id GROUP BY R.cuisine, MI.category_id ORDER BY R.cuisine, MI.category_id");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				q = new Queries();
				q.setCuisine(rs.getInt(1)); 
				q.setCateID(rs.getInt(2));
				q.setAvePrice(rs.getInt(3));
				que.add(q);
			}
		}
		
	catch(Exception e){
			System.out.println(e);
		}
		return que;
	}
	
	public ArrayList<Queries> queryF() {
		Queries q;
		ArrayList<Queries> que = new ArrayList<Queries>();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT re.name, R.name, COUNT(RA.post_date), round(AVG((RA.food+Ra.price+RA.mood+RA.staff)/4.0)::numeric,2) FROM Restaurant AS R INNER JOIN Rating AS RA ON R.restaurant_id=Ra.restaurant_id INNER JOIN Rater AS RE ON RA.user_id=RE.user_id GROUP BY R.name, RE.name ORDER BY R.name,RE.name");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				q = new Queries();
				q.setUname(rs.getString(1));
				q.setRestName(rs.getString(2));
				q.setCount(rs.getInt(3));
				q.setAvePrice(rs.getInt(4));
				que.add(q);
			}
		}
		
	catch(Exception e){
			System.out.println(e);
		}
		return que;	
	}
	
	public ArrayList<Queries> queryH() {
		Queries q;
		ArrayList<Queries> que = new ArrayList<Queries>();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("select R.name, l.first_open_date from location as l left join restaurant as R on R.restaurant_id=l.restaurant_id right join Rating as RA on R.restaurant_id = RA.restaurant_id left join Rater as RE on RA.user_id=RE.user_id where RA.staff < all (select min(RA.staff) from rating as RA where user_id=5)");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				q = new Queries();
				q.setRestName(rs.getString(1));
				q.setOpenDate(rs.getString(2));
				que.add(q);
			}
		}
		
	catch(Exception e){
			System.out.println(e);
		}
		return que;	
	}
	
	public ArrayList<Queries> queryG() {
		Queries q;
		ArrayList<Queries> que = new ArrayList<Queries>();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("select name, L.phone_number, R.cuisine from Restaurant as R left join RATING RA on R.restaurant_id=rA.restaurant_id INNER JOIN LOCATION L ON R.restaurant_id=L.restaurant_id where not ( RA.post_date >= '2015-01-01' and RA.post_date <= '2015-01-31')");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				q = new Queries();
				q.setRestName(rs.getString(1));
				q.setPhone(rs.getString(2));
				q.setCuisine(rs.getInt(3));
				que.add(q);
			}
		}
		
	catch(Exception e){
			System.out.println(e);
		}
		return que;	
	}
	
	public ArrayList<Queries> queryI() {
		Queries q;
		ArrayList<Queries> que = new ArrayList<Queries>();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("Select R.name, RE.name FROM Restaurant R inner join Rating RA on R.restaurant_id=Ra.restaurant_id inner join Rater RE on RE.user_id= RE.user_id WHERE R.restaurant_id IN (SELECT RA.restaurant_id FROM Rating RA WHERE RA.restaurant_id IN (SELECT R1.restaurant_id FROM restaurant R1 WHERE R1.cuisine = 2)	AND RA.food >= All(SELECT RA2.food FROM Rating RA2 WHERE RA2.restaurant_id IN (SELECT R2.restaurant_id FROM Restaurant R2 WHERE R2.cuisine = 2)) AND RA.user_Id = RE.user_Id)");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				q = new Queries();
				q.setRestName(rs.getString(1));
				q.setUname(rs.getString(2));
				que.add(q);
			}
		}
		
	catch(Exception e){
			System.out.println(e);
		}
		return que;	
	}
	
	public ArrayList<Queries> queryM() {
		Queries q;
		ArrayList<Queries> que = new ArrayList<Queries>();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT RE.name, RE.reputation, RA.comments FROM Rating RA, Rater RE WHERE RE.user_Id IN (SELECT RE1.user_Id FROM Rater RE1 WHERE (SELECT COUNT(*) FROM Rating RA1 WHERE RA1.user_Id = RE1.user_Id AND RA1.restaurant_Id IN (SELECT R.restaurant_Id FROM Restaurant R WHERE R.name ='Tacos')) >=  All(SELECT COUNT(*) FROM Rating RA2 WHERE RA2.restaurant_Id IN (SELECT R.restaurant_Id FROM Restaurant R WHERE R.name ='Tacos') GROUP BY RA2.user_Id))	AND RA.user_Id = RE.user_Id AND RA.restaurant_Id IN (SELECT R.restaurant_Id FROM Restaurant R WHERE R.name ='Tacos')");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				q = new Queries();
				q.setUname(rs.getString(1));
				q.setRep(rs.getInt(2));
				q.setComments(rs.getString(3));
				que.add(q);
			}
		}
		
	catch(Exception e){
			System.out.println(e);
		}
		return que;	
	}
	
	public ArrayList<Queries> queryN() {
		Queries q;
		ArrayList<Queries> que = new ArrayList<Queries>();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT RE.name, RE.email, (RA.food+RA.mood+RA.price+RA.staff) total	FROM Rater RE INNER JOIN Rating Ra ON RE.user_id=RA.user_id WHERE (RA.food+RA.mood+RA.price+RA.staff) < All	(SELECT (RA2.food+RA2.mood+RA2.price+RA2.staff) FROM Rating RA2 INNER JOIN Rater RE1 ON RA2.user_id=RE1.user_id WHERE RE1.name='John') order by total, RE.name");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				q = new Queries();
				q.setUname(rs.getString(1));
				q.setEmail(rs.getString(2));
				q.setTotal(rs.getInt(3));
				que.add(q);
			}
		}
		
	catch(Exception e){
			System.out.println(e);
		}
		return que;	
	}
	
	public ArrayList<Queries> queryK() {
		Queries q;
		ArrayList<Queries> que = new ArrayList<Queries>();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT RE.name, RE.join_date, RE.reputation, R.name, RA.post_date FROM  Restaurant R inner join Rating RA on R.Restaurant_id=RA.restaurant_id\r\n" + 
					"inner join Rater RE on RE.user_id= RE.user_id WHERE RE.user_id IN (SELECT RE1.user_Id FROM Rater RE1 WHERE\r\n" + 
					"(SELECT AVG(mood) FROM Rating RA2 WHERE RA2.user_Id = RE1.user_id) >= ALL(SELECT AVG(mood) FROM Rating RA2 GROUP BY RA2.user_id)\r\n" + 
					"OR (SELECT AVG(food) FROM Rating RA2 WHERE RA2.user_Id = RE1.user_id) >= ALL(SELECT AVG(food) FROM Rating RA2 GROUP BY RA2.user_id))\r\n" + 
					"AND RA.user_id = RE.user_id AND RA.restaurant_id = R.restaurant_id");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				q = new Queries();
				q.setUname(rs.getString(1));
				q.setJoinDate(rs.getString(2));
				q.setRep(rs.getInt(3));
				q.setRestName(rs.getString(4));
				q.setPostDate(rs.getString(5));
				que.add(q);
			}
			
		}
	catch(Exception e){
			System.out.println(e);
		}
		return que;	
	
	}
	
	public ArrayList<Queries> queryJ() {
		Queries q;
		ArrayList<Queries> que = new ArrayList<Queries>();
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("SELECT ct.description, rest.name, use.name, temp.avgRate FROM Restaurant AS rest INNER JOIN CuisineType ct	ON rest.cuisine=ct.cuisine_id\r\n" + 
					"	INNER JOIN Location AS loc\r\n" + 
					"		ON rest.restaurant_id=loc.restaurant_id\r\n" + 
					"	INNER JOIN Rating AS rate\r\n" + 
					"		ON rest.restaurant_id=rate.restaurant_id\r\n" + 
					"	INNER JOIN Rater AS use\r\n" + 
					"		ON rate.user_id=use.user_id\r\n" + 
					"	INNER JOIN\r\n" + 
					"		(SELECT R2.Restaurant_id locid2, Round(AVG(rate2.food)::numeric,2) avgRate\r\n" + 
					"			FROM Rating rate2\r\n" + 
					"			INNER JOIN Restaurant R2\r\n" + 
					"				ON rate2.Restaurant_id=R2.restaurant_id\r\n" + 
					"			GROUP BY locid2) temp\r\n" + 
					"		ON Rest.Restaurant_id=locid2\r\n" + 
					"	WHERE temp.avgRate >= ALL\r\n" + 
					"		(SELECT AVG(rate2.food) avgRate\r\n" + 
					"			FROM Rating rate2\r\n" + 
					"			\r\n" + 
					"			INNER JOIN Restaurant R2\r\n" + 
					"				ON R2.restaurant_id=rate2.restaurant_id\r\n" + 
					"			INNER JOIN CuisineType ct2\r\n" + 
					"				ON R2.cuisine=ct2.cuisine_id\r\n" + 
					"			WHERE ct2.cuisine_id=ct.cuisine_id\r\n" + 
					"			GROUP BY R2.Restaurant_id)\r\n" + 
					"ORDER BY ct.description;\r\n" + 
					"\r\n" + 
					"");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				q = new Queries();
				q.setDesc(rs.getString(1));
				q.setRestName(rs.getString(2));
				q.setUname(rs.getString(3));
				q.setAvePrice(rs.getInt(4));
				
				que.add(q);
			}
}
		catch(Exception e){
			System.out.println(e);
		}
		return que;	
	}
	
	
	}

