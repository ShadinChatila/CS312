import java.io.IOException;

//Create game class for testing purposes
class Game
{
	private String file;//Mastermind.txt
	private readFile base;
	private RandString r; //generates the random code
	private blackPegs numB; //gives black pegs
	private whitePegs numW; //gives white pegs
	private printBlackAndWhite pbandw; //the string which says how many black and white pegs there are
	private inputString user;//The user's guess
	
	public Game(String nameFile) throws IOException
	{
		file = nameFile;
		base = new readFile(file);
	}
	
	public void buildGame()
	{
		r = new RandString(base.getNumPegs(), base.getColorInitialsArray());
		numB = new blackPegs();
		numW = new whitePegs();
		pbandw = new printBlackAndWhite();
		user = new inputString(base.getNumPegs());
	}
	
	//get a new user input
	public void getNewUser()
	{
		user.readString();
	}
	
	//Access what the user inputed
	public char[] getUserArray()
	{
		return user.getInputArray();
	}
	public String getUserString()
	{
		return user.getInputString();
	}
	
	//test user's input validity
	public boolean userValid()
	{
		return user.validCase(base.getColorInitialsArray());
	}
	
	//get the number of black and white pegs
	public int getNumBlack()
	{
		numB = new blackPegs();
		return numB.correctBlack(r.getSecretCode(), user.getInputArray());
	}
	public int getNumWhite()
	{
		numW = new whitePegs();
		return numW.correctWhite(r.getSecretCode(), user.getInputArray());
	}
	
	//Return the string with the correct amount of "Black" "White" or "No Pegs"
	public String printBlackWhite(int b, int w)
	{
		pbandw = new printBlackAndWhite(b, w);
		return pbandw.printStringArray(base.getNumPegs());
	}
	
	//will show secret code if desired
	public void showSecret()
	{
		if(base.getShowSecretCode())
		{
			System.out.println("The secret code is:" + r.getSecretString());
		}
	}
	//get the secret code
	public String getSecret()
	{
		return r.getSecretString();
	}
	
	//get number of guesses
	public int guesses()
	{
		return base.getNumGuesses();
	}
	//get colors
	public String colors()
	{
		return base.getColorNamesString();
	}
	//get number of pegs
	public int pegs()
	{
		return base.getNumPegs();
	}
	
}