   import java.util.Comparator;
   import java.util.Collection;
   import java.util.ArrayList;
   
/**
 * Sample client for SearchLibrary.java.
 * 
 * @author	Dean Hendrix (dh@auburn.edu)
 * @version	2011-08-31
 *
 */
   public class SearchLibClient
   {
   
   /**
   * Exercises sample search and selection methods.
   * 
   * @param args	command line args not used
   *
   */
      public static void main(String[] args)
      {
         ArrayList<String> list = new ArrayList<String>();
         list.add("4");
         list.add("2");
         list.add("3");
         list.add("5");
         list.add("1");
      
         Comparator<String> stringComp = new CompareStringsAsc();
      
         String min = SearchLibrary.min(list, stringComp);
         System.out.println(min);
      	
         String kmin = SearchLibrary.kmin(list, stringComp, 3);
         System.out.println(kmin);
         
         String kmax = SearchLibrary.kmax(list, stringComp, 2);
         System.out.println(kmax);
         
         Collection<String> range = new ArrayList<String>();
         range = SearchLibrary.range(list, stringComp, "2", "4");
         System.out.println(range);
      }
      
   }