import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestTrainAdvanced {

	//create local variables for streams
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	// runs before each test starts - redirects streams to local variables
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	// runs after each test ends - cleans up streams to defaults
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	    System.setIn(System.in); //reset System.in to its original
	}

	@Test
	// Test that constructor does not fail when called
	public void testConstructor() {
		int stops = 5;
		ArrayList<Customer> list = new ArrayList<Customer>();  // empty list
		Train tr = new Train(stops, list); // new instance of Train
		assertTrue(true);  // if line executed then there was no exception
	}
	
	@Test
	// Test that displayStops() prints current values of madeStops and time
	// Before simulation runs they should be both 0
	public void testDisplayStops() {
		String output = "Train made 0 stops and it took 0 time units to process all customers";
		int stops = 5;
		ArrayList<Customer> list = new ArrayList<Customer>();  // empty list
		Train tr = new Train(stops, list); // new instance of Train
		tr.displayStops();
		String out = outContent.toString().trim();
		assertEquals(output, out);
	}
	
	@Test
	// Test that constructor updates stops and custList attribute correctly
	// As there is no get method for it, we test it indirectly through simulate
	// We create a customer for that stop and if output is as expected, we know attributes were initialized
	public void testConstructorStopsAndList() {
		
		// expected output
		String message1 = "Current Time=5 Current Stop=5";
		String message2 = "Customer enters train: id=1";
		String message3 = "Current Time=6 Current Stop=1";
		String message4 = "Customer exits train: id=1";
		
		boolean found = true;  // flag to check if all outputs there
		
		int stops = 5;  // set stops to some value and make sure that have customer 
		ArrayList<Customer> list = new ArrayList<Customer>();  // empty list
		Customer cust = new Customer(1,1,5,1);  // create instance of customer
		list.add(cust);  // add customer to list
		
		Train tr = new Train(stops, list); // new instance of Train
		tr.simulate();
		String out = outContent.toString().trim();  // capture output
		
		// if any of the messages are not in output, found flag will be false
		if (!out.contains(message1))   found = false;
		else if (!out.contains(message2))   found = false;
		else if (!out.contains(message3))   found = false;	
		else if (!out.contains(message4))   found = false;
		
		assertTrue(found);  // assert if any messages are not there or different
	}
	
	@Test
	// Test that displayStops method uses the attribute values
	// As there is no get method for it, we test it indirectly through simulate
	public void testDisplayStopsAfterSimulate() {
		
		// expected output
		String message = "Train made 2 stops and it took 6 time units to process all customers";

		int stops = 5;  // set stops to some value and make sure that have customer 
		ArrayList<Customer> list = new ArrayList<Customer>();  // empty list
		Customer cust = new Customer(1,1,5,1);  // create instance of customer
		list.add(cust);  // add customer to list
		
		Train tr = new Train(stops, list); // new instance of Train
		tr.simulate();
		tr.displayStops();
		String out = outContent.toString().trim();  // capture output
		
		assertTrue(out.contains(message));
	}

}
