//class to print out the result of black and white pegs
class printBlackAndWhite
{
	private int totalBlack;
	private int totalWhite;
	
	//default constructor
	public printBlackAndWhite()
	{
		totalBlack = 0;
		totalWhite = 0;
	}
	
	//non-default constructor
	public printBlackAndWhite(int black, int white)
	{
		totalBlack = black;
		totalWhite = white;
	}
	
	public String printStringArray(int lengt)
	{
		//define new variables for shorter names
		int tb = totalBlack;
		int tw = totalWhite;
		String[] almost = new String[lengt];
		//create a string buffer to store black and white pegs
		if(tb == 0 && tw == 0)
		{
			return "No pegs";
		}
		int index = 0;
		//append black
		if(tb > 0)
		{
			for(int i = 1; i <= tb; i++)
			{
				almost[index] = "Black ";
				index++;
			}
		}
		//append white
		if(tw > 0)
		{
			for(int i = 1; i <=tw; i++)
			{
				almost[index] = "White ";
				index++;
			}
		}
		//Make the string array into a string
		String result = "";
		for(int l = 0; l < index; l++)
		{
			result += almost[l];
		}
		return result;
	}
}