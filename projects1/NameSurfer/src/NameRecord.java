import java.util.*;

public class NameRecord 
{
	private ArrayList<Integer> ranks = new ArrayList<Integer>();
	private String name;
	private int startDecade = 1900;
	
	public NameRecord(String full)
	{
		String[] parsedData = full.split("\\s+");
		name = parsedData[0].toString();
		for(int i = 1; i < parsedData.length; i++)
		{
			ranks.add(Integer.parseInt(parsedData[i]));
		}
	}
	
	public String getName()
	{
		return name;
	}

	public ArrayList<Integer> getAllRanks()
	{
		return ranks;
	}
	
	public int getRank(int decade)
	{
		return ranks.get(decade);
	}
	
	public int bestDecade()
	{
		int best = 9999;
		int decade = 0;
		for(int i = 0; i < ranks.size(); i++)
		{
			if(ranks.get(i) <= best  && ranks.get(i) != 0)
			{
				decade = i;
				best = ranks.get(i);
			}
		}
		
		if(best == 9999)
		{
			return 9999;
		}
		else
		{
				return (startDecade + (decade * 10));
		}
	}
	
	public int amountRankedDecades()
	{
		int amount = 0;
		for(int i = 0; i < ranks.size(); i++)
		{
			if(ranks.get(i) != 0)
			{
				amount++;
			}
		}
		return amount;
	}
	
	public boolean rankEveryDecade()
	{
		int amount = 0;
		for(int i = 0; i < ranks.size(); i++)
		{
			if(ranks.get(i) != 0)
			{
				amount++;
			}
		}
		if(amount == ranks.size())
			return true;
		
		return false;
	}
	
	public boolean rankOneDecade()
	{
		int amount = 0;
		for(int i = 0; i < ranks.size(); i++)
		{
			if(ranks.get(i) != 0)
			{
				amount++;
			}
		}
		if(amount == 1)
			return true;
		
		return false;
	}
	
	public boolean morePopular()
	{
		int zeroCount = 0;
		for(int i = 0; i < ranks.size(); i++)
		{
			if(ranks.get(i) == 0)
			{
				zeroCount++;
			}
		}
		//it was ranked 0 more than once
		if(zeroCount > 1)
			return false;
		
		int firstNonZero = -1;
		for(int i = 0; i < ranks.size(); i++)
		{
			if(ranks.get(i) != 0)
			{
				firstNonZero = i;
				break;
			}
		}
		//it was always ranked 0
		if(firstNonZero == -1)
			return false;
		
		for(int i = firstNonZero; i < ranks.size()-1; i++)
		{
			
			//meaning it will return back to zero after having found a non zero rank
			if(ranks.get(i) == 0 ||ranks.get(ranks.size()-1) == 0)
			{
				return false;
			}
			
			if(ranks.get(i) <= ranks.get(i + 1))
			{
				return false;
			}
		}
		
		return true;
	}
	
	public boolean lessPopular()
	{
		//make a new array list to modify the ranks so that 0 will be replaced by 999
		ArrayList<Integer> temp = new ArrayList<Integer>(getAllRanks());
		if(temp.lastIndexOf(0) != -1)
		{
			temp.set(temp.lastIndexOf(0), 1000);
		}
		
		int zeroCount = 0;
		for(int i = 0; i < ranks.size(); i++)
		{
			if(ranks.get(i) == 0)
			{
				zeroCount++;
			}
		}
		
		//it was ranked 0 more than once
		if(zeroCount > 1)
			return false;
		
		for(int i = 0; i < ranks.size()-1; i++)
		{			
			//meaning it will return back to zero after having found a non zero rank
			if(temp.get(i) >= temp.get(i + 1))
			{
				return false;
			}
		}
		
		return true;
	}
	
	/*
	 * Own Method:
	 * It will see which names were ranked 1000 on their first decade and then never appeared in the rankings again
	 * Such as: Bartholome 1000 0 0 0 0 0 0 0 0 0 0
	 * It will return an ArrayList of Strings of the names
	 */
	
	public boolean perfectThousand() 
	{
		for(int i = 1; i < ranks.size(); i++)
		{
			if(ranks.get(i) != 0)
				return false;
		}
		if(ranks.get(0) != 1000)
			return false;
		return true;
	}
	
	//Test
	public void Test() 
	{	
		System.out.println(getName());
		System.out.println(getAllRanks());
		int sum = getRank(0) + getRank(3);
		System.out.println(sum);
		System.out.println(bestDecade());
		System.out.println(amountRankedDecades());
		System.out.println(rankEveryDecade());
		System.out.println(rankOneDecade());
		System.out.println(lessPopular());
		System.out.println(perfectThousand());
		System.out.println(morePopular());
	}
	
}
