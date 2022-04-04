package EventCustomerCounter;
import java.util.ArrayList;

class CustomerCounter                                                                                  // all methods inside this class belongs to class and not to object(static).
{

    private int currentCustomerAmount;                                                          // variable represents how many customers in the venue at the moment
    private int maxCapacity;                                                                    // should be set before GUI
    public ArrayList<CustomerCounter> allCustomers = new ArrayList<>();                         // this ArrayList will store references for every instance we created for each customer

    public CustomerCounter(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getIntCurrentCustomerAmount(){                                                   // getter for current customer amount used in GUI to represent number in String type
        return currentCustomerAmount;
    }


    public String getMaxCapacity(){                                                             // getter for max capacity used in GUI to represent number in String type
        return "" + maxCapacity;
    }

    /**
     * method prints information in graphic user interface regards venue free spaces
     * @return String message
     */
    public String messegeGui(){
String alarmMessege = "Maximum number of " + maxCapacity +                                      // alarm message notifying that venue is full
                " customers reached, please ask next customer to wait";
String messege = "It is okay to let another customer in";                                       // message notifying that venue is not full and customer might enter venue
if(currentCustomerAmount == 0){                                                                 // message notifying venue is empty
            return "Venue is EMPTY.";
        }
return currentCustomerAmount == maxCapacity ? alarmMessege : messege;                           // ternary operator decides which message should be displayed
    }

    /**
     * method where decision is made before letting another customer in
     * will be invoked when "let person in" button is pressed
     */
    public void customerEnters(){

if(currentCustomerAmount < maxCapacity){                                                        // block executes only if max capacity is not reached
            currentCustomerAmount++;                                                                   // increases amount of customers by one
            System.out.println("One customer let in to the venue." +                                   // prints announcement in to the terminal
                    " TOTAL CUSTOMERS ON VENUE: " + currentCustomerAmount);                            // creates object for each customer and adds it in to ArrayList
            if(currentCustomerAmount == maxCapacity){                                                  // if max capacity reached
                System.out.println("Venue is FULL.");                                                  // prints announcement in to the terminal
            }
        }
    }

    /**
     * method where decision is made when customer left venue
     * will be invoked when "let person out" button is pressed
     */
    public void customerLeaves(){
        if (currentCustomerAmount > 0){                                                                // amount of customers can't be less than zero, so we need to implement that condition
            currentCustomerAmount--;                                                                   // decreases amount of customers by one
            System.out.println("One customer left venue." +                                            // prints announcement in to the terminal
                    " TOTAL CUSTOMERS ON VENUE: " + currentCustomerAmount);
            if(currentCustomerAmount == 0){                                                            // if condition when venue is empty reached
                System.out.println("Venue is EMPTY");                                                  // prints announcement in to the terminal
            }
        }
    }



}
