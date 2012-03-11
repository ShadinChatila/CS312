/*
  File: Spiral.java

  Description: Reads a file which has two integer values. The first one (x) will tell
  how big an array should be made and the second (y) will prompt to find it in the array.
  The program returns the 8 adjacent numbers to y and y in the center.
  
  Instructions: http://www.cs.utexas.edu/~mitra/csFall2011/cs312/assgn/assgn2.html

  Student Name: Daniel Monroy

  Course Name: CS 312

  Date Created: October 20th, 2011

  Date Last Modified: October 21st, 2011

*/
import java.io.*;
import java.util.*;
public class Spiral 
{
	//method to make the spiral
	//it takes as an input x which will give the dimensions
	//the output is a 2D array with such dimensions
	public static int[][] makeSpiral(int x)
	{
		//make a new array with dimensions x by x
		int[][] a = new int[x][x];
		//create num that will be inputed in certain spot. starts at top right corner
		int countNum = x*x;
		//make variables to help create spiral
		int hl = 1; //horizontal left
		int vd = 1; //vertical down
		int hr = 1; //horizontal right
		int vu = a.length-2; //vertical up
		//do first row of spiral
		for(int i = 0; i < a[0].length; i++)
		{
			a[0][a[0].length-1-i] = countNum;
			countNum--;
		}
		//create all other lines
		//and do each line until you reach countNum = 1
		while(countNum > 0)
		{
			//vertical down lines
			for(int j = vd; j <= a.length-vd; j++)
			{
				a[j][vd-1] = countNum;
				countNum--;
			}
			//horizontal right lines
			for(int k = hr; k <= a.length-hr; k++)
			{
				a[a.length-hr][k] = countNum;
				countNum--;
			}
			//vertical up lines
			for(int f = vu; f > hl-1; f--)
			{
				a[f][vu+1] = countNum;
				countNum--;
			}
			//horizontal left lines
			for(int i = hl; i < a[0].length-hl; i++)
			{
				a[hl][a[0].length-1-i] = countNum;
				countNum--;
			}
			//change all indicators
			hl++;
			vd++;
			hr++;
			vu--;
		}
		//when this loops finishes the array should be ready
		return a;
		//so the array is returned
	}
	
	//method to find the row and column of num	
	public static int[] findRowAndColumn(int x, int num, int[][] b)
	{ 
		//Create an array to save the row and column
		int[] a = new int[2];
		for(int i = 0; i < x; i++)
		{
			for(int j = 0; j < x; j++)
			{
				if (b[i][j] == num)
				{
					a[0] = i;
					a[1] = j;
				}
			}
		}
		return a;
	}
	
	//method to find the "mini" array
	public static int[][] findArray(int[][] b, int[][] result, int row, int column)
	{
		//set r and c be the previous column and row of the number
		int r = row-1;
		int c = column-1;
		//make the new array equal to the "mini array" of b centered at num
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				//while looping through the new array also loop through big array
				result[i][j] = b[r+i][c+j];
			}
		}
		//return new array
		return result;
	}
	
	//main method
			//here you will read the file and print the desired array
	public static void main(String[] args) throws IOException
	{
		//input the file
		File spiral = new File("spiral.txt");
		//initialize variables to store the numbers in the file
		int x = 1;
		int num = 1;
		Scanner sc = new Scanner(spiral);
		//read the file
		while(sc.hasNextLine())
		{
			//store the numbers in the variables
			x = sc.nextInt();
			sc.nextLine();
			num = sc.nextInt();
		}
		//Close scanner since you won't be reading anything more in the file
		sc.close();
		//turn x into an odd number
		if(x%2 == 0)
			x++;
		//check whether the number is in the range
		if(num < 1 || num > (x*x))
		{
			//if it is not in the range return error
			System.out.print("Number not in Range");
		}
		else
		{
			//create the array with such dimensions using the makeSpiral method
			int[][] b = makeSpiral(x);
			//find where the number num is (coordinates)
			int [] rc = findRowAndColumn(x, num, b);
			int row = rc[0];
			int column = rc[1];
			//Check if the number is in the outer edge
			if(row == 0 || column == 0 || row == x-1 || column == x-1)
			{
				//If it is then return an error
				System.out.println("Number on Outer Edge");
			}
			else
			{
				//create a new array that will hold the values to display
				int [][] result = new int [3][3];
				//use method to find that array
				findArray(b, result, row, column);
				//print out the array
				for(int i = 0; i < 3; i++)
				{
					for(int j = 0; j < 3; j++)
					{
						System.out.print(result[i][j] + " ");
					}
					System.out.println();
				}
			}
		}
	}	
}
