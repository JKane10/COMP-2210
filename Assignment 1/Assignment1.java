   import java.util.Scanner;
 
/**
 * Driver component of COMP 2210 Assignment 1.
 *
 * @author	Joshua Kane (jgk0004@auburn.edu)
 * @version	2011-08-30
 *
 */
   public class Assignment1
   {
   
   /**
     * Driver main method.
     *
     * @param args	Command line arguments. If present, arg[0] is
     *               used as the data directory name.
     *
     */
      public static void main(String[] args)
      {
      
      
         UserInterface ui = new UserInterface(System.in, System.out);
         ui.start();
          
      	 
         int loop = 0;
      	 
         while (loop == 0)
         {
            String request = ui.getResponse();
            Scanner scanner = new Scanner(request).useDelimiter(UserInterface.RESPONSE_DELIMITER);
            String name = scanner.next();
            String sex = scanner.next();
            int year = Integer.parseInt(scanner.next());
            
            if (year == -1)
            {
               ui.stop();
               break;
            }
            
            String[] nameArray = new String[10];
            String dir = (args.length > 0 ? args[0] : FileHandler.DEFAULT_DIRNAME);
            try
            {
               nameArray = FileHandler.loadData(year, sex, dir);
            }
               catch (Exception e)
               {
                  System.out.println("Exiting application.");
               }
            int n = SearchLib.search(nameArray, name);
            ui.displayResult(name, sex, year, n + 1, nameArray.length);
            
         
         }
      
      }
   }