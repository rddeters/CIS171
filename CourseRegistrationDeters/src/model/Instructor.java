/**  
* River Deters - mddeters  
* CIS171 22149
* Jul 16, 2023
* Windows 10 Operating System Eclipse Version - 2023-03 
*/

package model;

public class Instructor {
	private String firstName;
	private String lastName;
	private String email;
	
	public Instructor() {
		setFirstName("John");
		setLastName("Smith");
		setEmail(" ");
	}
	
	public Instructor(String fname, String lname) {
		setFirstName(fname);
		setLastName(lname);
		setEmail(" ");
	}
	
	public Instructor(String fname, String lname, String email) {
		setFirstName(fname);
		setLastName(lname);
		setEmail(email);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
    public String toString() {
        return "Instructor [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }
}
