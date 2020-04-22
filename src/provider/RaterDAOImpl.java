package provider;

import java.sql.*;

public class RaterDAOImpl implements RaterDAO {

	static Connection con;
	static PreparedStatement ps;
	@Override
	public int insertRater(Rater r) {
		
		int status = 0;
		
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("INSERT INTO Rater(email, name, join_date, type_id, password) VALUES ('"+r.getEmail()+"','"+r.getUsername()+"','"+r.getDate()+"','"+r.getType()+"','"+r.getPass()+"')");
			
//			'"+gender+"','"+name+"','"+address+"',
//			ps.setString(2,r.getEmail());
//			ps.setString(3, r.getUsername());
//			ps.setString(4, "2011-02-11");
//			ps.setInt(5,r.getType());
//			ps.setInt(6,1);
//			ps.setString(7, r.getPass());
			status=ps.executeUpdate();
			
			System.out.println("email "+r.getEmail() + " \n join :" +r.getDate());
		}
		
	catch(Exception e){
			System.out.println(e);
			
		}
		
		return status;
	}

	@Override
	public Rater getRater(String username, String pass) {
		System.out.println("Printing username from getRater "+ username);
		System.out.println("Printing pass "+ pass);
		Rater r = new Rater();
		
			try {
				
				con=ConnectionProvider.getConnection();
				ps=con.prepareStatement("Select * from Rater Where name=? and password=?");
				ps.setString(1, username);
				ps.setString(2, pass);
				
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					
					r.setUsername(rs.getString(3));
					r.setPass(rs.getString(7));
					System.out.print("Column 3 returned: "+ rs.getString(3) );
					
					System.out.print("Column 7 returned: "+ rs.getString(7) );
					//r.setEmail(rs.getString(2));
				}
				
					}
				
			catch(Exception e){
					System.out.println(e);
					
				}
			System.out.println("Printing username from getRater After try "+ r.getUsername());
			System.out.println("Printing pass after try "+ r.getPass());
		return r;
	}
	
	public void deleteAcc(String name) {
		
		try {
			System.out.println("BOUT TO DELETE USER "+name);
			con=ConnectionProvider.getConnection();
			ps=con.prepareStatement("DELETE FROM rater WHERE name = ?");
			ps.setString(1, name);
			ps.executeQuery();
	}
			
		catch(Exception e){
				System.out.println(e);
				
			}
	}

}
