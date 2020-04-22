package provider;

public class Rating {
	String uname;
	String restName;
	String price;
	String food;
	String mood;
	public String getMood() {
		return mood;
	}
	public void setMood(String mood) {
		this.mood = mood;
	}
	String staff;
	String comment;
	public String getUname() {
		return uname;
	}
	public String getRestName() {
		return restName;
	}
	public String getPrice() {
		return price;
	}
	public String getFood() {
		return food;
	}
	public String getStaff() {
		return staff;
	}
	public String getComment() {
		return comment;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public void setStaff(String staff) {
		this.staff = staff;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
