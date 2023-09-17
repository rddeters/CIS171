/**  
 * River Deters - mddeters  
 * CIS171 22149
 * July 7th, 2023
 * Windows 10 Operating System Eclipse Version - 2023-03
 */ 

public class Address {
	private String address;
	private String address2;
	private String city;
	private String state;
	private String zipCode;
	
	public Address() {
		setAddress("111 1st St");
		setAddress2("Apt 101");
		setCity("Chicago");
		setState("Illinois");
		setZipCode("11111");
	}
	
	public Address(String add, String ct, String st, String zc) {
		setAddress(add);
		setCity(ct);
		setState(st);
		setZipCode(zc);
	}
	
	public Address(String add, String add2, String ct, String st, String zc) {
		setAddress(add);
		setAddress2(add2);
		setCity(ct);
		setState(st);
		setZipCode(zc);
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String print() {
	    String finalAddress;
	        
	    if (getAddress2() == null) {
	        finalAddress = getAddress() + " " + getCity() + ", " + getState() + " " + getZipCode();
	    } else {
	        finalAddress = getAddress() + " " + getAddress2() + " " + getCity() + ", " + getState() + " " + getZipCode();
	    }

	    return finalAddress;
	}

}
