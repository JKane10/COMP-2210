   import java.io.InputStream;
   import java.io.DataInputStream;
   import java.io.PrintStream;
   import java.util.Scanner;
   import java.util.regex.Matcher;
   import java.util.regex.Pattern;

/**
  * User interface component of COMP 2210 Assignment 1.
  * This class provides all the methods necessary to for the
  * application to interact with input and output sources.
  *
  * @author	Joshua Kane (jgk0004@auburn.edu)
  * @version	2011-08-30
  *
  */
   public class UserInterface
   {
   
      public static final int QUIT = -1;
      public static final int UNKNOWN_YEAR = 0;
      public static final String UNKNOWN_STRING = "-10UNKNOWN";
      public static final String RESPONSE_DELIMITER = ",";
   
      private DataInputStream input;
      private Scanner inputScanner;
      private PrintStream output;
      
   /**
     * Default constructor for the user interface. Calls the
     * second constructor, setting the input stream to System.in
     * and the output stream to System.out.
     *
     */
      public UserInterface()
      {
         this(System.in, System.out);
      }
   	
   /**
     * Constructor for the user interface. Initializes the input
     * stream and output stream per the provided parameters, and
     * initializes a scanner on the input stream to facilitate
     * reading.
     *
     * @param	in		the input stream for the application
     * @param	out	the output stream for the application
     */
      public UserInterface(InputStream in, PrintStream out)
      {
         input = new DataInputStream(in);
         inputScanner = new Scanner(input);
         output = out;
      }
   
   /**
     * Prints the introduction to the application.
     *
     */
      public void start()
      {
         output.println();
         output.println("*******************************************************************************");
         output.println("                       How Popular is Your Name?");
         output.println("*******************************************************************************");
         output.println();
         output.print("This app will tell you how popular a name was in any given year ");
         output.print("from " + FileHandler.FIRST_YEAR + " ");
         output.println("to " + FileHandler.LAST_YEAR + ".");
         output.println("Data provided by the US Social Security Administration (www.socialsecurity.gov).");
         output.println();
      }
      
   /**
     * Prints the stop application message and closes the
     * input and output streams.
     *
     */
      public void stop()
      {
         output.println(FileHandler.NEW_LINE + "Goodbye.");
         try
         {
            input.close();
            output.close();
         }
            catch (Exception e)
            {
               System.out.println("Couldn't close I/O stream.");
               System.exit(0);
            }
      }
   
   /**
     * Gets values for year, sex, and name from the input stream,
     * and returns them as a single delimited string.
     *
     * @return		a String containing the name, sex, and year
     *				delimited by the RESPONSE_DELIMITER.
     *
     */
      public String getResponse()
      {
         int year = QUIT;
         String sex = UNKNOWN_STRING;
         String name = UNKNOWN_STRING;
         
         year = getYear();
         if (year != QUIT)
         {
            sex = getSex();
            name = getName();
         }
         
         return name + RESPONSE_DELIMITER + sex + RESPONSE_DELIMITER + year;
      }
   
   /**
     * Writes the result of the search to the output stream.
     * The format and requirements of the output are specified in the
     * assignment description.
     *
     * @param name		the name that was searched for
     * @param sex			the sex associated with the search name
     * @param year		the year associated with the search name
     * @param n			the rank/position of the name in the associated data file
     * @param total		the total number of names of the specified sex recorded in the associated data file
     *
     */
      public void displayResult(String name, String sex, int year, int n, int total)
      {
         if (sex.equals("F"))
         {
            sex = "girl's";
         }
         else
         { 
            sex = "boy's";
         }
         
         if (n == 0)
         {
            output.println("\r\t" + name + " does not appear on the list of most popular "
               + sex + " names for " + year + "\r");
         }
         
         else
         {
            output.println("\r\t" + name + " is number " + n + " on the list of "
               + total + " most popular " + sex + " names for " + year + "\r");
         }
      }
      
   /**
     * Continually prompts for a year to be input until
     * a valid year is read.
     *
     * @return		a valid year
     *
     */
      private int getYear()
      {
         int year = QUIT;
         do
         {
            output.print("Enter a year or " + QUIT + " to quit, then press <Enter>: ");
            
         	
            try
            {
               year = Integer.parseInt(inputScanner.next());
            }
               catch (Exception e)
               {
                  year = UNKNOWN_YEAR;
               }
         } while (!validYear(year));
         return year;
      }
   	
   /**
     * Continually prompts for a sex to be input until
     * a valid sex is read.
     *
     * @return		a valid sex
     *
     */
      private String getSex()
      {
         String sex = UNKNOWN_STRING;
         do
         {
            output.print("Enter the sex (M/F), then press <Enter>: ");
            try
            {
               sex = inputScanner.next();
            }
               catch (Exception e)
               {
                  sex = UNKNOWN_STRING;
               }
         } while (!validSex(sex));
         return sex;
      }
   	
   /**
     * Continually prompts for a name to be input until
     * a valid name is read.
     *
     * @return		a valid name
     *
     */
      private String getName()
      {
         String name = UNKNOWN_STRING;
         do
         {
            output.print("Enter the name, then press <Enter>: ");
            try
            {
               name = inputScanner.next();
            }
               catch (Exception e)
               {
                  name = UNKNOWN_STRING;
               }
         } while (!validName(name));
         return name;
      }
      
   /**
     * Validates the year according to the legal values specified
     * in the FileHandler class.
     *
     * @param 	year	the year being validated
     * @return			true if year is valid, false otherwise
     *
     */
      private boolean validYear(int year)
      {
         return (((year >= FileHandler.FIRST_YEAR) && (year <= FileHandler.LAST_YEAR)) || (year == QUIT));
      }
      
   /**
     * Validates the sex according to the legal values specified
     * in the FileHandler class.
     *
     * @param	sex	the sex being validated
     * @return			true if sex is valid, false otherwise
     *
     */
      private boolean validSex(String sex)
      {
         return (sex.equalsIgnoreCase("F") || sex.equalsIgnoreCase("M"));
      }
   
   /**
     * Validates the name to ensure that only alphabetic characters
     * (upper and lower case, a-z) are used.
     *
     * @param	name	the name being validated
     * @return			true if name is valid, false otherwise
     *
     */
      private boolean validName(String name)
      {
      
         Pattern p = Pattern.compile("[a-zA-Z]{1,100}");
         Matcher m = p.matcher(name);
         return m.matches();
      
      }
   }