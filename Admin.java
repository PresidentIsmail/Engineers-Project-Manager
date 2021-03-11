public class Admin {

// Attributes of the class
	private int projectNumber;
	private String projectName;
	private String projectAddress;
	private String buildingType;
	private int erfNumber;
	private double chargeFee;
	private double alreadyPaid;
	private String deadline;	
	// objects of the Team class
	private Team customer;
	private Team contractor;
	private Team architect;
	
	
	// Constructor to promt the user to enter the details of the project
	public Admin(int projectNumber, String projectName, String projectAddress, String buildingType,
			int erfNumber, double chargeFee, double alreadyPaid, String deadline, Team customer, Team contractor, Team architect) { 
		
		// parameters that will hold the values that the user enters about the project
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.projectAddress = projectAddress;
		this.buildingType = buildingType; 
		this.erfNumber = erfNumber;
		this.chargeFee = chargeFee;
		this.alreadyPaid = alreadyPaid;
		this.deadline = deadline;
		this.customer = customer;
		this.contractor = contractor;
		this.architect = architect;
	}
	
	//return contractor infomation 
	public Team getContractor() {
		return contractor;
	}
	
	//return customers infomation
	public Team getCustomer() {
		return customer;
	}
	
	//return amount paid by customer
	public double getamountPAid() {
		return alreadyPaid;
	}
	
	//return fee for project
	public double getprojectCost() {
		return chargeFee;
	}
	
	
	//method to change the fee payed by the client 
	public void updateFee(double totalFee) {
		alreadyPaid += totalFee;
	}
	
	//method to get the ouststanding amount to be paid by the customer
	public double outstanding() {
		double amountOutstanding = chargeFee - alreadyPaid;
		return amountOutstanding;
	}
	
	//method to change the deadline
	public void updateDeadline(String Dday) {
		deadline = Dday;
	}
	
	//method to update the Contractors details
	
	
	// Method to display the details using the toString built-in function
	public String toString() {
		String infomation = "\nProject number: " + projectNumber + "\nProject name: " + projectName +
				"\nBuilding type: " + buildingType + "\nPhysical address: " + projectAddress +
				"\nERF number: " + erfNumber + "\nFee charged for project: " + chargeFee + 
				"\nAmount paid to date: " + alreadyPaid + "\nDeadline for project: " + deadline + 
				"\n\nProject Client:\n" + customer + "\n\nProject Contractor:\n" + contractor + 
				"\n\nProject Architect:\n" + architect;
		
		return infomation;
	}
}
