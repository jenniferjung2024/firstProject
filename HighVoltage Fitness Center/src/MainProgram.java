import java.util.ArrayList;
import java.util.Scanner;

class Customer {

    private String firstName;
    private String lastName;
    private String id;

    public Customer(String first, String last) {
        firstName = first;
        lastName = last;
        setID(first,last);
    }
         
    //Return name
    public String getName() {
        return firstName + " " + lastName;
    }

    //return ID
    public String getID() {
        return id;
    }

    //set name
    public void setName(String first, String last) {
        firstName = first;
        lastName = last;
    }
    
    //create a new ID number based on the name
    public void setID(String first, String last) { 
        final int ID_LENGTH = 7;
        int randomNum = (int)Math.floor(Math.random() * Math.pow(10,ID_LENGTH-1));
        String padStr = "0";
        int padLength = ID_LENGTH - String.valueOf(randomNum).length();        
        StringBuilder paddedString = new StringBuilder();
        paddedString.append(padStr.repeat(padLength));
        paddedString.append(String.valueOf(randomNum));
        this.id = first.charAt(0) + last.charAt(0) + paddedString.toString();
    }
       
}



class CustomerList {

    private ArrayList<Customer> customerList = new ArrayList<>();
    
    public int getListSize() {
        return customerList.size();
    }
    
    public void add(String first, String last) {
        Customer newCustomer = new Customer(first,last);
        customerList.add(newCustomer);
    }
    
    public void showAllCustomers() {
        for (int i = 0; i < customerList.size(); i++) {
            System.out.printf("%2d) Customer %s: %s\n", i, customerList.get(i).getID(), customerList.get(i).getName());
        }
    }

}



public class MainProgram {
    public static void main(String[] args) {
        
        Scanner scnr = new Scanner(System.in);
        CustomerList customers = new CustomerList();
             
        //Build Main Menu here
   
        
    }
}

