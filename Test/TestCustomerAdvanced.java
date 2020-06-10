
import static org.junit.Assert.*;
import org.junit.Test;

/*
 * Author: Renata Rand McFadden
 * Unit tests for Customer class
 * Checks that Customer class exists with correct implementation of methods
 */
public class TestCustomerAdvanced {

	@Test
	// Test that constructor correctly updates the attributes and get method returns it:
	//     attribute Id
	public void testConstructorAttributeId() {
		String message = "Id value passed to Customer Constructor does not match one returned by get method";
		int id = 5;
		int time = 10;
		int enter = 6;
		int exit = 8;
		Customer cust = new Customer(id, time, enter, exit); // new instance of Customer
		assertEquals(message, id, cust.getId());  // expect same value as passed to constructor
	}
	
	@Test
	// Test that constructor correctly updates the attributes and get method returns it:
	//     attribute arrival
	public void testConstructorAttributeArrival() {
		String message = "arrival value passed to Customer Constructor does not match one returned by get method";
		int id = 5;
		int time = 10;
		int enter = 6;
		int exit = 8;
		Customer cust = new Customer(id, time, enter, exit); // new instance of Customer
		assertEquals(message, time, cust.getArrival());  // expect same value as passed to constructor
	}
	
	@Test
	// Test that constructor correctly updates the attributes and get method returns it:
	//     attribute enterStop
	public void testConstructorAttributeEnter() {
		String message = "enter value passed to Customer Constructor does not match one returned by get method";
		int id = 5;
		int time = 10;
		int enter = 6;
		int exit = 8;
		Customer cust = new Customer(id, time, enter, exit); // new instance of Customer
		assertEquals(message, enter, cust.getEnter());  // expect same value as passed to constructor
	}
	
	@Test
	// Test that constructor correctly updates the attributes and get method returns it:
	//     attribute exit
	public void testConstructorAttributeExit() {
		String message = "exit value passed to Customer Constructor does not match one returned by get method";
		int id = 5;
		int time = 10;
		int enter = 6;
		int exit = 8;
		Customer cust = new Customer(id, time, enter, exit); // new instance of Customer
		assertEquals(message, exit, cust.getExit());  // expect same value as passed to constructor
	}	 
	
	@Test
	// Test that constructor correctly updates the attributes and get method returns it:
	//     attribute status
	public void testConstructorAttributeStatus() {
		String message = "status value set in Customer Constructor does not match one returned by get method";
		int id = 5;
		int time = 10;
		int enter = 6;
		int exit = 8;
		Customer cust = new Customer(id, time, enter, exit); // new instance of Customer
		assertEquals(message, Customer.CUST_NOT_PROCESSED, cust.getStatus());  // expect status to be set to CUST_NOT_PROCESSED constant
	}
	
	@Test
	// Test that setStatus correctly updates the attributes and get method returns it:
	//     attribute status set to CUST_ENTERED
	public void testConstructorMethodSetStatusValue1() {
		String message = "status value set in setStatus(int) does not match one returned by get method";
		int id = 5;
		int time = 10;
		int enter = 6;
		int exit = 8;
		Customer cust = new Customer(id, time, enter, exit); // new instance of Customer
		cust.setStatus(Customer.CUST_ENTERED);  // set status to allowed value
		assertEquals(message, Customer.CUST_ENTERED, cust.getStatus());  // expect status to be set to value of CUST_ENTERED
	}

	@Test
	// Test that setStatus correctly updates the attributes and get method returns it:
	//     attribute status set to CUST_EXITED
	public void testConstructorMethodSetStatusValue2() {
		String message = "status value set in setStatus(int) does not match one returned by get method";
		int id = 5;
		int time = 10;
		int enter = 6;
		int exit = 8;
		Customer cust = new Customer(id, time, enter, exit); // new instance of Customer
		cust.setStatus(Customer.CUST_EXITED);  // set status to allowed value
		assertEquals(message, Customer.CUST_EXITED, cust.getStatus());  // expect status to be set to value of CUST_EXITED
	}	
	
	@Test
	// test that if id attribute is negative throws IllegalArgumentException
	public void testIdNegativeValue()
	{
		try {
			int id = -3;  // invalid value of id
			int time = 10;
			int enter = 6;
			int exit = 8;
			new Customer(id, time, enter, exit); // new instance of Customer
			fail("Constructor should throw exception for invalid value of id");  // if get here no exception was thrown
		} catch (Exception e) {
            if (e instanceof IllegalArgumentException)
                assertTrue(true); // if here, caught exception
           else
                 fail("Caught exception but it was not IllegalArgumentException as documented");
		}
	}
	@Test
	// test that if id attribute is zero throws IllegalArgumentException
	public void testIdZeroValue()
	{
		try {
			int id = 0;  // invalid value of id
			int time = 10;
			int enter = 6;
			int exit = 8;
			new Customer(id, time, enter, exit); // new instance of Customer
			fail("Constructor should throw exception for invalid value of id");  // if get here no exception was thrown
		} catch (Exception e) {
            if (e instanceof IllegalArgumentException)
                assertTrue(true); // if here, caught exception
           else
                 fail("Caught exception but it was not IllegalArgumentException as documented");
		}
	}	

	@Test
	// test that if arrival attribute is negative throws IllegalArgumentException
	public void testArrivalNegativeValue()
	{
		try {
			int id = 5;  
			int time = -1; // invalid value of arrival attribute
			int enter = 6;
			int exit = 8;
			new Customer(id, time, enter, exit); // new instance of Customer
			fail("Constructor should throw exception for invalid value of arrival");  // if get here no exception was thrown
		} catch (Exception e) {
            if (e instanceof IllegalArgumentException)
                assertTrue(true); // if here, caught exception
           else
                 fail("Caught exception but it was not IllegalArgumentException as documented");
		}
	}
	@Test
	// test that if arrival attribute is zero throws IllegalArgumentException
	public void testArrivalZeroValue()
	{
		try {
			int id = 5;  
			int time = 0;   // invalid value of arrival attribute
			int enter = 6;
			int exit = 8;
			new Customer(id, time, enter, exit); // new instance of Customer
			fail("Constructor should throw exception for invalid value of arrival");  // if get here no exception was thrown
		} catch (Exception e) {
            if (e instanceof IllegalArgumentException)
                assertTrue(true); // if here, caught exception
           else
                 fail("Caught exception but it was not IllegalArgumentException as documented");
		}
	}
	
	@Test
	// test that if enter attribute is negative throws IllegalArgumentException
	public void testEnterNegativeValue()
	{
		try {
			int id = 5;  
			int time = 10;
			int enter = -1;  // invalid value of enter
			int exit = 8;
			new Customer(id, time, enter, exit); // new instance of Customer
			fail("Constructor should throw exception for invalid value of enter");  // if get here no exception was thrown
		} catch (Exception e) {
            if (e instanceof IllegalArgumentException)
                assertTrue(true); // if here, caught exception
           else
                 fail("Caught exception but it was not IllegalArgumentException as documented");
		}
	}
	@Test
	// test that if enter attribute is zero throws IllegalArgumentException
	public void testEnterZeroValue()
	{
		try {
			int id = 5;  
			int time = 10;
			int enter = 0;  // invalid value of enter
			int exit = 8;
			new Customer(id, time, enter, exit); // new instance of Customer
			fail("Constructor should throw exception for invalid value of enter");  // if get here no exception was thrown
		} catch (Exception e) {
            if (e instanceof IllegalArgumentException)
                assertTrue(true); // if here, caught exception
           else
                 fail("Caught exception but it was not IllegalArgumentException as documented");
		}
	}	

	@Test
	// test that if exit attribute is negative throws IllegalArgumentException
	public void testExitNegativeValue()
	{
		try {
			int id = 5;  
			int time = 10;
			int enter = 6;  
			int exit = -1; // invalid value of exit
			new Customer(id, time, enter, exit); // new instance of Customer
			fail("Constructor should throw exception for invalid value of exit");  // if get here no exception was thrown
		} catch (Exception e) {
            if (e instanceof IllegalArgumentException)
                assertTrue(true); // if here, caught exception
           else
                 fail("Caught exception but it was not IllegalArgumentException as documented");
		}
	}
	@Test
	// test that if exit attribute is zero throws IllegalArgumentException
	public void testExitZeroValue()
	{
		try {
			int id = 5;  
			int time = 10;
			int enter = 6;  
			int exit = 0;  // invalid value of exit
			new Customer(id, time, enter, exit); // new instance of Customer
			fail("Constructor should throw exception for invalid value of enter");  // if get here no exception was thrown
		} catch (Exception e) {
            if (e instanceof IllegalArgumentException)
                assertTrue(true); // if here, caught exception
           else
                 fail("Caught exception but it was not IllegalArgumentException as documented");
		}
	}	
	
	@Test
	// test that if status attribute is something other than one of the constants it throws IllegalArgumentException
	public void testStatusInvalidLess()
	{
		try {
			int id = 5;  
			int time = 10;
			int enter = 6;  
			int exit = 8;  // invalid value of exit
			Customer cust = new Customer(id, time, enter, exit); // new instance of Customer
			cust.setStatus(Customer.CUST_NOT_PROCESSED-1);  // less than lowest constant
			fail("Constructor should throw exception for invalid value of enter");  // if get here no exception was thrown
		} catch (Exception e) {
            if (e instanceof IllegalArgumentException)
                assertTrue(true); // if here, caught exception
           else
                 fail("Caught exception but it was not IllegalArgumentException as documented");
		}
	}	
	
	@Test
	// test that if status attribute is something other than one of the constants it throws IllegalArgumentException
	public void testStatusInvalidHigher()
	{
		try {
			int id = 5;  
			int time = 10;
			int enter = 6;  
			int exit = 8;  // invalid value of exit
			Customer cust = new Customer(id, time, enter, exit); // new instance of Customer
			cust.setStatus(Customer.CUST_EXITED+1);  // less than highest constant
			fail("Constructor should throw exception for invalid value of enter");  // if get here no exception was thrown
		} catch (Exception e) {
            if (e instanceof IllegalArgumentException)
                assertTrue(true); // if here, caught exception
           else
                 fail("Caught exception but it was not IllegalArgumentException as documented");
		}
	}	
}
