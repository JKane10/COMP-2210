   import java.util.Comparator;
   import java.util.Collection;

/**
 * Defines a library of search and selection methods.
 * 
 * @author	Dean Hendrix (dh@auburn.edu)
 * @version	2011-08-31
 *
 */
   public class SearchLibrary
   {
   
   /**
    * Searches collection for element using the supplied Comparator.
    * This method returns true if element is found in the collection
    * and false otherwise. This method throws an IllegalArgumentException
    * if the collection or comparator is null.
    *
    * Any implementation must ensure that this method does not modify
    * the collection in any way.
    *
    * @param <T>				the type of objects involved
    * @param collection		the collection to be searched through
    * @param comp				the Comparator to use for comparison
    * @param element			the item being searched for
    * @return					true if element is in collection, false otherwise
    *
    */
      public static <T> boolean contains(Collection<? extends T> collection, Comparator<? super T> comp, T element)
      {
         return false;
      }
   
   
   /**
    * Selects the minimum element from a collection, as defined by
    * the supplied Comparator for T. This method returns null if
    * the collection is empty, and throws an IllegalArgumentException
    * if the collection or comparator is null. In the case of duplicates,
    * no guarantee is made about which qualifying element is returned.
    *
    * Any implementation must ensure that running time of this method
    * is never greater than time proportional to the number of elements
    * in the collection. That is, the running time of this method must
    * be O(n).
    *
    * Any implementation must ensure that this method does not modify
    * the collection in any way.
    *
    * @param <T>				the type of objects involved
    * @param collection		the collection to be searched through
    * @param comp				the Comparator to use for comparison
    * @return					minimum element in collection
    * @throws					IllegalArgumentException if collection or comp
    *                      is null.
    *
    */
      public static <T> T min(Collection<? extends T> collection, Comparator<? super T> comp)
      {
         return null;
      }
   
   
   /**
    * Selects the maximum element from a collection, as defined by
    * the supplied Comparator for T. This method returns null if
    * the collection is empty, and throws an IllegalArgumentException
    * if the collection or comparator is null. In the case of duplicates,
    * no guarantee is made about which qualifying element is returned.
    *
    * Any implementation must ensure that running time of this method
    * is never greater than time proportional to the number of elements
    * in the collection. That is, the running time of this method must
    * be O(n).
    *
    * Any implementation must ensure that this method does not modify
    * the collection in any way.
    *
    * @param <T>				the type of objects involved
    * @param collection		the collection to be searched through
    * @param comp				the Comparator to use for comparison
    * @return					maximum element in collection
    * @throws					IllegalArgumentException if collection or comp
    *                      is null.
    *
    */
      public static <T> T max(Collection<? extends T> collection, Comparator<? super T> comp)
      {
         return null;
      }
   
   
   /**
    * Selects the kth minimum element from collection using dense ranking ("1223"), 
    * as defined by the supplied Comparator for T. This method returns null if
    * the collection is empty or if there is no kth minimum element for the given
    * value of k. This method throws an IllegalArgumentException if the collection
    * or comparator is null. In the case of duplicates, no guarantee is made about which 
    * qualifying element is returned.
    *
    * Any implementation must ensure that this method does not modify
    * the collection in any way.
    *
    * @param <T>				the type of objects involved
    * @param collection		the collection to be searched through
    * @param comp				the Comparator to use for comparison
    * @param k					the order statistic
    * @return					kth minimum element in collection
    * @throws					IllegalArgumentException if collection or comp
    *                      is null.
    *
    */
      public static <T> T kmin(Collection<? extends T> collection, Comparator<? super T> comp, int k)
      {
         return null;
      }
   
   
   /**
    * Selects the kth maximum element from collection using dense ranking ("1223"), 
    * as defined by the supplied Comparator for T. This method returns null if
    * the collection is empty or if there is no kth maximum element for the given
    * value of k. This method throws an IllegalArgumentException if the collection
    * or comparator is null. In the case of duplicates, no guarantee is made about which 
    * qualifying element is returned.
    *
    * Any implementation must ensure that this method does not modify
    * the collection in any way.
    *
    * @param <T>				the type of objects involved
    * @param collection		the collection to be searched through
    * @param comp				the Comparator to use for comparison
    * @param k					the order statistic
    * @return					kth maximum element in collection
    * @throws					IllegalArgumentException if collection or comp
    *                      is null.
    *
    */
      public static <T> T kmax(Collection<? extends T> collection, Comparator<? super T> comp, int k)
      {
         return null;
      }
   
   
   /**
    * Searches collection comparing elements to both low and high with
    * the supplied Comparator. This method returns a Collection containing
    * all the elements in collection that are greater than or equal to low
    * and less than or equal to high. If collection is empty or if there are
    * no qualifying elements, this method returns an empty Collection.
    * This method throws an IllegalArgumentException if the collection, comparator, 
    * low, or high is null.
    *
    * Any implementation must ensure that this method does not modify
    * the collection in any way.
    *
    * @param <T>				the type of objects involved
    * @param collection		the collection of elements to be searched through
    * @param low				the lower bound of the range
    * @param high				the upper bound of the range
    * @param comp				the Comparator to use for comparison
    * @return					Collection of elements e such that low <= e <= high
    * @throws					IllegalArgumentException if collection, comp, low,
    *                      or high is null.
    *
    */
      public static <T> Collection<T> range(Collection<? extends T> collection, Comparator<? super T> comp, T low, T high)
      {
         return null;
      }
   
   
   
   
   }