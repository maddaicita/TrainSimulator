import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

public class TestSimulatorAdvanced {

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
	public void testMain() {
		//SimulatorOld.main(null);
		//MyClass.main(new String[] {"arg1", "arg2", "arg3"});
	}
	
	@Test
	// Check that get correct prompt from method getStopsFromUser   
	public  void testgetStopsFromUserPrompt()
	{
		String promptMessage = "Enter number of stops the train has on its route (must be greater than 1):";
	    ByteArrayInputStream in = new ByteArrayInputStream("7".getBytes());
	    System.setIn(in);

		Simulator sim = new Simulator();  // new instance of Simulator
		sim.getStopsFromUser();  // call method to get number of stops
		String prompt = outContent.toString().trim();
		assertEquals(promptMessage, prompt);

	}
	
	@Test
	// Test that 0 is caught as invalid input and user gets re-prompted
	public  void testgetStopsFromUserPromptLoop()
	{
		String message = "Invalid input, try again";

	    ByteArrayInputStream in = new ByteArrayInputStream("0\n7".getBytes());  // input 0 on first prompt and 7 on next
	    System.setIn(in);

		Simulator sim = new Simulator();  // new instance of Simulator
		sim.getStopsFromUser();  // call method to get number of stops
		String prompt = outContent.toString().trim();

		assertTrue(prompt.contains(message));  // check that output has the error message
	}
	
	@Test
	// Test that non-integer is caught as invalid input and user gets re-prompted
	public  void testgetStopsFromUserPromptLoop2()
	{
		String message = "Invalid input, try again";

	    ByteArrayInputStream in = new ByteArrayInputStream("n\n7".getBytes());  // input n on first prompt and 7 on next
	    System.setIn(in);

		Simulator sim = new Simulator();  // new instance of Simulator
		sim.getStopsFromUser();  // call method to get number of stops
		String prompt = outContent.toString().trim();

		assertTrue(prompt.contains(message));  // check that output has the error message
	}
	
	
	@Test
	// Test that there are two prompts on invalid input
	public  void testgetStopsFromUserPromptDouble()
	{
		String message = "Enter number of stops the train has on its route \\(must be greater than 1\\):";

	    ByteArrayInputStream in = new ByteArrayInputStream("n\n7".getBytes());  // input n on first prompt and 7 on next
	    System.setIn(in);

		Simulator sim = new Simulator();  // new instance of Simulator
		sim.getStopsFromUser();  // call method to get number of stops
		String output = outContent.toString();
 
		int count = output.split(message, -1).length-1;  // count number of occurrences of prompt in output
	    assertEquals(2, count); // expect two prompt messages
	}

	@Test
	// Test that if user presses enter and file not exists, he gets error message
	// MUST NOT HAVE customer file at C:/train/customer-data.txt
	// MUST have src/customer file
	public  void testgetInputFileDefaultFail()
	{
		String message = "File not found, try again.";

	    ByteArrayInputStream in = new ByteArrayInputStream("\nsrc/customer".getBytes());  // input enter
	    System.setIn(in);

		Simulator sim = new Simulator();  // new instance of Simulator
		sim.getInputFile();  // call method to get file name
		String output = outContent.toString();
 
		assertTrue(output.contains(message));  // check that output has the error message
	}
	
	@Test
	// Test that there is correct prompt for file and enter expects that file
	// MUST HAVE customer file at C:/train/customer-data.txt 
	// If file does not exists, the test will fail with java.util.NoSuchElementException: No line found
	public  void testgetInputFilePrompt()
	{
		String message = "Enter absolute path for data file or for default (C:/train/customer-data.txt) press Enter:";

	    ByteArrayInputStream in = new ByteArrayInputStream("\n".getBytes());  // input enter
	    System.setIn(in);

		Simulator sim = new Simulator();  // new instance of Simulator
		sim.getInputFile();  // call method to get file name
		String output = outContent.toString();
 
		assertTrue(output.contains(message));  // check that output has the correct prompt
	}
	
	@Test
	// Test that if user presses enter and file not exists, he gets error message
	// MUST have src/customer file
	public  void testgetInputFileNotExist()
	{
		String message = "File not found, try again.";

	    ByteArrayInputStream in = new ByteArrayInputStream("blahblah\nsrc/customer".getBytes());  // input enter
	    System.setIn(in);

		Simulator sim = new Simulator();  // new instance of Simulator
		sim.getInputFile();  // call method to get file name
		String output = outContent.toString();
 
		assertTrue(output.contains(message));  // check that output has the error message
	}
	
	@Test
	// Test that if user presses enter and file not exists, there will be multiple prompts
	// MUST have src/customer file
	public  void testgetInputFilePromptLoop()
	{
		String message = "Enter absolute path for data file or for default \\(C:\\/train\\/customer-data.txt\\) press Enter:";

	    ByteArrayInputStream in = new ByteArrayInputStream("blahblah\nblah\nsrc/customer".getBytes());  // input enter
	    System.setIn(in);

		Simulator sim = new Simulator();  // new instance of Simulator
		sim.getInputFile();  // call method to get file name
		String output = outContent.toString();
 
		int count = output.split(message, -1).length-1;  // count number of occurrences of prompt in output
	    assertEquals(3, count); // expect three prompt messages
	}
	
	@Test
	// Test that for id < 0, get error message 
	// MUST HAVE customer files at src/customer  and src/bad-id
	// If file does not exists, the test will fail 
	public  void testCheckFileIdInvalid()
	{
		String message = "Data in input file is not correct. Try again.";

	    ByteArrayInputStream in = new ByteArrayInputStream("src/bad-id\nsrc/customer".getBytes());  // input enter
	    System.setIn(in);

		Simulator sim = new Simulator();  // new instance of Simulator
		File file = sim.getInputFile();  // call method to get file name
		ArrayList<Customer> list = sim.checkFile(7,file);
		String output = outContent.toString();
 
		assertTrue(output.contains(message));  // passes if message is in output
		assertTrue("Expected list==null",list==null);
	}

	@Test
	// Test that for id non-integer gets error message 
	// MUST HAVE customer files at src/customer  and src/bad-id2
	// If file does not exists, the test will fail 
	public  void testCheckFileIdInvalid2()
	{
		String message = "Each line must have four integers. Try again.";

	    ByteArrayInputStream in = new ByteArrayInputStream("src/bad-id2\nsrc/customer".getBytes());  // input enter
	    System.setIn(in);

		Simulator sim = new Simulator();  // new instance of Simulator
		File file = sim.getInputFile();  // call method to get file name
		ArrayList<Customer> list = sim.checkFile(7,file);
		String output = outContent.toString();
 
		assertTrue(output.contains(message));  // passes if message is in output
		assertTrue("Expected list==null",list==null);
	}
	
	@Test
	// Test that for enter < 1, get error message 
	// MUST HAVE customer files at src/customer  and src/bad-enter
	// If file does not exists, the test will fail 
	public  void testCheckFileEnterInvalid()
	{
		String message = "Data in input file is not correct. Try again.";

	    ByteArrayInputStream in = new ByteArrayInputStream("src/bad-enter\nsrc/customer".getBytes());  // input enter
	    System.setIn(in);

		Simulator sim = new Simulator();  // new instance of Simulator
		File file = sim.getInputFile();  // call method to get file name
		ArrayList<Customer> list = sim.checkFile(7,file);
		String output = outContent.toString();
 
		assertTrue(output.contains(message));  // passes if message is in output
		assertTrue("Expected list==null",list==null);
	}

	@Test
	// Test that for enter non-integer gets error message 
	// MUST HAVE customer files at src/customer  and src/bad-enter2
	// If file does not exists, the test will fail 
	public  void testCheckFileEnterInvalid2()
	{
		String message = "Each line must have four integers. Try again.";

	    ByteArrayInputStream in = new ByteArrayInputStream("src/bad-enter2\nsrc/customer".getBytes());  // input enter
	    System.setIn(in);

		Simulator sim = new Simulator();  // new instance of Simulator
		File file = sim.getInputFile();  // call method to get file name
		ArrayList<Customer> list = sim.checkFile(7,file);
		String output = outContent.toString();
 
		assertTrue(output.contains(message));  // passes if message is in output
		assertTrue("Expected list==null",list==null);
	}
	
	@Test
	// Test that for enter > stops, get error message 
	// MUST HAVE customer files at src/customer  and src/bad-enter3
	// If file does not exists, the test will fail 
	public  void testCheckFileEnterInvalid3()
	{
		String message = "Data in input file is not correct. Try again.";

	    ByteArrayInputStream in = new ByteArrayInputStream("src/bad-enter3\nsrc/customer".getBytes());  // input enter
	    System.setIn(in);

		Simulator sim = new Simulator();  // new instance of Simulator
		File file = sim.getInputFile();  // call method to get file name
		ArrayList<Customer> list = sim.checkFile(7,file);
		String output = outContent.toString();
 
		assertTrue(output.contains(message));  // passes if message is in output
		assertTrue("Expected list==null",list==null);
	}

	@Test
	// Test that for exit < 1, get error message 
	// MUST HAVE customer files at src/customer  and src/bad-exit
	// If file does not exists, the test will fail 
	public  void testCheckFileExitInvalid()
	{
		String message = "Data in input file is not correct. Try again.";

	    ByteArrayInputStream in = new ByteArrayInputStream("src/bad-exit\nsrc/customer".getBytes());  // input enter
	    System.setIn(in);

		Simulator sim = new Simulator();  // new instance of Simulator
		File file = sim.getInputFile();  // call method to get file name
		ArrayList<Customer> list = sim.checkFile(7,file);
		String output = outContent.toString();
 
		assertTrue(output.contains(message));  // passes if message is in output
		assertTrue("Expected list==null",list==null);
	}

	@Test
	// Test that for exit non-integer gets error message 
	// MUST HAVE customer files at src/customer  and src/bad-exit2
	// If file does not exists, the test will fail 
	public  void testCheckFileExitInvalid2()
	{
		String message = "Each line must have four integers. Try again.";

	    ByteArrayInputStream in = new ByteArrayInputStream("src/bad-exit2\nsrc/customer".getBytes());  // input enter
	    System.setIn(in);

		Simulator sim = new Simulator();  // new instance of Simulator
		File file = sim.getInputFile();  // call method to get file name
		ArrayList<Customer> list = sim.checkFile(7,file);
		String output = outContent.toString();
 
		assertTrue(output.contains(message));  // passes if message is in output
		assertTrue("Expected list==null",list==null);
	}
	
	@Test
	// Test that for exit > stops, get error message 
	// MUST HAVE customer files at src/customer  and src/bad-exit3
	// If file does not exists, the test will fail 
	public  void testCheckFileExitInvalid3()
	{
		String message = "Data in input file is not correct. Try again.";

	    ByteArrayInputStream in = new ByteArrayInputStream("src/bad-exit3\nsrc/customer".getBytes());  // input enter
	    System.setIn(in);

		Simulator sim = new Simulator();  // new instance of Simulator
		File file = sim.getInputFile();  // call method to get file name
		ArrayList<Customer> list = sim.checkFile(7,file);
		String output = outContent.toString();
 
		assertTrue(output.contains(message));  // passes if message is in output
		assertTrue("Expected list==null",list==null);
	}
	
	@Test
	// Test that for duplicate id, get error message 
	// MUST HAVE customer files at src/customer  and src/bad-dup-id
	// If file does not exists, the test will fail 
	public  void testCheckFileDupId()
	{
		String message = "Data in input file is not correct. Try again.";

	    ByteArrayInputStream in = new ByteArrayInputStream("src/bad-dup-id\nsrc/customer".getBytes());  // input enter
	    System.setIn(in);

		Simulator sim = new Simulator();  // new instance of Simulator
		File file = sim.getInputFile();  // call method to get file name
		ArrayList<Customer> list = sim.checkFile(7,file);
		String output = outContent.toString();
 
		assertTrue(output.contains(message));  // passes if message is in output
		assertTrue("Expected list==null",list==null);
	}

	@Test
	// Test that for enter==exit, get error message 
	// MUST HAVE customer files at src/customer  and src/bad-enter-exit
	// If file does not exists, the test will fail 
	public  void testCheckFileEnterExit()
	{
		String message = "Data in input file is not correct. Try again.";

	    ByteArrayInputStream in = new ByteArrayInputStream("src/bad-enter-exit\nsrc/customer".getBytes());  // input enter
	    System.setIn(in);

		Simulator sim = new Simulator();  // new instance of Simulator
		File file = sim.getInputFile();  // call method to get file name
		ArrayList<Customer> list = sim.checkFile(7,file);
		String output = outContent.toString();
 
		assertTrue(output.contains(message));  // passes if message is in output
		assertTrue("Expected list==null",list==null);
	}
	
	@Test
	// Test that for time < 1, get error message 
	// MUST HAVE customer files at src/customer  and src/bad-time
	// If file does not exists, the test will fail 
	public  void testCheckFileTimeInvalid()
	{
		String message = "Data in input file is not correct. Try again.";

	    ByteArrayInputStream in = new ByteArrayInputStream("src/bad-time\nsrc/customer".getBytes());  // input enter
	    System.setIn(in);

		Simulator sim = new Simulator();  // new instance of Simulator
		File file = sim.getInputFile();  // call method to get file name
		ArrayList<Customer> list = sim.checkFile(7,file);
		String output = outContent.toString();
 
		assertTrue(output.contains(message));  // passes if message is in output
		assertTrue("Expected list==null",list==null);
	}

	@Test
	// Test that for time non-integer gets error message 
	// MUST HAVE customer files at src/customer  and src/bad-time2
	// If file does not exists, the test will fail 
	public  void testCheckFileTimeInvalid2()
	{
		String message = "Each line must have four integers. Try again.";

	    ByteArrayInputStream in = new ByteArrayInputStream("src/bad-time2\nsrc/customer".getBytes());  // input enter
	    System.setIn(in);

		Simulator sim = new Simulator();  // new instance of Simulator
		File file = sim.getInputFile();  // call method to get file name
		ArrayList<Customer> list = sim.checkFile(7,file);
		String output = outContent.toString();
 
		assertTrue(output.contains(message));  // passes if message is in output
		assertTrue("Expected list==null",list==null);
	}
	
	@Test
	// Test that get correct customer list 
	// MUST HAVE customer files at src/customer  
	// If file does not exists, the test will fail 
	public  void testCheckFileCustomerList()
	{
		boolean found = true;
	    ByteArrayInputStream in = new ByteArrayInputStream("src/customer".getBytes());  // input enter
	    System.setIn(in);

	    Customer c1 = new Customer(1, 1, 1, 2);
	    Customer c2 = new Customer(2, 2, 1, 3);
	    
		Simulator sim = new Simulator();  // new instance of Simulator
		File file = sim.getInputFile();  // call method to get file name
		ArrayList<Customer> list = sim.checkFile(7,file);
		
		if (list.get(0).getId() != c1.getId() || list.get(0).getArrival() != c1.getArrival()
				|| list.get(0).getEnter() != c1.getEnter() || list.get(0).getExit() != c1.getExit())   
			found = false;
		if (list.get(1).getId() != c2.getId() || list.get(1).getArrival() != c2.getArrival()
				|| list.get(1).getEnter() != c2.getEnter() || list.get(1).getExit() != c2.getExit())   
			found = false;
 
		assertTrue("Expected list with 2 customers", found);  // passes if message is in output
	}
		
}
