import java.util.*;
import java.io.*;

class readFile 
{
	private int willShow;
	private boolean showSecretCode;
	private int numColors;
	private int numPegs;
	private int numGuesses;
	private String[] colorNames;
	private char[] colorInitials;
	
	public readFile(String s) throws IOException
	{
		File layout = new File(s);
		Scanner sc = new Scanner(layout);
		while(sc.hasNextInt())
		{
			willShow = sc.nextInt();
			sc.nextLine();
			numColors = sc.nextInt();
			sc.nextLine();
			numPegs = sc.nextInt();
			sc.nextLine();
			numGuesses = sc.nextInt();
			sc.nextLine();
		}
		colorNames = new String[numColors];
		for(int i = 0; i < numColors; i++)
		{
			colorNames[i] = sc.next();
			sc.nextLine();
		}
		sc.close();
		if(willShow == 1)
		{
			showSecretCode = true;
		}
		else if (willShow == 0)
		{
			showSecretCode = false;
		}
	}
	
	//Accessor
	public int getNumColors()
	{
		return numColors;
	}
	public boolean getShowSecretCode()
	{
		return showSecretCode;
	}
	public int getNumPegs()
	{
		return numPegs;
	}
	public int getNumGuesses()
	{
		return numGuesses;
	}
	public String getColorNamesString()
	{
		String result = "";
		for(int i = 0; i < colorNames.length; i++)
		{
			if(i == colorNames.length-1)
			{
				result += colorNames[i];
			}
			else
			{
				result += colorNames[i] + " ";
			}
		}
		return result;
	}
	public String[] getColorNamesArray()
	{
		return colorNames;
	}
	public char[] getColorInitialsArray()
	{
		colorInitials = new char[colorNames.length];
		for(int i = 0; i < colorNames.length; i++)
		{
			colorInitials[i] = colorNames[i].charAt(0);
		}
		return colorInitials;
	}
	public String getColorInitialsString()
	{
		String result = "";
		for(int i = 0; i < colorNames.length; i++)
		{
			result += colorNames[i].charAt(0);
		}
		return result;
	}
}