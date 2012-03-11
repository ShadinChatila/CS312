import java.util.*;

/**
 * Checks validity of Social Security Number
 * 
 * @author  Daniel Monroy
 */
public class SSN 
{
  public static void main(String[] args)
  {
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter a SSN: ");
	  String str = input.next();
	  System.out.print("The SSN is: " + isTrue(str));
  }
  public static boolean isTrue(String str)
  {
	  if (str.length() != 11)
		  return false;
	  if (str.charAt(3) != '-' || str.charAt(6) != '-')
	  {
		  return false;
	  }
	  
		 
		  for(int i = 0; i <= 2; i++)
		  {
			  if(str.charAt(i) > '9' || str.charAt(i) < '0')
			  {
				  return false;
			  }
		  }
		  for(int i = 4; i <= 5; i++)
		  {
			  if(str.charAt(i) > '9' && str.charAt(i) < '0')
			  {
				  return false;
			  }
		  }
		  for(int i = 7; i <= 10; i++)
		  {
			  if(str.charAt(i) > '9' && str.charAt(i) < '0')
			  {
				  return false;
			  }
		  }
		 return true;
  }
}
