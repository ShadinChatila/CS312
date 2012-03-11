//Create a class in which the computer generates the random string that the player has to guess
class RandString
{
	
	private char[] rand;
	
	//non-default constructor
	public RandString(int l, char[] a)
	{
		rand = new char[l];
		for(int i = 0; i < rand.length; i++)
		{
			int rndInx = (int)(Math.random()*a.length);
			rand[i] = a[rndInx];
		}

	}
	
	//Get the length of the Secret code
	public int getLength()
	{
		return rand.length;
	}
	
	//Make a random array with the colors (already in char[] a)
	public char[] getSecretCode()
	{
		return rand;
	}
	
	public String getSecretString()
	{
		String result = "";
		for(int i = 0; i < rand.length; i++)
		{
			result += rand[i];
		}
		return result;
	}
	
}