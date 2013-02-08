/**
 *		@author Dean Hendrix (dh@auburn.edu)
 *		@version 2011-10-26
 *
 */
 
   import java.util.*;
 
   public class BoggleBoard
   {
   
      public final int DEFAULT_SIZE = 4;
      
      // private String[][] defaultBoard = {               
         // 		{"S","E","R","S"},
         //       {"P","A","T","G"},
         //       {"L","I","N","E"},
         //       {"S","E","R","S"}
         //         };
    
      private String[][] defaultBoard = {               
         		{"E","E","C","A"},
         		{"A","L","E","P"},
         		{"H","N","B","O"},
         		{"Q","T","T","Y"}
         		};
   
      private String[][] theBoard;
      private ArrayList<LetterDie> theDice;
      private int size;
   
      public BoggleBoard()
      {
         size = DEFAULT_SIZE;
         initDice();
         setToDefaultBoard();
      }
      
      public void setToRandomBoard()
      {
         size = DEFAULT_SIZE;
         initDice();
         int size1 = theDice.size();
         String[][] randomBoard = new String[4][4];
         int i = 0;
         while (i < size1)
         {
            for (int j = 0; j < 4; j++)
            {
               for (int k = 0; k < 4; k++)
               {
                  randomBoard[j][k] = theDice.get(i).getRandomFace();
                  i++;
               }
            }
         }
         setBoard(randomBoard);
      }
   	
      public void setToDefaultBoard()
      {
         theBoard = defaultBoard;
      }
      
      public void setBoard(String[][] board)
      {
         theBoard = board;
      }
      
      public String getLetter (int row, int col)
      {
         return theBoard[row][col];
      }
      
      public boolean isValidCell (int row, int col)
      {
         return (row >= 0 && row < size() && col >= 0 && col < size());
      }
      	
      public int size()
      {
         return size;
      }
   	
      public void printBoard()
      {
         System.out.println();
         System.out.println("* * * *");
         
         for (int i = 0; i < size; i++)
         {
            for (int j = 0; j < size; j++)
               System.out.print (theBoard[i][j] + " ");
            System.out.println();
         }
      	
         System.out.println("* * * *");
         System.out.println();
      }
      
      private void initDice()
      {
      // Official Boggle(TM) dice, except for QU on die #2
         theDice = new ArrayList<LetterDie>();
         theDice.add(new LetterDie("F", "O", "R", "I", "X", "B"));
         theDice.add(new LetterDie("M", "O", "Q", "A", "B", "J")); // should have QU
         theDice.add(new LetterDie("G", "U", "R", "I", "L", "W"));
         theDice.add(new LetterDie("S", "E", "T", "U", "P", "L"));
         theDice.add(new LetterDie("C", "M", "P", "D", "A", "E"));
         theDice.add(new LetterDie("A", "C", "I", "T", "A", "O"));
         theDice.add(new LetterDie("S", "L", "C", "R", "A", "E"));
         theDice.add(new LetterDie("R", "O", "M", "A", "S", "H"));
         theDice.add(new LetterDie("N", "O", "D", "E", "S", "W"));
         theDice.add(new LetterDie("H", "E", "F", "I", "Y", "E"));
         theDice.add(new LetterDie("O", "N", "U", "D", "T", "K"));
         theDice.add(new LetterDie("T", "E", "V", "I", "G", "N"));
         theDice.add(new LetterDie("A", "N", "E", "D", "V", "Z"));
         theDice.add(new LetterDie("P", "I", "N", "E", "S", "H"));
         theDice.add(new LetterDie("A", "B", "I", "L", "Y", "T"));
         theDice.add(new LetterDie("G", "K", "Y", "L", "E", "U"));
      
      }
   }