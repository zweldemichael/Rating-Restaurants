package provider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResTypeDAOImpl {
	static Connection con;
	static PreparedStatement ps;
	
	
	
	// populate dropdown with list of cuisine types (rest. types)
	
	public ResType getResType() {
		
ResType resType = new ResType();
		
		try {
			
			con=ConnectionProvider.getConnection();
			ps=con.prepareStatement("Select * from cuisinetype ");
			
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				resType.setRestTypeList(rs.getString(2));	
			//	System.out.println(rs.getString(2));
			}
			
				}
		catch(Exception e){
			System.out.println(e);
			
		}
		return resType;
		
	}

}
