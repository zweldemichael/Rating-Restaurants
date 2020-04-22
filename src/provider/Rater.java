package provider;

import java.sql.Date;

public class Rater {
	
	private String username;
	private String pass;
	private String email;
	private int type;
	
	public Date getDate() {
		long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);  
        return date;
         
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		System.out.println("set email : " + email);
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
		//System.out.println(type);
	}
	public String getUsername() {
		System.out.println("Getting user :" + username);
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
		//System.out.println(username);
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	System.out.println(pass);
	}

}
