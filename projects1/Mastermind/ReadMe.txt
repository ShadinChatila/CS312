Mastermind
This program allows you to play the boardgame Mastermind.

It reads from the file called "Mastermind.txt" to determine if the secret code will be shown, the number of colors, the number of pegs, the number of guesses, and the specific colors themselves. To alter the game's settings, alter these varibles accordingly.

Once this has been done, it will generate a random combonation of the colors for the user to guess. This is the secret code, and it can be shown or hidden. The program will then inform the user the number of guesses left to guess the code. 
Next it will prompt the user to input their guess. The guess must be valid, with the correct length, which is the same as number of pegs, and be all caps. A peg should be represented by the first letter of the color.

The program will then take the user inputed code and compare it to the random code. If a color is correctly placed, a black peg is displayed, with the word black. If a color is in both the random code and the user inputed code, but not in the correct place, a white peg is displayed, with the word White.

Using that information, the user is allowed one less guess than he had before to continue attepting to guess the code. If the code is guessed correctly, the user wins and now has the option of starting a new game. If the users guesses expire and the code was not found, the user loses and now has the option of starting a new game.

readFile
Reads in the file "Mastermind.txt" which sets up how the game will be played with certain options including if the code will be shown or not, number of colors, number of guesses, number of pegs, and the colors themselves.

randString
Creates a random array depending on the perameters specified that becomes the secret code.

blackPegs
Checks the users code against the secret code and determines the number of colors that are the same and in the correct place. This number becomes the number of black pegs.

whitePegs
Checks the users code against the secret code and determines the number of colors that are the same but are not in the correct place. This number becomes the number of white pegs.

printBlackAndWhite
Prints out black and white for each number of respective pegs in the specific user input code.

Game
This class manages the game elements of the program, which is taking in the readFile class as well as building the game using all the other classes.