
public class Team {

	//delaring variables that all objects of this class will have	
	private String name;
	private String email;
	private String address;
	private String tel_number;

	// Constructor to promt user to enter the infomation of each 
	// person that is part of the project
	public Team(String name, String email, String address, String tel_number) {
		
		// the attributes are assigned with the parameters in the method
		this.name = name;
		this.address = address;
		this.email = email;
		this.tel_number = tel_number;
	}

	//getter and setter created for each attribute in the class
	//getter mithod returns the value to the atribute
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getTel_number() {
		return tel_number;
	}


	//seter method takes a parameter and assigns it to the attribute
	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setTel_number(String tel_number) {
		this.tel_number = tel_number;
	}


	// Method to display the members details using the toString built-in function
	public String toString() {
		String displayDetails = "Full name: " + name + "\nPhysical address: " + address + 
				"\nEmail address: " + email + "\nContact number: " + tel_number;
		return displayDetails;
	}
	
}


