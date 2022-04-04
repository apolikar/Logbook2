package EventCustomerCounter;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class AppTest {


    @Test public void testCustomerEnters() {

        CustomerCounter customerCounter = new CustomerCounter(5);

        customerCounter.customerEnters();

        int actual = customerCounter.getIntCurrentCustomerAmount();

        assertEquals(actual, 1);
    }

    @Test public void testCustomerLeaves() {

        CustomerCounter customerCounter = new CustomerCounter(5);

        customerCounter.customerEnters();
        customerCounter.customerEnters();
        customerCounter.customerEnters();

        customerCounter.customerLeaves();

        int actual = customerCounter.getIntCurrentCustomerAmount();

        assertEquals(actual, 2);
    }

    @Test public void testOverLimit() {

        CustomerCounter customerCounter = new CustomerCounter(2);

        customerCounter.customerEnters();
        customerCounter.customerEnters();
        customerCounter.customerEnters();

        int actual = customerCounter.getIntCurrentCustomerAmount();

        assertEquals(actual, 2);
    }

    @Test public void belowZero() {

        CustomerCounter customerCounter = new CustomerCounter(5);

        customerCounter.customerEnters();

        customerCounter.customerLeaves();
        customerCounter.customerLeaves();
        customerCounter.customerLeaves();

        int actual = customerCounter.getIntCurrentCustomerAmount();


        assertEquals(actual, 0);
    }



}