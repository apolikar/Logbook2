package EventCustomerCounter;


public class App {

    public static void main(String[] args){

        CustomerCounter customerCounter = new CustomerCounter(5);
        new Gui(customerCounter);

    }
}