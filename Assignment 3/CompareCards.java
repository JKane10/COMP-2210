   import java.util.Comparator;

 /**
 * A program that compares two cards based on their value.
 * 
 * @author	Joshua Kane (jgk0004@auburn.edu) and Brian Houghton (bmh0008@auburn.edu)
 * @version	2011-10-02
 */

   class CompareCards implements Comparator<Card>
   {
   
   /**
   * compares two cards based on their value.
   *
   *@param c1 - card one.
   *@param c2 - card two being compared to card one.
   *@return - int value returned indicating order.
   *			  	if c1 < c2; -1
   *				if c1 = c2;  0
   *				if c1 > c2;  1
   **/
   
      public int compare(Card c1, Card c2)
      {
         return c1.compareToMajorRank(c2);
      }
     
   }
