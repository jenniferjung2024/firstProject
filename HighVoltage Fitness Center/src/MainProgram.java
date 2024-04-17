import java.util.ArrayList; 
import java.util.Scanner; 

 
class Service {   
 
    private String serviceName; // Declare a variable to hold the name of the service 

    private double cost;  // Declare a variable to hold the cost of the service 

    private boolean paid;  // Declare a variable to hold the boolean value of whether the service has been paid or not


    public Service() {   // Default constructor
        serviceName = "No name"; 
        cost = 0.00; 
        paid = false; 
    } 


    // Available services and associated cost
    private static String service1 = "Free one-day full-access pass (one-time use only)";
    private static double cost1 = 0.00;

    private static String service2 = "Basic monthly gym membership – no commitment";
    private static double cost2 = 24.99;

    private static String service3 = "Classic annual gym membership – 12-month commitment";
    private static double cost3 = 240.00;

    private static String service4 = "Premium annual gym membership – 12-month commitment";

    private static double cost4 = 360.00;


    // Set service as service1 
    public void setService1(boolean paidStatus) { 
       serviceName = service1;
       cost = cost1;
       paid = paidStatus;
    } 

               
    // Set service as service2
    public void setService2(boolean paidStatus) { 
       serviceName = service2;
       cost = cost2;
       paid = paidStatus;
    } 


    // Set service as service3
    public void setService3(boolean paidStatus) { 
       serviceName = service3;
       cost = cost3;
       paid = paidStatus;
    } 


    // Set service as service4
    public void setService4(boolean paidStatus) { 
       serviceName = service4;
       cost = cost4;
       paid = paidStatus;
    } 



     // Change paid status to true
    public void setPaidToTrue() { 
       paid = true; 
    } 


     // Re-set paid status to false in case of an error
    public void setPaidToFalse() { 
        paid = false; 
    } 


    // Return service name 
    public String getServiceName() { 
        return serviceName; 
    } 
 

    // Return cost 
    public double getCost() { 
        return cost; 
    } 


     // Return paid status
    public boolean getPaidStatus() { 
        return paid; 
    } 


    // Return service1 name 
    public static String getService1Name() { 
        return service1; 
    } 
 

    // Return cost for service1
    public static double getService1Cost() { 
        return cost1; 
    } 


    // Return service2 name 
    public static String getService2Name() { 
        return service2; 
    } 
 

    // Return cost for service2
    public static double getService2Cost() { 
        return cost2; 
    } 


    // Return service3 name 
    public static String getService3Name() { 
        return service3; 
    } 
 

    // Return cost for service 3
    public static double getService3Cost() { 
        return cost3; 
    } 


    // Return service4 name 
    public static String getService4Name() { 
        return service4; 
    } 
 

    // Return cost for service 4
    public static double getService4Cost() { 
        return cost4; 
    } 


}
 

class Customer { 

    private String firstName; 
    private String lastName; 
    private String id; 
 
    public Customer(String first, String last) { 
        firstName = first; 
        lastName = last; 
        setID(first,last); 
    } 
 
              
    // Return customer name 
    public String getName() { 
        return firstName + " " + lastName; 
    } 
 

    // Return customer ID 
    public String getID() { 
        return id; 
    } 
 

    // Set customer name 
    public void setName(String first, String last) { 
        firstName = first; 
        lastName = last; 
    } 
     

    // Create a new ID number based on the name 
    public void setID(String first, String last) {  
        final int ID_LENGTH = 7; 
        int randomNum = (int)Math.floor(Math.random() * Math.pow(10,ID_LENGTH-1)); 

        //String padStr = "0"; 
        //int padLength = ID_LENGTH - String.valueOf(randomNum).length();         

        StringBuilder paddedString = new StringBuilder(); 

        //paddedString.append(padStr.repeat(padLength));   // doesn't work on versions under Java 11 (JDK/JRE)

        String padStr = "0";

        for (int index = 0; index < ID_LENGTH - String.valueOf(randomNum).length(); index++) {
           paddedString.append(padStr);
        }


        paddedString.append(String.valueOf(randomNum)); 
        this.id = first.charAt(0) + last.charAt(0) + paddedString.toString(); 
    } 



    private ArrayList<Service> serviceList = new ArrayList<>(10);  // Create an ArrayList of services with a maximum of 10 services

    // Get size of ArrayList 
    public int getServiceListSize() { 
        return serviceList.size(); 
    } 


    // Add services

    public void addService1(boolean paidStatus) { 
       Service newService = new Service();
       newService.setService1(paidStatus);
       serviceList.add(newService);
    } 


    public void addService2(boolean paidStatus) { 
       Service newService = new Service();
       newService.setService2(paidStatus);
       serviceList.add(newService);
    } 

        
    public void addService3(boolean paidStatus) { 
       Service newService = new Service();
       newService.setService3(paidStatus);
       serviceList.add(newService);
    } 


    public void addService4(boolean paidStatus) { 
       Service newService = new Service();
       newService.setService4(paidStatus);
       serviceList.add(newService);
    } 


    // Set paid variable for a specific service to true
    public void setAsPaid(int userInput) { 
        serviceList.get(userInput - 1).setPaidToTrue();
    } 


    // Re-set paid variable for a specific service to false in case of an error
    public void resetToNotPaid(int userInput) { 
        serviceList.get(userInput - 1).setPaidToFalse();
    } 


    // Return a specific name of a service
    public String getNameOfService(int userInput) {     
       return serviceList.get(userInput - 1).getServiceName();
   }


   // Return a specific cost of a service
    public double getCostOfService(int userInput) {     
       return serviceList.get(userInput - 1).getCost();
   }


   // Return a specific paid status of a service
    public boolean getStatusOfPayment(int userInput) { 
       return serviceList.get(userInput - 1).getPaidStatus();
   }



}



class CustomerList { 
    private ArrayList<Customer> customerList = new ArrayList<>(); 
     
    public int getCustomerSize() {   // Re-adjusted name of method from getListSize() since there is a similar method
        return customerList.size(); 
    } 
     
    public void addCustomer(String first, String last) {  // Re-adjusted name of method from add() since there is another class that calls a similar method
        Customer newCustomer = new Customer(first,last); 
        customerList.add(newCustomer); 
    } 
     
     
    public void showAllCustomers() { 
       // Output whitespaces before list
       System.out.println();
       System.out.println("\nCustomer List:");

        for (int i = 0; i < customerList.size(); i++) { 
            int numOnList = i + 1;  // Declared a variable to hold the value of the number on the customer list, since i is the index and is set to 0 
  
            System.out.printf("%2d.) Customer %s: %s\n", numOnList, customerList.get(i).getID(), customerList.get(i).getName());  // Adjusted the print statement to have the variable numOnList instead of the index AND added a period after the number 
  
           } 
       // Output whitespaces after list
       System.out.println();
       System.out.println();
 
    }
 


 
    // Create a new method in the CustomerList class that returns the customer name 
    public String getCustomerName(int selectedCustomerNumber){            
    String customerName;  // Declare a variable to hold the selected customer name 
    customerName = customerList.get(selectedCustomerNumber - 1).getName();  // Call the method getName() from the Customer class to get the name of the selected customer from the ArrayList and set it to the newly declared customerName variable (note that index starts at 0, as opposed to the customer list that starts at 1) 
    return customerName; 
        } 
 
 
 
    // Create a new method in the CustomerList class that returns the customer ID 
    public String getCustomerID(int selectedCustomerNumber){            
    String customerID;  // Declare a variable to hold the selected customer ID 
    customerID = customerList.get(selectedCustomerNumber - 1).getID();  // Call the method getID() from the Customer class to get the ID of the selected customer from the ArrayList  and set it to the newly declared customerID variable (note that index starts at 0, as opposed to the customer list that starts at 1) 
    return customerID; 
        } 
 
 
    // Return size of specific customer’s service list
    public int getCustomerServiceListSize (int userSelectedNumber) {
return customerList.get(userSelectedNumber - 1).getServiceListSize();
   }


  // Print out a complete list of services for the customer
   public void showAllServices(int userSelectedNumber) { 
       System.out.println();
       System.out.println("\n\nService List for " + getCustomerName(userSelectedNumber));

        for (int i = 0; i < customerList.get(userSelectedNumber - 1).getServiceListSize(); ++i) { 
            int numOnList = i + 1;  // Declared a variable to hold the value of the number on the service list, since i is the index and is set to 0 
 
            System.out.println(); // Print a space between previous input and the new output

	       System.out.printf("%2d.) Service: ", numOnList);
            System.out.println(customerList.get(userSelectedNumber - 1).getNameOfService(i + 1));    
            System.out.printf("      Cost: %.2f\n", customerList.get(userSelectedNumber - 1).getCostOfService(i + 1));           
            System.out.print("      Paid: ");

            if (customerList.get(userSelectedNumber - 1).getStatusOfPayment(i + 1) == true) {
			System.out.println("Yes");
           }


           else {
			System.out.println("No");
           }       
     
        }  

       // Print space after output
       System.out.println();
       System.out.println();

} 

 

    // Add service1 to specific customer
    public void addService1ToCustomer(int userSelectedNumber, boolean paidYN) {
customerList.get(userSelectedNumber - 1).addService1(paidYN);
   }

 
    // Add service2 to specific customer
    public void addService2ToCustomer(int userSelectedNumber, boolean paidYN) {
customerList.get(userSelectedNumber - 1).addService2(paidYN);
   }
 

    // Add service3 to specific customer
    public void addService3ToCustomer(int userSelectedNumber, boolean paidYN) {
customerList.get(userSelectedNumber - 1).addService3(paidYN);
   }
 

    // Add service4 to specific customer
    public void addService4ToCustomer(int userSelectedNumber, boolean paidYN) {
customerList.get(userSelectedNumber - 1).addService4(paidYN);
   }


    // Set paid variable for a specific service for a particular customer in the ArrayList to true
    public void setSelectedServiceToPaid(int selectedCustomerNumber, int selectedServiceNumber) { 

int j = 1;

        for (int i = 0; i < customerList.get(selectedCustomerNumber - 1).getServiceListSize(); ++i) { 

while (customerList.get(selectedCustomerNumber - 1).getStatusOfPayment(i + 1) == false) {

if (j == selectedServiceNumber) {

        		customerList.get(selectedCustomerNumber - 1).setAsPaid(i + 1);
}
++j;

		}

       }

    } 


    // Re-set paid variable for a specific service for a particular customer in the ArrayList to false in case of an error
    public void resetSelectedServiceToNotPaid(int selectedCustomerNumber, int selectedServiceNumber) { 
int j = 1;

        for (int i = 0; i < customerList.get(selectedCustomerNumber - 1).getServiceListSize(); ++i) { 

while (customerList.get(selectedCustomerNumber - 1).getStatusOfPayment(i + 1) == false) {

if (j == selectedServiceNumber) {
        		customerList.get(selectedCustomerNumber - 1).setAsPaid(i + 1);

}

++j;

		}

       }

    } 



      // Return the number of unpaid services for the customer
      public int getCountUnpaidServices(int userSelectedNumber) { 
      int countUnpaid = 0;  // Declared a variable to hold the count of unpaid services

      for (int i = 0; i < customerList.get(userSelectedNumber - 1).getServiceListSize(); ++i) { 
 
            if (customerList.get(userSelectedNumber - 1).getStatusOfPayment(i + 1) == false) {
	       ++countUnpaid;
            }
      }

      return countUnpaid;
      }


  // Print out a list of unpaid services for the customer
   public void printUnpaidServices(int userSelectedNumber) { 
       int numOnList = 0;  // Use this variable to hold both the number on the list AND the count

       System.out.println();
       System.out.print("\n\nUnpaid Services for " + getCustomerName(userSelectedNumber));

        for (int i = 0; i < customerList.get(userSelectedNumber - 1).getServiceListSize(); ++i) { 
 
            System.out.println(); // Print a space between previous input and the new output

            if (customerList.get(userSelectedNumber - 1).getStatusOfPayment(i + 1) == false) {
	       ++numOnList;
	       System.out.printf("%2d.) Service: ", numOnList);
            System.out.println(customerList.get(userSelectedNumber - 1).getNameOfService(i + 1));    
            System.out.printf("      Cost: %.2f\n", customerList.get(userSelectedNumber - 1).getCostOfService(i + 1));           
            System.out.print("      Paid: No");
           }       
     
        }  

       // Print space after output
       System.out.println();
       System.out.println();

} 



       // Return total amount of unpaid services 
       public double calcTotalUnpaid() { 
       double totalUnpaid = 0.00;

       for (int i = 0; i < customerList.size(); ++i) { 

        	for (int j = 0; j < customerList.get(i).getServiceListSize(); ++j) { 
			if (customerList.get(i).getStatusOfPayment(j + 1) == false) {
				totalUnpaid = totalUnpaid + customerList.get(i).getCostOfService(j + 1);
			}

       	}

       }

       return totalUnpaid;

       }

       // Return total amount of paid services 
       public double calcTotalPaid() { 
       double totalPaid = 0.00;

       for (int i = 0; i < customerList.size(); ++i) { 

        	for (int j = 0; j < customerList.get(i).getServiceListSize(); ++j) { 
			if (customerList.get(i).getStatusOfPayment(j + 1) == true) {
				totalPaid = totalPaid + customerList.get(i).getCostOfService(j + 1);
			}

       	}

       }

       return totalPaid;

       }



}



 
public class MainProgram { 
 
    public static void mainMenu() {    // Create a method to print out main menu  
        System.out.println("Main Menu for HighVoltage Fitness Center:");  
        System.out.println("  1: Print Customer List");  
        System.out.println("  2: Add New Customer");  
        System.out.println("  3: Select A Customer");  
        System.out.println("  4: View Statistics");  
        System.out.println("  9: Exit\n"); 
        System.out.print("Enter option number: "); 
  
 } 
 
 
 
    public static void serviceMenu() {    // Create a method to display current services for a specific customer
        System.out.println("  1: Display Current Services");  
        System.out.println("  2: Add Service");  
        System.out.println("  3: Pay for Service");  
        System.out.println("  9: Back to HighVoltage Fitness Center Main Menu\n");  
        System.out.print("Selection: "); 
 
 } 
 
 
 
    public static void serviceList() {    // Create a method to display the list of available services for customers to chose from
        System.out.println("\nAvailable Services\n");  
        System.out.println("  1: " + Service.getService1Name());  
        System.out.printf("      Cost: $%.2f\n\n", + Service.getService1Cost());  
        System.out.println("  2: " + Service.getService2Name());  
        System.out.printf("      Cost: $%.2f\n\n", + Service.getService2Cost());  
        System.out.println("  3: " + Service.getService3Name());  
        System.out.printf("      Cost: $%.2f\n\n", + Service.getService3Cost());  
        System.out.println("  4: " + Service.getService4Name());  
        System.out.printf("      Cost: $%.2f\n\n\n", + Service.getService4Cost());  
        System.out.print("Type number to add service: "); 
 
 } 



    public static void statisticsMenu() {    // Create a method to display a list of stats for all customers that the user can choose from
        System.out.println("\n\n\nStatistics Menu\n");
        System.out.println("  1: Total Amount of All Paid Services for HighVoltage Fitness Center");  
        System.out.println("  2: Outstanding Total of All Unpaid Services for HighVoltage Fitness Center");  
        System.out.println("  9: Back to HighVoltage Fitness Center Main Menu\n");  
        System.out.print("Selection: "); 
 
 } 



    public static String createConfirmationNum() {  // Create a new confirmation number
        final int SIZE = 20;
 
        // Choose a Character random from this String
          String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
 
        // Create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(SIZE);
 
          for (int i = 0; i < SIZE; i++) {
            // generate a random number between 0 to AlphaNumericString variable length
            int index = (int)(AlphaNumericString.length() * Math.random());
 
            // add Character one by one in end of sb
            sb.append(AlphaNumericString.charAt(index));
            }
 
         return sb.toString();
         }




    public static void main(String[] args) { 
         
        Scanner scnr = new Scanner(System.in); 
        CustomerList customers = new CustomerList(); 
              
        int option;  // Declare a new integer to hold option variable  
 
        mainMenu();  // Call on the mainMenu method to print out the main menu  
   
        option = scnr.nextInt();  // Look for input  
   
    
        while (option != 9) {  // Execute state machine loop if the user does not input 9  
   
        if (option == 1) {  // Execute only if user selects option 1 
        	if (customers.getCustomerSize() == 0) { 
System.out.println(">>> No customers in the system\n\n");  // Print this statement only if there is nothing in the ArrayList 
} 
 
else { 
customers.showAllCustomers(); // Call method in customerList class to print the customer IDs and names of all customers in the ArrayList – as long as there is at least one customer in the ArrayList 
 
   }         
 
        }  
   
    
        else if (option == 2) { // Execute only if user selects option 2 
        System.out.print("Enter first name of new customer: "); 

        scnr.nextLine();  // Clear the scanner to get ready for the next input of name (in case the customer has more than one word in either the first name or the last name)


        String firstName = scnr.nextLine();  // Declare a new variable to hold the first name of the customer and set it to the user input from the keyboard 


        boolean isLetter = true;  // Declare a new variable to store the boolean value that holds whether or not a String has all letters in it and set it to true

        for (int i = 0; i < firstName.length(); ++i) {

        	if (!Character.isLetter(firstName.charAt(i)) && firstName.charAt(i) != ' ') {

isLetter = false;
}
        }


        while (isLetter == false) {

        	System.out.print("\n\n Invalid first name.  Type first name again: ");

        	firstName = scnr.nextLine();  // Read user input from scanner

		isLetter = true;  // Reset isLetter value

for (int i = 0; i < firstName.length(); ++i) {

if (!Character.isLetter(firstName.charAt(i)) && firstName.charAt(i) != ' ') {
	
isLetter = false;
	}
}
        }



 
        System.out.println(); // Add whitespaces for clarity in output 
 
        System.out.print("Enter last name of new customer: "); 
 
        String lastName = scnr.nextLine();  // Declare a new variable to hold the last name of the customer and set it to the user input from the keyboard 
 
		
        for (int i = 0; i < lastName.length(); ++i) {

if (!Character.isLetter(lastName.charAt(i)) && lastName.charAt(i) != ' ') {
	
isLetter = false;
}
        }


        while (isLetter == false) {

System.out.print("\n\n Invalid last name.  Type last name again: ");

		lastName = scnr.nextLine();  // Read user input from scanner

		isLetter = true;  // Reset isLetter value

for (int i = 0; i < lastName.length(); ++i) {

	if (!Character.isLetter(lastName.charAt(i)) && lastName.charAt(i) != ' ') {
	
isLetter = false;
	}
}
        }

         
        customers.addCustomer(firstName, lastName); // Call method in customerList class to add a new customer 

        System.out.println("\n\n>>> Entry added.");

 
        }  
   
   
        else if (option == 3) { // Execute only if user selects option 3 
     

        if (customers.getCustomerSize() == 0) { 
System.out.println(">>> No customers in the system\n\n");  // Print this statement only if there is nothing in the ArrayList 
        } 

        else {
          customers.showAllCustomers();  // Display customer list by calling on the method for the customers object in the CustomerList class 
 
 
          System.out.print("Enter customer number: ");  // Output instructions 
 
          int selectedCustomerNumber = scnr.nextInt();  // Declare a new int variable and set it to the next scanned input from the keyboard 
 
          // Print out some whitespaces before new output on screen 
          System.out.println(); 
          System.out.println(); 
 
 
          // Print out specific customer name and ID by calling on two methods in the CustomerList class and output with appropriate white spaces 
          System.out.println("Name: " + customers.getCustomerName(selectedCustomerNumber)); 
          System.out.println("ID: " + customers.getCustomerID(selectedCustomerNumber) + "\n\n"); 
 
 
          System.out.println("Customer Service Menu for " +   customers.getCustomerName(selectedCustomerNumber) + ":\n");  // Output the title to the customer service menu based on the selection from the user 

 
          serviceMenu();  // Call serviceMenu method to output the service menu on the screen 

         int selection = scnr.nextInt(); // Declare a new variable to hold the user selection in the service menu
 
         int addServiceInput; // Declare a new variable to hold the number of service that the user wants to add

         boolean paid;  // Declare a new variable called paid to hold the boolean value of whether the service has been paid or not


         while (selection != 9) {

           if (selection == 1) {
// Print the below if there are no items in the ServiceList ArrayList
if (customers.getCustomerServiceListSize(selectedCustomerNumber) == 0) {
System.out.println("\n\n>>> Customer has no service.\n\n");
			}
		
			else {
		    	customers.showAllServices(selectedCustomerNumber);
			}
 
        	}  


           else if (selection == 2) {
			//Add whitespace between user input and output
			System.out.println();
			System.out.println();

			serviceList();  // Call on the serviceList method to display the services that are available at this time

addServiceInput = scnr.nextInt();  // Set the variable to the next scanned user input from the keyboard

			if (addServiceInput == 1) {
			
			System.out.println();  // Print whitespace between user input and output
		
			System.out.print(">>> Paid at time of check-out?  Enter 'Y' for Yes and 'N' for No: ");

			char yesNo = scnr.next().charAt(0);  // Declare a new variable and set it to the next input from the user

				if (yesNo == 'Y' || yesNo == 'y') {
				paid = true;					customers.addService1ToCustomer(selectedCustomerNumber, paid);
				System.out.println("\n\n>>> Entry added. <<<");

				}

				else if (yesNo == 'N' || yesNo == 'n') {
				paid = false;
					customers.addService1ToCustomer(selectedCustomerNumber, paid);

				System.out.println("\n\n>>> Entry added. <<<");
				}

				else {
				System.out.println("\n\n>>> Invalid entry.  Paid at time of check-out?  Enter 'Y' for Yes and 'N' for No: ");

				yesNo = scnr.next().charAt(0);
				}


				// Add whitespace
				System.out.println();
				System.out.println();


}


			else if (addServiceInput == 2) {

System.out.println();  // Print whitespace between user input and output
		
			System.out.print(">>> Paid at time of check-out?  Enter 'Y' for Yes and 'N' for No: ");

			char yesNo = scnr.next().charAt(0);  // Declare a new variable and set it to the next input from the user

				if (yesNo == 'Y' || yesNo == 'y') {
				paid = true;					customers.addService2ToCustomer(selectedCustomerNumber, paid);
				System.out.println("\n\n>>> Entry added. <<<");

				}

				else if (yesNo == 'N' || yesNo == 'n') {
				paid = false;
					customers.addService2ToCustomer(selectedCustomerNumber, paid);

				System.out.println("\n\n>>> Entry added. <<<");
				}

				else {
				System.out.println("\n\n>>> Invalid entry.  Paid at time of check-out?  Enter 'Y' for Yes and 'N' for No: ");

				yesNo = scnr.next().charAt(0);
				}


				// Add whitespace
				System.out.println();
				System.out.println();

			}



			else if (addServiceInput == 3) {


System.out.println();  // Print whitespace between user input and output
		
			System.out.print(">>> Paid at time of check-out?  Enter 'Y' for Yes and 'N' for No: ");

			char yesNo = scnr.next().charAt(0);  // Declare a new variable and set it to the next input from the user

				if (yesNo == 'Y' || yesNo == 'y') {
				paid = true;					customers.addService3ToCustomer(selectedCustomerNumber, paid);
				System.out.println("\n\n>>> Entry added. <<<");

				}

				else if (yesNo == 'N' || yesNo == 'n') {
				paid = false;
					customers.addService3ToCustomer(selectedCustomerNumber, paid);

				System.out.println("\n\n>>> Entry added. <<<");
				}

				else {
				System.out.println("\n\n>>> Invalid entry.  Paid at time of check-out?  Enter 'Y' for Yes and 'N' for No: ");

				yesNo = scnr.next().charAt(0);
				}


				// Add whitespace
				System.out.println();
				System.out.println();



			}

			else if (addServiceInput == 4) {


System.out.println();  // Print whitespace between user input and output
		
			System.out.print(">>> Paid at time of check-out?  Enter 'Y' for Yes and 'N' for No: ");

			char yesNo = scnr.next().charAt(0);  // Declare a new variable and set it to the next input from the user

				if (yesNo == 'Y' || yesNo == 'y') {
				paid = true;					customers.addService4ToCustomer(selectedCustomerNumber, paid);
				System.out.println("\n\n>>> Entry added. <<<");

				}

				else if (yesNo == 'N' || yesNo == 'n') {
				paid = false;
					customers.addService4ToCustomer(selectedCustomerNumber, paid);

				System.out.println("\n\n>>> Entry added. <<<");
				}

				else {
				System.out.println("\n\n>>> Invalid entry.  Paid at time of check-out?  Enter 'Y' for Yes and 'N' for No: ");

				yesNo = scnr.next().charAt(0);
				}


				// Add whitespace
				System.out.println();
				System.out.println();


			}

			else {
			System.out.println(">>> Invalid selection.  Try again.\n\n ");

// Print a few spaces 
        		System.out.println(); 
        		System.out.println();   
   
        		serviceList();  // Call on serviceList method to print out service list again and wait for user input
   
        		addServiceInput = scnr.nextInt();  // Look for input  
   
        		}  
   


       	}


           else if (selection == 3) {

			if (customers.getCountUnpaidServices(selectedCustomerNumber) == 0) {
				System.out.println("\n\n>>> Account is current.\n\n");
			}

			else {
				customers.printUnpaidServices(selectedCustomerNumber);

 			System.out.print("Select service number to pay: "); 
			
			int selectedServiceNumber = scnr.nextInt();

		customers.setSelectedServiceToPaid(selectedCustomerNumber, selectedServiceNumber);

			System.out.print("\n\n>>> Enter first name on credit card: ");  // Prompt user to enter the first name that is on the credit card

			
			scnr.nextLine();  // Clear the scanner to get ready for the next input of name (in case there is more than one word in either the first name or the last name)


			String firstNameCard = scnr.nextLine();  // Declare a new variable to store the first name and read user input from scanner

			boolean isLetter = true;  // Declare a new variable to store the boolean value that holds whether or not a String has all letters in it and set it to true

for (int i = 0; i < firstNameCard.length(); ++i) {

				if (!Character.isLetter(firstNameCard.charAt(i)) && firstNameCard.charAt(i) != ' ') {

isLetter = false;
				}
}

while (isLetter == false) {

System.out.print("\n\n Invalid first name.  Type first name again: ");

				firstNameCard = scnr.nextLine();  // Read user input from scanner

				isLetter = true;  // Reset isLetter value

for (int i = 0; i < firstNameCard.length(); ++i) {

				if (!Character.isLetter(firstNameCard.charAt(i)) && firstNameCard.charAt(i) != ' ') {
	
isLetter = false;
				}
}
			}


System.out.print("\n\n>>> Enter last name on credit card: ");  // Prompt user to enter the last name that is on the credit card


			String lastNameCard = scnr.nextLine();  // Declare a new variable to store the last name and read user input from scanner

		
for (int i = 0; i < lastNameCard.length(); ++i) {

				if (!Character.isLetter(lastNameCard.charAt(i)) && lastNameCard.charAt(i) == ' ') {
	
isLetter = false;
				}
}

while (isLetter == false) {

System.out.print("\n\n Invalid last name.  Type last name again: ");

				lastNameCard = scnr.nextLine();  // Read user input from scanner

				isLetter = true;  // Reset isLetter value

for (int i = 0; i < lastNameCard.length(); ++i) {

				if (!Character.isLetter(lastNameCard.charAt(i)) && lastNameCard.charAt(i) != ' ') {
	
isLetter = false;
				}
}
			}


System.out.print("\n\n>>> Enter 16-digit credit card number (no dashes or spaces): ");  // Prompt user to enter the 16-digit card number


			String cardNumber = scnr.next();  // Declare a new variable to store the card number and read user input from scanner.  Store as a String, so that character function can be called for validation

			boolean isDigit = true;  // Declare a new variable to store the boolean value that holds whether or not a String has all digits in it and set it to true


		
for (int i = 0; i < cardNumber.length(); ++i) {

				if (!Character.isDigit(cardNumber.charAt(i)) || cardNumber.length() != 16) {

isDigit = false;  // Set isDigit boolean variable to false either if there is a character that is not a digit OR if the cardNumber length is not equal to 16
				}
}

while (isDigit == false) {

System.out.print("\n\n Invalid card number.  Type 16-digit card number again without any dashes or spaces: ");

				cardNumber = scnr.next();  // Read user input from scanner

				isDigit = true;  // Reset isDigit value

for (int i = 0; i < cardNumber.length(); ++i) {

				if (!Character.isDigit(cardNumber.charAt(i)) || cardNumber.length() != 16) {

isDigit = false;  // Set isDigit boolean variable to false either if there is a character that is not a digit OR if the cardNumber length is not equal to 16
				}
}
			}

			int n = 20;

			



System.out.println("\n\n>>> Paid.  Thank you!");

System.out.println("      Confirmation # " + createConfirmationNum() + "\n\n");
			
			}

        	}



           else { 
           System.out.println(">>> Invalid selection.  Try again.\n\n");  
        }  




			System.out.println("Customer Service Menu for " +   customers.getCustomerName(selectedCustomerNumber) + ":\n");

			serviceMenu();  // Call serviceMenu method to output the service menu on the screen 

			selection = scnr.nextInt();  // Look for user input again

       }

        if(selection == 9) System.out.println();

   
       }

       }

   
       else if (option == 4) {  // Execute only if user selects option 4

       statisticsMenu();  // Call the method to display the statistics menu

       int statsSelection = scnr.nextInt();  // Declare a variable to hold the selection from the user and set it to the input from the user

       while(statsSelection != 9) {

		if (statsSelection == 1) {

System.out.printf("\n\n\n>>> Total Amount of All Paid Services: $%.2f\n", customers.calcTotalPaid());

		}

		else if (statsSelection == 2) {

System.out.printf("\n\n\n>>> Outstanding Total of All Unpaid Services: $%.2f\n", customers.calcTotalUnpaid());

		}

else {
			System.out.print("\n\n>>> Invalid entry.");

		}


		statisticsMenu();  // Call the method to display the statistics menu

		statsSelection = scnr.nextInt();  // Look for next input from the user

       }


       if(statsSelection == 9) System.out.println();

       }

   

        else { 
        System.out.println(">>> Invalid option number.  Try again.\n\n");  
        }  
   
        // Print a few spaces 
        System.out.println(); 
        System.out.println();   
   
        mainMenu();  // Call on mainMenu method to print out main menu once conditional statement executes 
   
        option = scnr.nextInt();  // Look for input  
   
        }  
   
   
        if (option == 9) {    // Print this if user inputs 9 (exit)
            System.out.println(">>> Thank you for using HighVoltage Fitness Center’s customer tracking system.");  
            System.out.println("    Goodbye!");
        }
   
        scnr.close();
   
    }  
    
} 

