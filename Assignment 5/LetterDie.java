/**
 *		@author Dean Hendrix (dh@auburn.edu)
 *		@version 2011-10-26
 */

   import java.util.Random;

   public class LetterDie
   {
      private String[] sides;
      private int currentSideUp;
      public static Random randomizer = new Random();
   
      public LetterDie(String side1, String side2, String side3,
               String side4, String side5, String side6)    {
         sides = new String[] {side1,side2,side3,side4,side5,side6};
         randomize();
      }
   
      public String getLetter()    {
         return sides[currentSideUp];
      }
   
      public String getRandomFace()    {
         randomize();
         return sides[currentSideUp];
      }
   
      private void randomize()    {
         currentSideUp = randomizer.nextInt(6);
      }
   }