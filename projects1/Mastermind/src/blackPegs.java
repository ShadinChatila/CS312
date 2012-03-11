//class to determine the black pegs
class blackPegs
{
	private int black;
	
	//default constructor
	public blackPegs()
	{
		black = 0;
	}
	
	//method to determine number of correctly placed pegs
	public int correctBlack(char[] secret, char[] user)
	{
		for(int i=0; i < secret.length; i++)
		{
			if(secret[i] == user[i])
			{
				black++;
			}
		}
		return black;
	}
	
	//method to get number of black pegs
	public int getBlack()
	{
		return black;
	}
}