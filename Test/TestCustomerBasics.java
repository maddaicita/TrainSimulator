import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.Test;

/*
 * Author: Renata Rand McFadden
 * Unit tests for Customer class
 * Checks that Customer class exists with correct attributes, constants, constructors, and methods
 */
public class TestCustomerBasics {

	@Test
	// Check that there is a class Customer
	public void testCustomerClassExists() {
	    try {
	        Class.forName("Customer");
	    } catch (ClassNotFoundException e) 
	    {
	        fail("Should have a class called Customer");
	    }
	}
	
	@Test
	// Check that Constructor exists: public Customer(int,int,int,int)
	public void testCustomerConstructorExists()
	{
		boolean found = false;  
		Constructor list[] = Customer.class.getConstructors();  // get all constructors
		for(int i = 0; i < list.length; i++)  // loop through list of Constructors
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("public Customer(int,int,int,int)"))
				found = true;
		}
		if (!found)
			fail("Customer class should have a constructor passing all four int values for attributes");
 	}
	
	@Test
	// Check that Customer has the required attribute: 
	//     private int Customer.id
	public void testAttributeId()
	{
		boolean found = false;  
		Field list[] = Customer.class.getDeclaredFields();  // get all attributes
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("private int Customer.id"))
				found = true;
		}
		if (!found)
			fail("Customer class should have a private id attribute of type integer");
	}
	
	@Test
	// Check that Customer has the required attribute: 
	//     private int Customer.arrival
	public void testAttributeArrival()
	{
		boolean found = false;  
		Field list[] = Customer.class.getDeclaredFields();  // get all attributes
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("private int Customer.arrival"))
				found = true;
		}
		if (!found)
			fail("Customer class should have a private arrival attribute of type integer");
	}
	
	@Test
	// Check that Customer has the required attribute: 
	//     private int Customer.enter
	public void testAttributeEnter()
	{
		boolean found = false;  
		Field list[] = Customer.class.getDeclaredFields();  // get all attributes
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("private int Customer.enter"))
				found = true;
		}
		if (!found)
			fail("Customer class should have a private enter attribute of type integer");
	}
	
	@Test
	// Check that Customer has the required attribute: 
	//     private int Customer.exit
	public void testAttributeExit()
	{
		boolean found = false;  
		Field list[] = Customer.class.getDeclaredFields();  // get all attributes
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("private int Customer.exit"))
				found = true;
		}
		if (!found)
			fail("Customer class should have a private exit attribute of type integer");
	}
	
	@Test
	// Check that Customer has the required attribute: 
	//     private int Customer.status
	public void testAttributeStatus()
	{
		boolean found = false;  
		Field list[] = Customer.class.getDeclaredFields();  // get all attributes
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("private int Customer.status"))
				found = true;
		}
		if (!found)
			fail("Customer class should have a private status attribute of type integer");
	}	

	@Test
	// Check that Customer has constant called  CUST_NOT_PROCESSED and set to 0
	public void testConstantCUST_NOT_PROCESSED()
	{
		boolean found = false;  
		Field list[] = Customer.class.getDeclaredFields();  // get all variables
		for(int i = 0; i < list.length; i++) // loop through list of variables
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("public static final int Customer.CUST_NOT_PROCESSED"))
				found = true;
		}
		if (!found)
			fail("Customer class should have a public constant called CUST_NOT_PROCESSED");
		assertEquals(0,Customer.CUST_NOT_PROCESSED);  // check the constant value is correct
	}
	
	@Test
	// Check that Customer has constant called  CUST_ENTERED and set to 1
	public void testConstantCUST_ENTERED()
	{
		boolean found = false;  
		Field list[] = Customer.class.getDeclaredFields();  // get all variables
		for(int i = 0; i < list.length; i++) // loop through list of variables
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("public static final int Customer.CUST_ENTERED"))
				found = true;
		}
		if (!found)
			fail("Customer class should have a public constant called CUST_ENTERED");
		assertEquals(1,Customer.CUST_ENTERED);  // check the constant value is correct
	}
	
	@Test
	// Check that Customer has constant called  CUST_EXITED and set to 2
	public void testConstantCUST_EXITED()
	{
		boolean found = false;  
		Field list[] = Customer.class.getDeclaredFields();  // get all variables
		for(int i = 0; i < list.length; i++) // loop through list of variables
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("public static final int Customer.CUST_EXITED"))
				found = true;
		}
		if (!found)
			fail("Customer class should have a public constant called CUST_EXITED");
		assertEquals(2,Customer.CUST_EXITED);  // check the constant value is correct
	}
	
	@Test
	// Check that Customer only has the 5 required attributes and 3 constants: 
	public void testAttributeOnlyEight()
	{
		Field list[] = Customer.class.getDeclaredFields();  // get all attributes
		if (list.length > 8)
			fail("Customer class should only have five attributes and three constants defined");
	}	

	@Test
	// Check that Customer has the required methods:
	//    public int Customer.getId()  
	public void testMethodGetId()
	{
		boolean found = false;  
		Method list[] = Customer.class.getDeclaredMethods();
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("public int Customer.getId()"))
				found = true;
		}
		if (!found)
			fail("Customer class should have a public method called getId");
	}
	
	@Test
	// Check that Customer has the required methods:
	//    public int Customer.getEnter()  
	public void testMethodGetEnter()
	{
		boolean found = false;  
		Method list[] = Customer.class.getDeclaredMethods();
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("public int Customer.getEnter()"))
				found = true;
		}
		if (!found)
			fail("Customer class should have a public method called getEnter");
	}
	
	@Test
	// Check that Customer has the required methods:
	//    public int Customer.getExit()  
	public void testMethodGetExit()
	{
		boolean found = false;  
		Method list[] = Customer.class.getDeclaredMethods();
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("public int Customer.getExit()"))
				found = true;
		}
		if (!found)
			fail("Customer class should have a public method called getExit");
	}
	
	@Test
	// Check that Customer has the required methods:
	//    public int Customer.getArrival()  
	public void testMethodGetArrival()
	{
		boolean found = false;  
		Method list[] = Customer.class.getDeclaredMethods();
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("public int Customer.getArrival()"))
				found = true;
		}
		if (!found)
			fail("Customer class should have a public method called getArrival");
	}
	
	@Test
	// Check that Customer has the required methods:
	//    public int Customer.getStatus()  
	public void testMethodGetStatus()
	{
		boolean found = false;  
		Method list[] = Customer.class.getDeclaredMethods();
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("public int Customer.getStatus()"))
				found = true;
		}
		if (!found)
			fail("Customer class should have a public method called getStatus");
	}

	@Test
	// Check that Customer has the required methods:
	//    public int Customer.setStatus(int)  
	public void testMethodSetStatus()
	{
		boolean found = false;  
		Method list[] = Customer.class.getDeclaredMethods();
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("public void Customer.setStatus(int)"))
				found = true;
		}
		if (!found)
			fail("Customer class should have a public method called setStatus with integer parameter");
	}	
	@Test
	// Check that Customer only has the required 6 methods 
	public void testMethodsOnlySix()
	{
		Method list[] = Customer.class.getDeclaredMethods();  // get all methods
		if (list.length > 6)
			fail("Customer class should only have six methods defined");
	}	
}
