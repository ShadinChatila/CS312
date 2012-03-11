//class to determine the white pegs

class whitePegs
{
	private int white;
	
	//default constructor
	public whitePegs()
	{
		white = 0;
	}
	
	//method to determine number of correctly placed pegs
	public int correctWhite(char[] secret, char[] user)
	{
		//create temp arrays
		char[] tempS = new char[secret.length];
		char[] tempU = new char[user.length];
		System.arraycopy(secret, 0, tempS, 0, secret.length);
		System.arraycopy(user, 0, tempU, 0, user.length);
		//check if it is not a black peg
		
		for(int i=0; i < tempS.length; i++)
		{
			if(tempS[i] == tempU[i])
			{
				
				tempU[i] = '8';
				tempS[i] = '4';
			}
		}
		
		for(int i=0; i < tempS.length; i++)
		{
			for(int j=0; j < tempU.length; j++)
			{				
				if(tempS[i] == tempU[j])
				{
					white++;
					tempS[i] = '3';
					tempU[j] = '2';
				}
			}	
		}
		return white;
	}
	

	//method to get number of white pegs
	public int getWhite()
	{
		return white;
	}
}