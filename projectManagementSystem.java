import java.text.BreakIterator;
import java.util.*;

public class projectManagementSystem {
	
	
//method to create the objects from the team class
	public static Team projectMembers() {
		
		// get input from the user
		Scanner input = new Scanner(System.in);	
		
		// name of member
		System.out.print("Full name: ");
		String name = input.nextLine();
		
		// email of user
		System.out.print("Email address: ");
		String email = input.nextLine();
		
		// physical address of member
		System.out.print("Physical address: ");
		String address = input.nextLine();
		
		// contact number of member
		System.out.print("Contact number: ");
		String number = input.nextLine();
		
		Team teamMember = new Team(name, email, address, number);
		return teamMember;
	}


	
//method to change the due date of the project
	public static String changeDate() {
		
		//user prompted to enter new date
		System.out.println("Enter new deadline: ");
		Scanner in = new Scanner(System.in);
		String newDate = in.nextLine();
		return newDate;
	}
	
// method to change the total fee paid by the customer
	public static double changeFee() {
		
		//user prompted to enter new total fee paid
		System.out.println("Enter updated fee of the customer: ");
		Scanner in = new Scanner(System.in);
		double newFee = in.nextDouble();
		return newFee;
	}
	
	//method to create the project
	public static Admin createProject() {
		
		// Variables that will hold the details of the project
		// entered by the user
		int projectNumber;
		String projectName;
		String projectAddress;
		String buildingType;
		int erfNumber;
		double chargeFee;
		double alreadyPaid;
		String deadline;
		
		// get input from the user
		Scanner input = new Scanner(System.in);	


		
		//information about the architect in the project
		System.out.println("Enter Architects details below.\n");
		Team architect = projectMembers();
		
		
		//information about the contractor in the project
		System.out.println("\nEnter Contractors details below.\n");
		Team contractor = projectMembers();

		
		//information about the customer in the project
		System.out.println("\nEnter Clients details below.\n");
		Team customer = projectMembers();
		

		
		//information about the project
		System.out.println("\n\nEnter project infomation below:");
		// project number
		System.out.print("\nEnter the project number: ");
		projectNumber = input.nextInt();
		
		// name of the project
		input = new Scanner(System.in);
		System.out.print("\nEnter the name of the project: ");
		projectName = input.nextLine();
		
		
		// project address
		input = new Scanner(System.in);
		System.out.print("\nEnter the address of the project: ");
		projectAddress = input.nextLine();
		
		// type of building
		input = new Scanner(System.in);
		System.out.print("\nEnter the building type: ");
		buildingType = input.nextLine();
		
		// ERF number of project
		input = new Scanner(System.in);
		System.out.print("\nEnter the ERF number: ");
		erfNumber = input.nextInt();
		
		// Fee to be charged
		input = new Scanner(System.in);
		System.out.print("\nEnter the fee charged for the project: R");
		chargeFee = input.nextDouble();
		
		// amount that is already paid
		input = new Scanner(System.in);
		System.out.print("\nEnter the amount has already been paid: R");
		alreadyPaid = input.nextDouble();
		 
		// Deadline of the project
		input = new Scanner(System.in);
		System.out.print("\nEnter the project deadline (dd/mm/yyyy): ");
		deadline = input.nextLine();
		
		// make an object from the Admin class and display all details of the project by calling the toString method
		System.out.println("\nProject details displayed below.");
		Admin projectDetails = new Admin(projectNumber, projectName, projectAddress, buildingType, erfNumber, chargeFee, alreadyPaid, deadline, customer, contractor, architect);

		return projectDetails;
	}
	
// Main method
	public static void main(String[] args) {

		// get input from user
		Scanner input = new Scanner(System.in);
		
//Display to console
				
				Admin projectDetails = createProject();
				
				System.out.println(projectDetails + "\n");

		
// menu displayed to the user 
		int stop = 0;
		while (stop == 0) {
			System.out.println("\n\nSelect one of the following options:");
			System.out.println("Enter 1 - to Change the deadline of the project"
					+ "\nEnter 2 - to Change the total fee paid by the customer"
					+ "\nEnter 3 - to Update contractors details"
					+ "\nEnter 4 - to finalise project"
					+ "\nEnter 5 - to Exit program");
			
			// user inputs the number they chose
			System.out.print("\nEnter number selection here: ");
			int menuChoice = input.nextInt();

// changes to the project details

			// the new date they entered overwrites the old deadline 
			if (menuChoice == 1) {
				String deadline = changeDate();
				projectDetails.updateDeadline(deadline);
				//display the project details with the deadline changed
				System.out.println(projectDetails);
				
				// show the user the menu again
				stop = 0;
				
			}else if (menuChoice == 2) { 
				
				// new total fee paid entered overwrite old total
				double alreadyPaid = changeFee();
				projectDetails.updateFee(alreadyPaid);
				
				//display the project details with the customers fee changed
				System.out.println(projectDetails);
				stop = 0;
				
			}else if (menuChoice == 3) {
				Scanner in = new Scanner(System.in);	
				//updated contractor details are displayed 

				// edit number of contractor
				System.out.println("Contact number: ");
				String number = in.nextLine();
				projectDetails.getContractor().setTel_number(number);
				
				// edit email of contractor
				System.out.println("Email address: ");
				String email = input.nextLine();
				projectDetails.getContractor().setEmail(email);
				
				// edit address of contractor
				System.out.println("Physical address: ");
				String address = in.nextLine();
				projectDetails.getContractor().setAddress(address);
				
				// display the contractors details 
				System.out.println("\nContractor details:");
				System.out.println(projectDetails.getContractor());
				 stop = 0;
				 
			}else if (menuChoice == 4) {
				
				// calculate the total amount outstanding by getting the amount of the project and subtracting it
				// from the amount the user paid
				double outAmount = projectDetails.getprojectCost() - projectDetails.getamountPAid();
				//make invoice
				if (outAmount != 0) {
					System.out.println("\nClient being billed:");
					System.out.println(projectDetails.getCustomer());
					System.out.println("amount outstanding from client: R" + outAmount);
					stop = 0;
					
				}else {
					System.out.println("Project has been finalized!");
					stop = 0;
				}

				
			}else if (menuChoice == 5) {
				System.out.println("\nThank you for using the program ;)");
				stop = 1;
				break;
		
			}
				
		}
	}

}
