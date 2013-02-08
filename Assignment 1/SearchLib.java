
/**
 * Search library component of COMP 2210 Assignment 1.
 *
 * @author	Joshua Kane (jgk0004@auburn.edu)
 * @version	2011-08-30
 *
 */
   public class SearchLib
   {
   
   /**
     * Searches array for target. If target is present in array, this
     * method returns the index of target in array. In the case of
     * duplicates, this method returns the index of the first occurrence
     * of target in a from index 0. If target is not present in array,
     * this method returns -1.
     *
     * @param array		the array of strings to search through
     * @param target 	the specific string to search for
     * @return				index of the first occurrence of target in array,
     *						or -1 if target is not in array
     *
     */
      public static int search(String[] array, String target)
      {
         int i = 0;
         while ((i < array.length) && (!array[i].equals(target)))
         {
            i++;
         }
         if ((i < array.length) && (array[i] != target))
         {
            return i;
         }
         else
         {
            return -1;
         }
      }
   }