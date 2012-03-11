import java.util.Scanner;

//Create a class to read the user's input
class inputString
{
	private char[] user;
	private String userS;
	private int lengt;
	
	public inputString(int l)
	{
		lengt = l;
	}
	//Read user input
	//store into buffer
	//works as a non-default constructor
	public void readString()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("What is your next guess?");
		System.out.println("Type in the characters for your guess and press enter.");
		System.out.print("Enter guess: ");
		String s = sc.next();
		userS = s;
		user = new char[s.length()];
		for(int i = 0; i < s.length(); i++)
		{
			user[i] = s.charAt(i);
		}
	}
	
	//returns what the user inputed
	public char[] getInputArray()
	{
		return user;
	}
	public String getInputString()
	{
		return userS;
	}
	
	//check if what the user inputed is a valid case for the game
	public boolean validCase (char[] colorInitials)
	{
		if(user.length != lengt)
		{
			return false;
		}
		for(int i = 0; i < lengt; i++)
		{
			if(user[i] < 'A' || user [i] > 'Z')
			{
				return false;
			}
		}	
		
		int t = 0;
				
		for(int i = 0; i < lengt; i++)
		{
			for(int j = 0; j < colorInitials.length; j++)
			{
				if(user[i] == colorInitials[j])
				{
					t++;
				}
			}
		}
		return (t == lengt);
	}
}