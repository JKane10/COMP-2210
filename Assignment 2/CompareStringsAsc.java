   import java.util.Comparator;

/**
 * Defines comparison on Strings by ascending
 * lexicographic order.
 * 
 * @author	Dean Hendrix (dh@auburn.edu)
 * @version	2011-08-31
 *
 */
   public class CompareStringsAsc implements Comparator<String>
   {
   /**
    * Compares two strings based on ascending lexicographic order.
    *
    * @param s1	the first string to be compared
    * @param s2	the second string to be compared
    * @return		0 if s1 == s2 
    *					negative int if s1 < s2
    *					positive int if s1 > s2 
    *
    */
      public int compare(String s1, String s2)
      {
         return s1.compareTo(s2);
      }
   }
   	
