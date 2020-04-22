package provider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class MenuItemDAOImpl {
	static Connection con;
	static PreparedStatement ps;
	static int gotCol =0 ;
	
	ArrayList<String> colName = new ArrayList<String>();
	ArrayList<MenuItem> starter ;
	ArrayList<MenuItem> main ;
	ArrayList<MenuItem> dessert; 
	
	// get dessert
	//get main	
public ArrayList<MenuItem> getDessert( String restName) {

		dessert = new ArrayList<MenuItem>();
		MenuItem mDessert;
		
		try {
			
			con=ConnectionProvider.getConnection();
			ps=con.prepareStatement("select * from  menuitem inner join category on menuitem.category_id = category.category_id\r\n" +
			"inner join restaurant on restaurant.restaurant_id = menuitem.restaurant_id where restaurant.name = ? and menuitem.category_id = '2'");
			ps.setString(1, restName);
			
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				mDessert = new MenuItem();
				mDessert.setName(rs.getString(2));
				mDessert.setDesc(rs.getString(4));
				mDessert.setPrice(rs.getString(5));
				
				dessert.add(mDessert);	
				// getting column name
				if (rs.isLast()) {
					if (gotCol == 0) {
				ResultSetMetaData md = rs.getMetaData();
				  int col = md.getColumnCount();
				  System.out.println("Number of Column : "+ col);
				  System.out.println("Columns Name: ");
				  for (int i = 1; i <= col; i++){
				  String col_name = md.getColumnName(i);
				  col_name.replaceAll("[^a-zA-Z]"," "); 
				  colName.add(col_name);
				  System.out.println("This is colmn : "+col_name);}	
					}
					
			}
			}
				}
		
		catch(Exception e){
				System.out.println(e);	
			}
		if (gotCol == 0) {	
		if (colName.size() > 0) {
			
			int size = colName.size();
		System.out.println("COL SIZE BEFORE CLEAR"+ size);
		colName.subList(5, 12).clear();
		colName.remove(2);
		colName.remove(0);
		colName.remove(3);
		size = colName.size();
		gotCol =1;
		System.out.println("COL SIZE AFTER CLEAR"+size);
		}}

		return dessert;
	}
	
	//get main	
public ArrayList<MenuItem> getMain( String restName) {
		
		
		 main = new ArrayList<MenuItem>();
		 MenuItem mMain;
		
		
		try {
			
			con=ConnectionProvider.getConnection();
			ps=con.prepareStatement("select * from  menuitem inner join category on menuitem.category_id = category.category_id\r\n" +
			"inner join restaurant on restaurant.restaurant_id = menuitem.restaurant_id where restaurant.name = ? and menuitem.category_id = '1'");
			ps.setString(1, restName);

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				mMain = new MenuItem();
				mMain.setName(rs.getString(2));
				mMain.setDesc(rs.getString(4));
				mMain.setPrice(rs.getString(5));
				
				main.add(mMain);
				// getting column name
				if (rs.isLast()) {
					if (gotCol == 0) {
				ResultSetMetaData md = rs.getMetaData();
				  int col = md.getColumnCount();
				  System.out.println("Number of Column : "+ col);
				  System.out.println("Columns Name: ");
				  for (int i = 1; i <= col; i++){
				  String col_name = md.getColumnName(i);
				  col_name.replaceAll("[^a-zA-Z]"," "); 
				  colName.add(col_name);
				  System.out.println("This is colmn : "+col_name);}	
					}
					
			}
				
			}
	}
			
		catch(Exception e){
				System.out.println(e);		
			}
		if (gotCol == 0) {	
if (colName.size() > 0) {
			
			int size = colName.size();
		System.out.println("COL SIZE BEFORE CLEAR"+ size);
		colName.subList(5, 12).clear();
		colName.remove(2);
		colName.remove(0);
		colName.remove(3);
		size = colName.size();
		gotCol =1;
		System.out.println("COL SIZE AFTER CLEAR"+size);
		}}



		return main;	
	}
	
	
	// get starter from menu
	public ArrayList<MenuItem> getStarter(String restName) {
		
		starter = new ArrayList<MenuItem>();
		MenuItem mStarter;
		
		try {
			
			con=ConnectionProvider.getConnection();
			ps=con.prepareStatement("select * from  menuitem inner join category on menuitem.category_id = category.category_id\r\n" +
			"inner join restaurant on restaurant.restaurant_id = menuitem.restaurant_id where restaurant.name = ? and menuitem.category_id = '0'");
			ps.setString(1, restName);
			
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				mStarter = new MenuItem();
				mStarter.setName(rs.getString(2));
				mStarter.setDesc(rs.getString(4));
				mStarter.setPrice(rs.getString(5));
				
				System.out.println("NAME ITEM "+rs.getString(2));	
				System.out.println("DESC ITEM "+rs.getString(4));	
				System.out.println("PRICE ITEM "+rs.getString(5));	
				
				starter.add(mStarter);
				
				// getting column name
				if (rs.isLast()) {
					if (gotCol == 0) {
				ResultSetMetaData md = rs.getMetaData();
				  int col = md.getColumnCount();
				  System.out.println("Number of Column : "+ col);
				  System.out.println("Columns Name: ");
				  for (int i = 1; i <= col; i++){
				  String col_name = md.getColumnName(i);
				  col_name.replaceAll("[^a-zA-Z]"," "); 
				  colName.add(col_name);
				  System.out.println("This is colmn : "+col_name);}	
					}
					
			}
			
				}
		}
			
		catch(Exception e){
				System.out.println(e);		
			}
	if (gotCol == 0) {	
if (colName.size() > 0) {
			
			int size = colName.size();
		System.out.println("COL SIZE BEFORE CLEAR"+ size);
		colName.subList(5, 12).clear();
		colName.remove(2);
		colName.remove(0);
		colName.remove(3);
		size = colName.size();
		gotCol =1;
		System.out.println("COL SIZE AFTER CLEAR"+size);
		}
	}


		for (int i=0;i<starter.size()-1;i++) {
			System.out.println("NAME ITEM sTARTER "+starter.get(i).name);
		}
		return starter;
		
	}
	
	public ArrayList<String> getColName(){
		gotCol =0;
	return colName;
	}

	// add Menu item - get rest id
	public void addMenuItem(MenuItem mi,String restaurantName){
	int restID =-1;
	
		try {
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement("Select * from restaurant where name =?");
			ps.setString(1,restaurantName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				restID = (rs.getInt(1));	
			}
		}
		
	catch(Exception e){
			System.out.println(e);
		}
		
		addMenuItemReal(mi,restID);
	
}
	
	// add Menu item real 
	
public void addMenuItemReal(MenuItem mi,int restID){
		
	int status = 0;

	try {
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement("Insert into menuitem(name,type_id,description,price,restaurant_id,category_id) values('"+mi.getName()+"' ,'"+mi.getIntType()+"','"+mi.getDesc()+"','"+mi.getPrice()+"','"+restID+"','"+mi.getIntCateg()+"')");
		//ps = con.prepareStatement("Insert into location(first_open_date, manager_name, phone_number, street_address, hour_open, hour_close, restaurant_id) values('"+rest.getOpenDate()+"','"+rest.getMgrName()+"','"+rest.getPhone()+"','"+rest.getStreet()+"','"+rest.getOpenHour()+"','"+rest.getCloseHour()+"','"+rID+"')");

		status=ps.executeUpdate();
		System.out.println(status);
		//System.out.println("email "+r.getEmail() + " \n join :" +r.getDate());
	}
	
	catch(Exception e){
	System.out.println(e);
	
	}	
}

public void deleteMenuItem(String restname, String mitem) {
//	int restID;
//	try {
//			con = ConnectionProvider.getConnection();
//			ps = con.prepareStatement("Select restaurant_id from restaurant where name =?");
//			ps.setString(1,restname);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				restID = (rs.getInt(1));	
//			}
//		}
//		
//	catch(Exception e){
//			System.out.println(e);
//		}
	//deleting menu item
	try {
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement("delete from menuitem where menuitem.item_id = (select item_id from menuitem, restaurant where menuitem.name = ? and restaurant.restaurant_id = (select restaurant_id from restaurant where name = ?)) ");
		ps.setString(1,mitem);
		ps.setString(2,restname);
		ps.executeUpdate();
		
	}
	
catch(Exception e){
		System.out.println(e);
	}
	// deleting rest. with no menuitem
	try {
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement("delete from  restaurant where NOT EXISTS(SELECT *  FROM menuitem WHERE menuitem.restaurant_id = restaurant.restaurant_id) ");
	
		ps.executeUpdate();
		
	}
	
catch(Exception e){
		System.out.println(e);
	}
	// deleting cuisinetype not associated with any rest.
	try {
		
		con=ConnectionProvider.getConnection();
		ps=con.prepareStatement("DELETE FROM cuisinetype WHERE NOT EXISTS(SELECT * FROM restaurant WHERE restaurant.cuisine = cuisinetype.cuisine_id)");
		ps.executeQuery();
}
		
	catch(Exception e){
			System.out.println(e);
			
		}
}


}




