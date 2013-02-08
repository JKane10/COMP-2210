/**
 *		@author Dean Hendrix (dh@auburn.edu)
 *		@version 2011-10-26
 *
 */
   import java.io.File;
   import java.util.Scanner;
   import java.util.ArrayList;
   import java.util.Scanner;
   import java.io.IOException;

/**
* Boggle board game, creates board, creates a dictionary, takes user's words
* and compares them to all possible words on the board or the machine's words
* and awards points.
*
* @author Joshua Kane (jgk0004@auburn.edu)
* @version 2011-11-09
**/


   public class Boggle
   {
   // theBoard
      private BoggleBoard board;
   
   // game dictionary
      private BoggleDictionary dictionary;
      /** user's score. **/
      private int userScore;
      /** machine's score. **/
      private int machineScore;
   	// words attempted by the user.
      private ArrayList<String> userWords = new ArrayList<String>();
      /** words found by the machine. **/
      private ArrayList<String> machineWords = new ArrayList<String>();
      /** words both the machine and user found. **/  
      private ArrayList<String> matchedWords = new ArrayList<String>();
        
   	/** boolean copy of the board indicating
   	* which coordinates have been
   	* searched and which have not. 
   	**/
      private boolean[][] usedLetters = new boolean[4][4];
   
   /**
   * Plays the boggle game, creates board and dictionary
   * prints out the board, gives the user a turn, gives the
   * machine a turn which indicates all words on the board
   * and then awards points.
   *
   *@throws IOException thrown if file not found or valid.
   **/
   
   
      public void playGame() throws IOException
      {
         setupGame();
         board.printBoard();
         userTurn();
         machineTurn();
         reportResults();
      }
      
      public void playGame(String[][] board1) throws IOException
      {
         board = new BoggleBoard();
         board.setBoard(board1);
         setupGame();
         board.printBoard();
         userTurn();
         machineTurn();
         reportResults();
      }
   	/**
   	* sets up board and dictionary.
      *
   	*@throws IOException thrown if file not found or valid.
   	**/
   
      public void setupGame() throws IOException
      {
      // setup board
         if (board == null)
         {
            board = new BoggleBoard();
            System.out.println("Default Board");
            board.setToDefaultBoard();
            board.printBoard();
            System.out.println("Randomized Board");
            board.setToRandomBoard();
         }
         
      
      // setup dictionary
         dictionary = new BoggleDictionary();
         dictionary.loadWords(BoggleDictionary.LARGE_WORD_LIST);
      }
      
   	/**
   	* This method uses recusion to traverse the board. It begins at a given coordiate. 
   	* checks if that coordiate is valid, then checks if the coordinate has been used already.
   	* then checks if the letters given so far could be a word, if they could be it continues.
   	* It adds the letter at this new coordiate to this current letters and then marks that coordinate
   	* visited. It checks to see if the letters are now a word, if so it checks to see if the word has 
   	* already been recorded, if it has not it will record this as a valid word on the board. If the 
   	* letters are not a word the method calls itself sending itself the current letters and the 
   	* coordinates of a neighbor which will has to pass all the previously mentioned checks to create a word.
   	*
   	*@param letters String of letters that could be a word or is a word.
   	*@param i this is the x coordinate for the board.
   	*@param j this is the y coordinate for the board.
   	**/
   	
   	
   	
      public void boardSearch(String letters, int i, int j)
      {
       //checks to see if the recursion is pointing to a valid cell.
         if (!board.isValidCell(i, j)) 
         {
            return;
         }
        // checks to see if cell has been used already.
         if (usedLetters[i][j]) 
         {
            return;
         }
        //if series of letters could not possibly be a word, ends.
         if (!dictionary.maybeWord(letters)) 
         {
            return;
         }
        // not allowed to reuse a letter
         usedLetters[i][j] = true;
        //checks to see if the letters are actually a word and if they are have they already
        //been reported to the list of words.
         letters = letters + (board.getLetter(i, j).toLowerCase());
         if (dictionary.isWord(letters))
         {
            if (!machineWords.contains(letters))
            {
               machineWords.add(letters); 
            }
         }
         //checks if adding neighboring letters using recursion may be a word, if not,
      	//ends and tries another till all neighboring letters exhausted.
         for (int x = -1; x <= 1; x++)
         {
            for (int y = -1; y <= 1; y++)
            {
               boardSearch(letters, i + x, j + y);
            }
         }
      
         usedLetters[i][j] = false;
      }
    
    /**
    * Gives the user a turn and allows him or her to enter words he believes are valid 
    * until the user types "end turn" which will end his turn. Any attempts will be added
    * to an array list of userWords to be verified in the reportResults() method.
    **/
   	
      public void userTurn()
      {
         boolean userTurn = true;
         while (userTurn)
         {
            Scanner userIn = new Scanner(System.in);
            System.out.println("Please attempt a word or enter \"end turn\" at any time to end your turn.");
            String attempt = userIn.nextLine().toLowerCase();
            if (attempt.equals("end turn"))
            {
               userTurn = false;
            }
            else
            {
               userWords.add(attempt);
            }
         }
      }
      
   	/**
   	* Gives the machine it's turn by sending the boardSearch()
   	* method every possible starting point on the board and allowing
   	* it to find words via the starting point and it's neighbors using a depth
   	* first search.
   	**/
   	
      public void machineTurn()
      {
         for (int i = 0; i < 4; i++)
         {
            for (int j = 0; j < 4; j++)
            {
               boardSearch("", i, j);
            }
         }
      }
      
   	/**
   	* This method goes through the machine's list of words and makes sure 
   	* they are all valid (at least 3 letters). It then awards the machine based on
   	* the words it found. It then compares the user's words to the machine's words 
   	* and checks to make sure any words the user found the machine also found as the
   	* machine plays a perfect gaming finding all possible word combinations. If the machine
   	* did not find a word, the word is not on the board or is not valid. Any words that
   	* are not valid are removed from the user's word list. The user is then rewarded 
   	* points based on the words still in his word list. It then prints out the scores.
   	**/
   	
      public void reportResults()
      {
      //removes words less than 3 characters from machine list of words.
         for (int i = 0; i < machineWords.size(); i++)
         {
            if (machineWords.get(i).length() < 3)
            {
               machineWords.remove(i);
               i--;
            }
         }
         
         //prints all the words found by the machine.
         System.out.println("* * * *\nWords found by the machine.\n* * * *");
         int line = 1;
         for (int i = 0; i < machineWords.size(); i++)
         {
            line++;
            System.out.print(machineWords.get(i) + " ");
            
            if (line % 10 == 1)
            {
               System.out.println("");
            }
         }
         
      	
      
         int wordLength = 0;
         for (int i = 0; i < machineWords.size(); i++)
         {
            wordLength = machineWords.get(i).length();
            if ((wordLength >= 3) && (wordLength <= 4))
            {
               machineScore += 1;
            }
            else if (wordLength == 5)
            {
               machineScore += 2;
            }
            else if (wordLength == 6)
            {
               machineScore += 3;
            }
            else if (wordLength == 7)
            {
               machineScore += 4;
            }
            else if (wordLength >= 8)
            {
               machineScore += 11;
            }
         }  
       
         System.out.println("\n\n* * * *\nAttempted words by the user.\n* * * *\n");
         line = 1;
         for (int i = 0; i < userWords.size(); i++)
         {
            line++;
            System.out.print(userWords.get(i) + " ");
            
            if (line % 10 == 1)
            {
               System.out.println("");
            }
         }
          
      	
      	//verify user words are actually valid words.
         for (int i = 0; i < userWords.size(); i++)
         {
            boolean found = false;
            int checksMade = 0;
            int maxChecks = machineWords.size();
            String searchWord = userWords.get(i);
            while (checksMade < maxChecks && (!found))
            {
               if (machineWords.get(checksMade).equals(searchWord))
               {
                  matchedWords.add(searchWord);
                  found = true;
               }
               else
               {
                  checksMade++;
               }
            }
            if (checksMade == maxChecks && (!found))
            {
               userWords.remove(i);
               i--;
            }
         }
         
         System.out.println("\n\n* * * *\nValid words found by the user.\n* * * *\n");
         line = 1;
         for (int i = 0; i < userWords.size(); i++)
         {
            line++;
            System.out.print(userWords.get(i) + " ");
            
            if (line % 10 == 1)
            {
               System.out.println("");
            }
         }
         
         System.out.println("\n\n* * * * \n");
         
         
         for (int i = 0; i < userWords.size(); i++)
         {
            wordLength = userWords.get(i).length();
            if (wordLength >= 3 && wordLength <= 4)
            {
               userScore += 1;
            }
            else if (wordLength == 5)
            {
               userScore += 2;
            }
            else if (wordLength == 6)
            {
               userScore += 3;
            }
            else if (wordLength == 7)
            {
               userScore += 4;
            }
            else if (wordLength >= 8)
            {
               userScore += 11;
            }
         }  
      	
      // You must fill this in. who is winner and point system is correct
         System.out.print("You scored " + userScore + " point(s)");
         System.out.println(" and the computer scored " + machineScore + " point(s)!");
      }
   	   	
   	/**
   	* Creates a new Boggle game and plays it.
   	*
   	*@param args User defined array of arguments
   	*@throws IOException thrown if file not found or valid.
   	**/
      public static void main(String[] args) throws IOException
      {
         if (args.length == 0)
         {
            Boggle boggle = new Boggle();
            boggle.playGame();
         }
         else
         {        
            File fileName = new File(args[0]);
            Scanner in = new Scanner(fileName);
            String dice = "";
            while(in.hasNext())
            {
               dice += in.nextLine();
            }
            String[][] userBoard = new String[4][4];
            int chara = 0;
            int chara1 = 1;
            String l = dice.substring(chara, chara1);  
            while(chara1 < dice.length())
            {
               for (int y = 0; y < 4; y++)
               {
                  for (int x = 0; x < 4; x++)
                  {
                     userBoard[y][x] = (dice.substring(chara, chara1));
                     chara++; chara1++;
                  }
               }
            
            }
            
            Boggle boggle = new Boggle();
            boggle.playGame(userBoard);
         	
         }
      }
   }