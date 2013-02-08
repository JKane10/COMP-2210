 /**
 *
 * 
 * @author	Joshua Kane (jgk0004@auburn.edu)
 * @version	2011-09-08
 *
 */
   
   
   public class Assignment3
   { 
    /**
    * Instantiates a deck of playing cards.
    *
    *@param args array of string arguments.
    **/
    
      public static void main(String[] args)
      {
      // deck created in rank major order
         Deck d = new Deck();
         d.rankMajorOrder();
         System.out.print("Deck created rank major order.\n" + d.display());
        
      //shuffled
         d.shuffle();
         System.out.print("\n\n\nDeck shuffled.\n" + d.display());
         
      //rank suit order
         d.rankSuitOrder();
         System.out.print("\n\n\nDeck sorted into rank suit order.\n" + d.display());
         
      	
       //shuffled  
         d.shuffle();
         System.out.print("\n\n\nDeck shuffled.\n" + d.display());
         
      //deck sorted in rank major order.
         d.rankMajorOrder();
         System.out.print("\n\n\nDeck sorted into rank major order.\n" + d.display());
         
      //shuffle
         d.shuffle();
         System.out.print("\n\n\nDeck shuffled.\n" + d.display());
         
      //creates hand
         Hand h = new Hand(d);
         
      //sorts into suit order
         h.rankSuitOrder();
         System.out.print("\n\n\nHand sorted into rank suit order.\n" + h.display());
         
      //sorts hand into rank order.
         h.rankMajorOrder();
         System.out.print("\n\n\nHand sorted into rank major order.\n" + h.display());
      	
      //evaluated	
         PokerHandEvaluate e = new PokerHandEvaluate(h);
         e.straightFlush();
         e.pairs();
         System.out.print("\n\nThe highest poker evaluation for this hand is " + e.getEvaluation());
      
      }
   }