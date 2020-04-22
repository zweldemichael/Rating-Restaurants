package provider;

public class MenuItem {
	
	String name;
	String itemType;
	String desc;
	String price;
	String categ;
	
	int intType;
	int intCateg;
	
	public int getIntType() {
		return intType;
	}
	public int getIntCateg() {
		return intCateg;
	}
	public void setIntType(int intType) {
		this.intType = intType;
	}
	public void setIntCateg(int intCateg) {
		this.intCateg = intCateg;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getName() {
		return name;
	}
	public String getDesc() {
		return desc;
	}
	public String getPrice() {
		return price;
	}
	public String getCateg() {
		return categ;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setCateg(String categ) {
		this.categ = categ;
	}
	
	

}
