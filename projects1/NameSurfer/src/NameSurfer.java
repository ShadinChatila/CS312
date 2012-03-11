/*  
  File: NameSurfer.java  

  Description: Searches a database of names and the user is able to manage them accordingly such as:
  	Finding information about the name's rankings
  	Finding the most popular and the least popular names
  	And much more

  Student Name: Daniel Monroy

  Student UT EID: dm35729

  Course Name: CS 312

  Unique Number: 52271

  Date Created: Nov. 11, 2011

  Date Last Modified: Nov. 19, 2011

  Modify: change the variable startDecade in NameSurfer and NameRecord class
*/

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class NameSurfer {

	// constants for menu choices
	private static int startDecade = 1900;
	public static final int SEARCH = 1;
	public static final int ONE_NAME = 2;
	public static final int APPEAR_ONCE = 3;
	public static final int APPEAR_ALWAYS = 4;
	public static final int MORE_POPULAR = 5;
	public static final int LESS_POPULAR = 6;
	public static final int PERFECT_THOUSAND = 7;
	public static final int QUIT = 8;
	
	// main method. Driver for the whole program
	public static void main(String[] args) {
		/*
		//Testing NameRecord Class
		//NameRecord test = new NameRecord("Sam 100 150 200 202 250 300 350 400 444 444 0");
		//NameRecord test = new NameRecord("Hello 100 150 200 202 250 300 350 400 444 464 3333");
		//NameRecord test = new NameRecord("John 0 0 200 202 250 300 350 400 444 499 0");
		//NameRecord test = new NameRecord("TestingNeim 100 0 200 202 250 300 350 400 444 484 0");
		//NameRecord test = new NameRecord("Mary 0 0 0 0 0 0 0 449 0 0 0 1");
		//NameRecord test = new NameRecord("Bartholome 1000 0 0 0 0 0 0 0 0 0 0");
		//NameRecord test = new NameRecord("Bartholomeu 0 0 1000 0 0 0 0 0 0 0 0 0");
		//NameRecord test = new NameRecord("Bartholomei 1000 0 0 0 0 0 0 0 0 0 1000");
		//NameRecord test = new NameRecord("Ellis 191 209 225 279 308 365 516 679 771 956 786");
		NameRecord test = new NameRecord("Eduardo 592 585 538 433 430 349 301 226 194 121 116");
	    test.Test();
	    //*/
	    
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
		    System.out.println("Unable to set look at feel to local settings. " +
		    		"Continuing with default Java look and feel.");
		}
	    try {
		    System.out.println("Opening GUI to choose file with names data.");
	        Scanner fileScanner = new Scanner( getFile() );
			Names n = new Names(fileScanner);
			int choice;
			Scanner keyboard = new Scanner(System.in);
			fileScanner.close();
			do {
				showMenu();
				choice = getChoice(keyboard);
				if( choice == SEARCH)
					search(n, keyboard);
				else if( choice == ONE_NAME )
					oneName(n, keyboard);
				else if( choice == APPEAR_ONCE )
					appearOnce(n);
				else if( choice == APPEAR_ALWAYS )
					appearAlways(n);
				else if( choice == MORE_POPULAR)
					morePopular(n);
				else if( choice == LESS_POPULAR)
					lessPopular(n);
				else if( choice == PERFECT_THOUSAND)
					perfectThousand(n);
				else
					System.out.println("\n\nGoodbye.");

			} while( choice != QUIT);
		}
		catch(FileNotFoundException e) {
			System.out.println("Problem reading the data file. Exiting the program." + e);
		}
	    
	    
	}
	
	private static void perfectThousand(Names n)
	{
		ArrayList<String> thouNames = n.perfectThousand();
		System.out.println(thouNames.size() + " names are ranked 1000 in their first decade and then left the ranks.");
		for(int i = 0; i < thouNames.size(); i++)
		{
			System.out.println(thouNames.get(i));
		}
	}
	
	private static void lessPopular(Names n) 
	{
		ArrayList<String> popularNames = n.decreasePopular();
		System.out.println(popularNames.size() + " names are less popular in every decade.");
		for(int i = 0; i < popularNames.size(); i++)
		{
			System.out.println(popularNames.get(i));
		}
	}
	
	private static void morePopular(Names n) 
	{
		ArrayList<String> popularNames = n.increasePopular();
		System.out.println(popularNames.size() + " names are more popular in every decade.");
		for(int i = 0; i < popularNames.size(); i++)
		{
			System.out.println(popularNames.get(i));
		}
	}

	// method that shows names that have appeared in ever decade
	// pre: n != null
	// post: print out names that have appeared in ever decade
	private static void appearAlways(Names n) 
	{
		ArrayList<String> everyNames = n.everyDecade();
		System.out.println(everyNames.size() + " names appear in every decade. The names are:");
		for(int i = 0; i < everyNames.size(); i++)
		{
			System.out.println(everyNames.get(i));
		}
	}

	// method that shows names that have appeared in only one decade
	// pre: n != null
	// post: print out names that have appeared in only one decade
	private static void appearOnce(Names n) 
	{
		ArrayList<String> oneNames = n.oneDecade();
		System.out.println(oneNames.size() + " names appear in exactly one decade. The names are:");
		for(int i = 0; i < oneNames.size(); i++)
		{
			System.out.println(oneNames.get(i));
		}
	}

	// method that shows data for one name, or states that name has never been ranked
	// pre: n != null, keyboard != null and is connected to System.in
	// post: print out the data for n or a message that n has never been in the top 1000 for any decade
	private static void oneName(Names n, Scanner keyboard) 
	{
		System.out.print("Enter a name: ");
		String exact = keyboard.next();
		System.out.println();
		NameRecord result = n.equalName(exact);
		if(result == null)
		{
			System.out.println(exact + " does not appear in any decade.");
		}
		else
		{
			String noComma = result.getAllRanks().toString().replaceAll(",", "");
			String noBraket = noComma.replace("[", "");
			String willPrint = noBraket.replace("]", "");
			System.out.println(exact + ": " + willPrint);
			for(int i = 0; i < result.getAllRanks().size(); i++)
			{
				int decade = startDecade + (i *10);
				System.out.println(decade + ": " + result.getRank(i));
			}
		}
		
	}

	// method that shows all names that contain a substring from the user
	// and the decade they were most popular in
	// pre: n != null, keyboard != null and is connected to System.in
	// post: show the correct data		
	private static void search(Names n, Scanner keyboard) 
	{
		System.out.print("Enter a partial name: ");
		String sub = keyboard.next();
		System.out.println();
		ArrayList<NameRecord> result = n.containsSubstring(sub);
		if(result == null)
		{
			System.out.println(sub + " is not a part of any name.");
		}
		else
		{
			System.out.println("There are " + result.size() + " matches for " + sub + ".");
			System.out.println();
			System.out.println("The matches with their highest ranking decade are:");
			for(int i = 0; i < result.size(); i++)
			{
				String willPrint = result.get(i).getName() + " " + result.get(i).bestDecade();
				System.out.println(willPrint);
			}
		}
		
	}

	// get choice from the user
	// keyboard != null and is connected to System.in
	// return an int that is >= SEARCH and <= QUIT
	private static int getChoice(Scanner keyboard) 
	{
		int choice = getInt(keyboard, "Enter choice: ");
		keyboard.nextLine();
		while( choice < SEARCH || choice > QUIT)
		{
			System.out.println("\n" + choice + " is not a valid choice");
			choice = getInt(keyboard, "Enter choice: ");
			keyboard.nextLine();
		}
		return choice;
	}
	
	// ensure an int is entered from the keyboard
	// pre: s != null and is connected to System.in
    private static int getInt(Scanner s, String prompt) 
    {
        System.out.print(prompt);
        while( !s.hasNextInt() )
        {
            s.next();
            System.out.println("That was not an int.");
            System.out.print(prompt);
        }
        return s.nextInt();
    }

    // show the user the menu
	private static void showMenu() 
	{
		System.out.println("\nOptions:");
		System.out.println("Enter " + SEARCH + " to search for names.");
		System.out.println("Enter " + ONE_NAME + " to display data for one name.");
		System.out.println("Enter " + APPEAR_ONCE+ " to display all names that appear in only one decade.");
		System.out.println("Enter " + APPEAR_ALWAYS + " to display all names that appear in all decades.");
		System.out.println("Enter " + MORE_POPULAR + " to display that are more popular in every decade.");
		System.out.println("Enter " + LESS_POPULAR + " to display all names that are less popular in every decade.");
		System.out.println("Enter " + PERFECT_THOUSAND + " to display all names that were ranked 1000 in their " +
				"first decade and then never appeared again");
		System.out.println("Enter " + QUIT + " to quit.\n");
	}

	/** Method to choose a file using a traditional window.
     * @return the file chosen by the user. Returns null if no file picked.
     */ 
    public static File getFile() 
    {
        // create a GUI window to pick the text to evaluate
        JFileChooser chooser = new JFileChooser(".");
        chooser.setDialogTitle("Select File With Baby Names Data.");
        int retval = chooser.showOpenDialog(null);
        File f =null;
        chooser.grabFocus();
        if (retval == JFileChooser.APPROVE_OPTION)
           f = chooser.getSelectedFile();
        return f;
    }
    
    

}