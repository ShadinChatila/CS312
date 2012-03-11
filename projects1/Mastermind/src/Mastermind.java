/*
  File: Mastermind.java

  Description: Mastermind board game. It reads the parameters for the game from the file Mastermind.txt
  
  Implements classes: blackPegs.java; Game.java; inputString.java; printBlackAndWhite.java; RandString.java
  readFile.java; whitePegs.java

  Student Name: Daniel Monroy

  Student UT EID: dm35729

  Course Name: CS 312

  Date Created: Nov. 4, 2011

  Date Last Modified: Nov. 9, 2011

*/

import java.io.*;
import java.util.*;
public class Mastermind
{
	//Method with the instructions
	public static void instructions(int pegs, String colors, int guesses)
	{
		System.out.println("Welcome to Mastermind.");
		System.out.println();
		System.out.println("This is a text version of the classic board game Mastermind.");
		System.out.println("The computer will think of a secret code.");
		System.out.println("The code consists of " + pegs + " colored pegs.");
		System.out.println("The pegs may be one of the following colors: " + colors);
		System.out.println("A color may appear more than once in the code.");
		System.out.println();
		System.out.println("You try to guess what colored pegs are in the code and what order they are in");
		System.out.println("After making a guess the result will be displayed.");
		System.out.println("A result consists of a black peg for each peg you have exactly correct (color and position) in your guess.");
		System.out.println("For each peg in the guess that is the correct color, but is out of position, you get a white peg.");
		System.out.println();
		System.out.println("Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.");
		System.out.println("When entering guesses you only need to enter the first character of the color as a capital letter.");
		System.out.println();
		System.out.println("You have " + guesses + " guesses to get the answer or you lose the game.");
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException
	{
		boolean willRepeat = true;
		String repeat;
		Game one = new Game("Mastermind.txt");
		//print the instructions
		instructions(one.pegs(), one.colors(), one.guesses());
		while(willRepeat)
		{
		
			//build a new game
			one.buildGame();
		
			//Start the game
		
			int guesses = one.guesses();
			String [] board = new String[guesses];
		
			//fill the array with 4 dots
			for(int i = 0; i < guesses; i++)
			{
				board[i] = "....";
			}
			//keep track of where you are keeping the guesses
			int index = 0;
			System.out.println("Generating secret code ....");
			System.out.println();
			while(guesses > 0)
			{
				if(guesses == one.guesses())
				{
					System.out.println("You have " + guesses + " guesses left");
					System.out.println();
				}
				one.showSecret();
				System.out.println();
				one.getNewUser();
				boolean valid = one.userValid();
				while(!valid)
				{
					one.getNewUser();
					valid = one.userValid();
				}
				int black = one.getNumBlack();
				int white = one.getNumWhite();
				String bw = one.printBlackWhite(black, white);
				board[index] = one.getUserString() + " Result: " + bw;
				index++;
				System.out.println();
				System.out.println(".... Secret Code");
				//print the array
				for(int i = 0; i < one.guesses(); i++)
				{
					System.out.println(board[i]);
				}
				guesses--;
				if(black == one.pegs())
				{
					System.out.println("You solved the puzzle! Good job.");
					guesses = -1;
				}	
			}

			if(guesses == 0)
			{
				System.out.println("GAME OVER. You lose.");
				System.out.println("The secret code was: " + one.getSecret());
				System.out.println();
			}
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter \"reset\" for another game or anything else to quit: ");
			repeat = sc.next();
			//Repeat if the user inputs "reset"
			willRepeat = (repeat.equals("reset"));
		}
	}
}
