package POJOEx5;

import java.util.List;

public class HouseDetailsPOJO {
	private int flatNo;
	private String street;
	private List<String> landmark;
	
	
	public int getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public List<String> getLandmark() {
		return landmark;
	}
	public void setLandmark(List<String> landmark) {
		this.landmark = landmark;
	}
}
