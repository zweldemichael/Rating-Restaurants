package provider;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Restaurant {
	
	String mostExpsvItem;
	String mostExpsvItemPrice;
	public String getMostExpsvItemPrice() {
		return mostExpsvItemPrice;
	}

	public void setMostExpsvItemPrice(String mostExpsvItemPrice) {
		this.mostExpsvItemPrice = mostExpsvItemPrice;
	}

	public String getMostExpsvItem() {
		return mostExpsvItem;
	}

	public void setMostExpsvItem(String mostExpsvItem) {
		this.mostExpsvItem = mostExpsvItem;
	}

	String name;
	String cuisine;
	String URL ;
	String openDate;
		String mgrName;
		String phone;
		String street;
		String openHour;
		String closeHour;
		static boolean newRest;
		
		static public boolean isNewRest() {
			return newRest;
		}

		static public void setNewRest(boolean newRest) {
			Restaurant.newRest = newRest;
		}

		ArrayList<String> restList = new ArrayList<String>(); // populate rest. in dropdown
		ArrayList<String> restLocCol = new ArrayList<String>(); // populate table heads
		
		ArrayList<String> restLocDetail = new ArrayList<String>(); // populate table body
		
		public ArrayList<String> getRestLocDetail() {
			 for (int i = 0; i <= restLocDetail.size()-1; i++){		
				  System.out.println("This is detail : "+restLocDetail.get(i) ) ;
			 }
			return restLocDetail;
		}
		
	public ArrayList<String> getRestLocCol() {
			return restLocCol;
		}
	
	public String getCloseHour() {
		return closeHour;
	}

	public void setCloseHour(String cHour) {
		this.closeHour = cHour;
	}


	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getOpenHour() {
		return openHour;
	}

	public void setOpenHour(String openHour) {
		this.openHour = openHour;
	}

	// redundant ???	
//	public void setRestList(ArrayList<String> restList) {
//		this.restList = restList;
//	}

		public ArrayList<String> getRestList() {
			return restList;
		}

		public void setRestList(String restName) {
			System.out.println("setting rest name : "+restName);
			
			this.restList.add(restName);
//			for(int i = 0; i < restList.size(); i++) {   
//			    System.out.print(restList.get(i));
//			}  
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public String getMgrName() {
			return mgrName;
		}

		public void setMgrName(String mgrName) {
			this.mgrName = mgrName;
		}
}
