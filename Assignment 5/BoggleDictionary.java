
	
   import java.io.File;
   import java.io.IOException;
   import java.util.NavigableSet;
   import java.util.TreeSet;
   import java.util.Iterator;
   import java.util.Scanner;
/**
 *
 *	@author Joshua Kane (jgk0004@auburn.edu)
 *	@version 2011-11-09
 *	
 *	An adaptor class that provides the dictionary behavior necessary
 *	for a Boggle game.
 **/

   public class BoggleDictionary implements Iterable   
   {
      public static final String LARGE_WORD_LIST = "sowpods.txt";
      public static final String SMALL_WORD_LIST = "bogwords.txt";
   
   // You must choose an appropriate type for the dictionary field.
   // You can't leave this field typed as 'Object.'
      private NavigableSet<String> dictionary;
     
   
   /**
   * Creates BoggleDictionary as a TreeSet containing only strings.
   **/
   
      public BoggleDictionary()       
      {
      // Change to construct the dictionary as appropriate.
         dictionary = new TreeSet<String>(); 
      }
      
   	/**
   	* Populates the Dictionary TreeSet with the textfiles containing words.
   	*
   	*@param wordList name of the file containing words.
   	*@throws IOException thrown if file not found or valid.
   	**/
   
      public void loadWords(String wordList) throws IOException
      {
         File fileName = new File(wordList);
         Scanner in = new Scanner(fileName);
         while (in.hasNextLine())
         {
            dictionary.add(in.nextLine().toLowerCase());     
         }
      }
      
   	/**
   	* Method that searches the tree for the word nearest to the given string
   	* and then sees if that word actually contains the given string. If it does
   	* the given string has the potential to become a word given more letters. If
   	* it does not the given string can not become any word given any letters and
   	* will never be a word.
   	* 
   	*@param str given string.
   	*@return true if the string could be a word, false if not
   	**/
      
      public boolean maybeWord(String str)
      {
         str = str.toLowerCase();
         String word = dictionary.ceiling(str);
         if (word == null)
         {
            return false;
         }
         return (word.contains(str));
      }
      
   	/**
   	* Checks to see if the String is an actual word in the TreeSet dictionary as is.
   	*
   	*@param str word given to find in the dictionary
   	*@return true if the word is in the dictionary, false if the word is not in the dictionary.
   	**/
      
      public boolean isWord(String str)
      {
      // You must fill this in as appropriate and chance the return value.
         return dictionary.contains(str);
      }
      
   	/**
   	* returns TreeSet iterator. 
   	*
   	*@return TreeSet iterator.
   	**/
      
      public Iterator iterator()
      {
      // You must fill this in as appropriate and chance the return value.
         return dictionary.iterator();
      }
   }