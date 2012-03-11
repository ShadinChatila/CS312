import java.util.*;
//import java.io.*;

public class Names 
{
	private ArrayList<NameRecord> names = new ArrayList<NameRecord>();
	
	public Names(Scanner fileScanner)
	{
		String line;
		while( fileScanner.hasNextLine() )
		{
		line = fileScanner.nextLine();
		/* create a NameRecord object based on line and add it to the ArrayList of NameRecord objects */
		NameRecord temp = new NameRecord(line);
		names.add(temp);
		}
	}
	
	
	public ArrayList<NameRecord> containsSubstring(String sub)
	{
		ArrayList<NameRecord> result = new ArrayList<NameRecord>();
		ArrayList<Integer> index = new ArrayList<Integer>(); 
		boolean exists = false;
		
		for(int i = 0; i < names.size(); i++)
		{
			boolean temp = names.get(i).getName().toLowerCase().contains(sub.toLowerCase());
			
			if(temp)
			{
				index.add(i);
				exists = true;
			}
		}
		//Check if there exists something with such string
		if(!exists)
			return null;
		
		for(int i = 0; i < index.size(); i++)
		{
			result.add(names.get(index.get(i)));
		}
		return result;
	}
	
	public NameRecord equalName(String exact)
	{		
		for(int i = 0; i < names.size(); i++)
		{
			if(names.get(i).getName().equalsIgnoreCase((exact)))
			{
				return names.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<String> everyDecade()
	{
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<Integer> index = new ArrayList<Integer>();
		
		for(int i = 0; i < names.size(); i++)
		{
			if(names.get(i).rankEveryDecade())
			{
				index.add(i);
			}
		}
		for(int i = 0; i < index.size(); i++)
		{
			result.add(names.get(index.get(i)).getName());
		}
		return result;
	}
	
	public ArrayList<String> oneDecade()
	{
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<Integer> index = new ArrayList<Integer>();
		
		for(int i = 0; i < names.size(); i++)
		{
			if(names.get(i).rankOneDecade())
			{
				index.add(i);
			}
		}
		for(int i = 0; i < index.size(); i++)
		{
			result.add(names.get(index.get(i)).getName());
		}
		return result;
	}
	
	public ArrayList<String> increasePopular()
	{
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<Integer> index = new ArrayList<Integer>();
		
		for(int i = 0; i < names.size(); i++)
		{
			if(names.get(i).morePopular())
			{
				index.add(i);
			}
		}
		for(int i = 0; i < index.size(); i++)
		{
			result.add(names.get(index.get(i)).getName());
		}
		return result;
	}
	
	public ArrayList<String> decreasePopular()
	{
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<Integer> index = new ArrayList<Integer>();
		
		for(int i = 0; i < names.size(); i++)
		{
			if(names.get(i).lessPopular())
			{
				index.add(i);
			}
		}
		for(int i = 0; i < index.size(); i++)
		{
			result.add(names.get(index.get(i)).getName());
		}
		return result;
	}
	
	/*
	 * Own Method:
	 * It will see which names were ranked 1000 on their first decade and then never appeared in the rankings again
	 * Such as: Bartholome 1000 0 0 0 0 0 0 0 0 0 0
	 * It will return an ArrayList of Strings of the names
	 */
	
	public ArrayList<String> perfectThousand()
	{
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<Integer> index = new ArrayList<Integer>();
		
		for(int i = 0; i < names.size(); i++)
		{
			if(names.get(i).perfectThousand())
			{
				index.add(i);
			}
		}
		for(int i = 0; i < index.size(); i++)
		{
			result.add(names.get(index.get(i)).getName());
		}
		return result;
	}
	
	/*
	//Testing the class
	public static void main(String[] args) throws IOException
	{
		File data = new File("names.txt");
		Scanner fileScanner = new Scanner(data);
		Names n = new Names(fileScanner);
		//System.out.println(n.containsSubstring("sam"));
		//System.out.println(n.getNames());
		
	}
	//*/
}