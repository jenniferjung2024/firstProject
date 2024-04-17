# firstProject

Final for Principles of Computing with Java class (Fitness Center Industry - HighVoltage Fitness Center) - First semester (Spring 2023)

Start Date: May 4, 2023 6:00 PM

Due Date: May 11, 2023 11:59 PM

Instructions:

This is the final project for the class. Refer to zyBooks for the relevant sections, specifically 10.3 for ArrayLists if assistance is needed regarding the classes.

You will be building a customer service type menu system. Use one of the interactive compilers, or an IDE to test and run your code. 

https://www.tutorialspoint.com/online_java_compiler.php

https://www.jdoodle.com/online-java-compiler/

I highly recommend coding and testing each part separately before moving on to the next.

Please be sure to comment your code so I can read and understand what you are doing. Grading will be as follows:

25% comments and code documentation (comments!!!)

50% proper and correct code functionality (does it work?)

25% code output readability and clarity (is the output easy to read and use?)


    1. Main Menu
        a. Create a local method to display a main menu.
        b. Update the menu for each requirement below.

    2. Print customer list (main menu option 1)
        a. Create a method in the CustomerList class to print all customers, including the customer number and customer name. 
        b. If there are no customers, the method should indicate that as well.

    3. Add a new customer (main menu option 2)
        a. Create a method in the CustomerList class to add a new customer.
        b. Create a method in the CustomerList class to return the ID number of the last customer in the list.
        c. Prompt for the new name in the main program
        d. Add the new name using the newly created methods
        e. After the customer has  been added, display the customer's name and new ID number. 

    4. Select a customer (main menu option 3)
        a. Create a method in the CustomerList class to return the ID number of a specific customer
        b. Create a method in the CustomerList class to return the name of a specific customer
        c. Display the list of customers
        d. Prompt to select the customer number. Save this value in a variable to be used later.
        e. Display the selected customers name and ID number
        f. Update the main menu title to display the customer's name in parenthesis, if a customer has been selected, otherwise display the default main menu title.

    5. Exit (main menu option 9)
        a. End the program

    6. Update the Customer class for your service industry
        a. Attributes of this class should reflect your service industry: name, amount, paid, etc. Define those that you will need.
        b. Create get/set methods for each attribute
        c. Create an array of services for each customer with a maximum size of 10

    7. Service Menu
        a. Create a local method to display a customer service menu.
        b. Update the menu for each requirement below.
        c. Only the service menu options will be displayed when a customer is selected.

    8. Display Current Services (service menu option 1)
        a. Create a new method in the CustomerList class to display all services for a customer
        b. If  customer has no services, display a message saying so.

    9. Add a service to customer (service menu option 2)
        a. Create a method to display available services and cost
        b. You may also need to create a service in the CustomerList class to call the new method in the Customer class
        c. Select a service from the list, and update attributes for your class

    10. Pay for service (service menu option 3)
        a. Display services that are unpaid
        b. If no unpaid service, state "account is current"

    11. Exit Service Menu (service menu option 9)
        a. Exit the service menu and return to the main menu
        b. Unset the current customer before returning.

    12. All Customer Statistics (main menu option 4)
        a. create a method or methods to display:
            i. Total amount of services for all customers, broken down by paid and unpaid
            ii. Outstanding total of all unpaid service, regardless of customer.
