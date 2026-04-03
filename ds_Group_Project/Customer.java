package ds_Group_Project;

public class Customer {
	private String fname;
	private String lname;
	private String email;
	private String password;
	
	public Customer() {
		fname = "Serena";
		lname = "Craig";
		email = "serenajaNaleah@gmail.com";
		password = "theegirlsof24";
	}
	
	public Customer(String first, String last, String e, String pass) {
		fname = first;
		lname = last;
		email = e;
		password = pass;
	}
	
	public String getFName() { return fname; }
	public void setFName(String first) { fname = first; }
	public String getLName() { return lname; }
	public void setLName(String last) { lname = last; }
	public String getEmail() { return email; }
	public void setEmail(String e) { email = e; }
	public String getPassword() { return password; }
	public void setPassword(String pass) { password = pass; }
	
	public void Display() {
		System.out.println("Customer Information");
		System.out.println("Name: " + fname + " " + lname);
		System.out.println("Email: " + email);
		System.out.println("Password: " + password);
		
	}
}
