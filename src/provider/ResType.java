package provider;

import java.util.ArrayList;

public class ResType {
	String resType; // name of rest Type
	String resName; // restaurant name
	String openDate; // rest. 1st open date
	String mgrName;
	
	ArrayList<String> restTypeList = new ArrayList<String>(); // populate rest. in dropdown

	
	public ArrayList<String> getRestTypeList() {
		return restTypeList;
	}

	public void setRestTypeList(String restTypeList) {
		this.restTypeList.add(restTypeList);
	}

	public String getResType() {
		return resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
	}

}
