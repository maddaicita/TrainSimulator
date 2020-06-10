

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Simulator {

	public static void main(String[] args){
		Simulator sim = new Simulator();
		ArrayList<Customer> custList = new ArrayList<Customer>();
		int stops = 7;
		sim.getStopsFromUser();

		File file = sim.getInputFile();
		custList = sim.checkFile(stops, file);
		sim.run(stops, custList);
	}

	public void run(int numberStops, ArrayList<Customer> list){

		Train train = new Train(numberStops, list);
		train.simulate();
		train.displayStops();

	}

	public int getStopsFromUser() {

		//Variable to hold the user's selected option
		int numStops = 0;

		//Create a scanner object to read the user's input
		Scanner keyboard = new Scanner(System.in);

		while(true)
		{
            //Prompts user for number of stops
			System.out.print("Enter number of stops the train has on its route (must be greater than 1): ");

			//if it is not number re-prompt until user enter a number
			while (!keyboard.hasNextInt())
			{
				String input = keyboard.next();
				System.out.print("Invalid input, try again.\n ");
				System.out.println("Enter number of stops the train has on its route (must be greater than 1):");
			}
			numStops = keyboard.nextInt();
            //checks for 0 or negatives and re-prompts
			if(numStops < 1) {
				System.out.println("Invalid input, try again.");
			}
			else
				break;
		}

		//returns the valid value of stops
		return numStops;
	}


	public File getInputFile() {

		String filePath="";
		File temp;
		Scanner keyboard = new Scanner(System.in);

		while(true)
		{
            //Prompts user for the input file path
			System.out.print("\nEnter absolute path for data file or for default (C:/train/customer-data.txt) press Enter:");

			if(keyboard.hasNextLine()) {
				filePath=keyboard.nextLine();
			}

			if (filePath.isEmpty()) {
				System.out.println("File not found, try again. ");
				temp = new File("C:/train/customer-data.txt");
			} else
				temp = new File(filePath);

			if(temp.exists())
			{
				return temp;
			}
			else {
				System.out.println("File not found, try again. ");
			}

		}

			}



	public ArrayList<Customer> checkFile(int stops, File file) {

		ArrayList<Customer> list = new ArrayList<Customer>();

		try
		{
			String line = "";
			int counter = 0;

			Scanner fileScanner = new Scanner(file);

			int[] data1 = new int[100];
			int[] data2 = new int[100];
			int[] data3 = new int[100];
			int[] data4 = new int[100];

			while (fileScanner.hasNextLine())
			{
				line = fileScanner.nextLine();
				StringTokenizer token = new StringTokenizer(line, " ");
				data1[counter] = Integer.parseInt(token.nextToken());
				data2[counter] = Integer.parseInt(token.nextToken());
				data3[counter] = Integer.parseInt(token.nextToken());
				data4[counter] = Integer.parseInt(token.nextToken());


				for(int j = 0; j < counter; j++)
				{
					if(data1[j] == data1[counter])
					{
						System.out.println("Data in input file is not correct. Try again.");
						list = null;
						return list;
					}
				}

				counter += 1;
			}

			for(int i = 0; i < counter; i++)
			{
				if(data3[i]==data4[i] || data4[i]> stops || data3[i]> stops)
				{
					System.out.println("Data in input file is not correct. Try again.");
					list=null;
					break;
				}

				list.add(new Customer(data1[i],data2[i],data3[i],data4[i]));
			}

		} catch (Exception e){
			if (e instanceof NumberFormatException)
			{
				System.out.println("Each line must have four integers. Try again.");
			}
			System.out.println("Data in input file is not correct. Try again.");
			list = null;
		}
		return list;
	}
}
