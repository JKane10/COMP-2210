   import java.io.FileReader;
   import java.util.Scanner;
   import java.util.ArrayList;

/**
 * File handler component of COMP 2210 Assignment 1.
 * This class provides all the methods necessary to
 * process the data files associated with the assignment.
 * This class also encapsulates the file-specific properties
 * (such as delimiters, filename patterns, etc.) that other
 * components can reference.
 *
 * @author	Joshua Kane (jgk0004@auburn.edu)
 * @version	2011-08-30
 *
 */
   public class FileHandler
   {
   
      public static final String DEFAULT_DIRNAME = "names";
      public static final String FILE_PREFIX = "yob";
      public static final String FILE_SUFFIX = ".txt";
      public static final String FILE_SEPARATOR = System.getProperty("file.separator");
      public static final String NEW_LINE = System.getProperty("line.separator");
   	
      public static final int FIRST_YEAR = 1880;
      public static final int LAST_YEAR = 2010;
      public static final String MALE = "M";
      public static final String FEMALE = "F";
      public static final String FIELD_DELIMITER = ",";
   
   
   /**
    * Loads the data from a particular directory and file.
    *
    * @param year          denotes the year of data we are looking for
    * @param sex           denotes female ("F") or male ("M")
    * @param directoryName The name of the directory where the data is located
    * @return              the list of names
    *
    */    
      @SuppressWarnings("unchecked")
      public static String[] loadData(int year, String sex, String directoryName)
      {
         String filename = directoryName + FILE_SEPARATOR + FILE_PREFIX + year + FILE_SUFFIX;
         Scanner fileScanner = null;
         String[] nameArray = new String[10];
         ArrayList<String> nameList = new ArrayList<String>();
         try
         {
            fileScanner = new Scanner(new FileReader(filename));
            while (fileScanner.hasNextLine())
            {
               String currentLine = fileScanner.nextLine();
               Scanner lineScanner = new Scanner(currentLine);
               lineScanner.useDelimiter(FIELD_DELIMITER);
               String name = lineScanner.next();
               
            	
               if (lineScanner.next().equals(sex))
               {
                  nameList.add(name);
               }
               else if (sex.equals(FEMALE))
               {
                  break;
               }
            }
            nameArray = nameList.toArray(nameArray);
         }
            catch (Exception e)
            {
               System.out.println("Error: Could not load data file.");
            }
         finally
         {
            fileScanner.close();
            return nameArray;
         }
      }
   
   
   }