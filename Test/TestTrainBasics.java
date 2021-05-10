import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

/*

 * Unit tests for Train class
 * Checks that Train class exists with correct attributes, constructors, and methods
 */
public class TestTrainBasics {

	@Test
	// Check that there is a class Train
	public void testCustomerClassExists() {
	    try {
	        Class.forName("Train");
	    } catch (ClassNotFoundException e) 
	    {
	        fail("Should have a class called Train");
	    }
	}
	
	@Test
	// Check that Constructor exists: public Customer(int,int,int,int)
	public void testTrainConstructorExists()
	{
		boolean found = false;  
		Constructor list[] = Train.class.getConstructors();  // get all constructors
		for(int i = 0; i < list.length; i++)  // loop through list of Constructors
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("public Train(int,java.util.ArrayList)"))
				found = true;
		}
		if (!found)
			fail("Train class should have a constructor with stops and custList values for attributes");
 	}
	
	@Test
	// Check that Train has the required attribute: 
	//     private ArrayList<Customer> Train.custList
	public void testAttributeCustList()
	{
		boolean found = false;  
		Field list[] = Train.class.getDeclaredFields();  // get all attributes
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("private java.util.ArrayList Train.custList"))
				found = true;
		}
		if (!found)
			fail("Train class should have a private custList attribute of type ArrayList<Customer>");
	}
	
	@Test
	// Check that Train has the required attribute: 
	//     private int Customer.stops
	public void testAttributeStops()
	{
		boolean found = false;  
		Field list[] = Train.class.getDeclaredFields();  // get all attributes
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("private int Train.stops"))
				found = true;
		}
		if (!found)
			fail("Train class should have a private stops attribute of type integer");
	}
	
	@Test
	// Check that Train has the required attribute: 
	//     private int Train.madeStops
	public void testAttributeMadeStops()
	{
		boolean found = false;  
		Field list[] = Train.class.getDeclaredFields();  // get all attributes
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("private int Train.madeStops"))
				found = true;
		}
		if (!found)
			fail("Train class should have a private madeStops attribute of type integer");
	}
	
	@Test
	// Check that Train has the required attribute: 
	//     private int Train.currTime
	public void testAttributeCurrTime()
	{
		boolean found = false;  
		Field list[] = Train.class.getDeclaredFields();  // get all attributes
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("private int Train.currTime"))
				found = true;
		}
		if (!found)
			fail("Train class should have a private currTime attribute of type integer");
	}
	
	@Test
	// Check that Train only has the 4 required attributes: 
	public void testAttributeOnlyFour()
	{
		Field list[] = Train.class.getDeclaredFields();  // get all attributes
		if (list.length > 4)
			fail("Train class should only have three attributes");
	}	

	@Test
	// Check that Train has the required methods:
	//    public void Train.simulate()  
	public void testMethodSimulate()
	{
		boolean found = false;  
		Method list[] = Train.class.getDeclaredMethods();
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("public void Train.simulate()"))
				found = true;
		}
		if (!found)
			fail("Train class should have a public method called simulate");
	}
	
	@Test
	// Check that Train has the required methods:
	//    public void Train.displayStops()  
	public void testDisplayStops()
	{
		boolean found = false;  
		Method list[] = Train.class.getDeclaredMethods();
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("public void Train.displayStops()"))
				found = true;
		}
		if (!found)
			fail("Train class should have a public method called displayStops");
	}
	
	@Test
	// Check that Train only has the required 3 methods 
	public void testMethodsOnlySix()
	{
		Method list[] = Train.class.getDeclaredMethods();  // get all methods
		if (list.length > 3)
			fail("Train class should only have three methods defined");
	}	

}
