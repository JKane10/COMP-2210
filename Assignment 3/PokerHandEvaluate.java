   import java.util.ArrayList;
   import java.util.Collections;
   
    /**
 		* A program that evaluates each hand of cards.
 		* 
 		* @author	Joshua Kane (jgk0004@auburn.edu) and Brian Houghton (bmh0008@auburn.edu)
 		* @version	2011-10-02
 		*/
 
   public class PokerHandEvaluate 
   {
      private ArrayList<Card> hand = new ArrayList<Card>();
      private int matches = 0;
      private int matches1 = 0;
      private int lesserRank = 0;
      private int greaterRank = 0;
      private int[] cardsInHand = new int[14];
   
   	 /** 
   	  * Generates a Hand of cards to be evaluated.
   	  * @param h takes Hand of cards as input.
   	  */
      public PokerHandEvaluate(Hand h)
      {
         hand = h.getHand();
      }
      /** Sorts hand into rank major order. */
      public void majorOrder()
      {
         Collections.sort(hand, new CompareCards());
      }
      /** Suits hand in order by suit. */
      public void suitOrder()
      {
         Collections.sort(hand, new CompareCards());
         int i = 0;
         ArrayList<Card> tempDeck = new ArrayList<Card>();
         while (i < hand.size())
         {
            if (hand.get(i).getSuit() == "H")
            {
               tempDeck.add(hand.get(i));
               hand.remove(i);
            }
            else
            {
               i++;
            }
         }
         i = 0;
         while (i < hand.size())
         {
            if (hand.get(i).getSuit() == "D")
            {
               tempDeck.add(hand.get(i));
               hand.remove(i);
            }
            else
            {
               i++;
            }
         }
         i = 0;
         while (i < hand.size())
         {
            if (hand.get(i).getSuit() == "C")
            {
               tempDeck.add(hand.get(i));
               hand.remove(i);
            }
            else
            {
               i++;
            }
         }
         i = 0;
         while (i < hand.size())
         {
            if (hand.get(i).getSuit() == "S")
            {
               tempDeck.add(hand.get(i));
               i++;
            }
         }
         
         hand = tempDeck;
      }
      
   	/** 
   	 * Sorts cards by major order then evaluates if it is a straight. 
   	 * @return - boolean value represting if hand contains a straight.
   	 */
      boolean straight()
      {
         majorOrder();
         boolean result = false;
         Card c1 = hand.get(0);
         int i = 1;
         while ((i < 5) && (hand.get(i).getVal()) == (c1.getVal() + 1))
         {
            c1 = hand.get(i);
            i++;
         }
         if (i == 5)
         {
            result = true;
         }
         else
         {
            result = false;
         }
         return result;
      }
   	
   	/** 
   	 * Sorts cards by suit order then evaluates if it is a straight flush. 
   	 * @return - boolean value represting if hand contains a straight flush.
   	 */
      boolean straightFlush()
      {
         majorOrder();
         boolean result = false;
         Card card1 = hand.get(0);
         int i = 1;
         while ((i < 5) && (hand.get(i).getVal()) == (card1.getVal() + 1) && (hand.get(i).getSuit() == card1.getSuit()))
         {
            card1 = hand.get(i);
            i++;
         }
         if (i == 5)
         {
            result = true;
         }
         else
         {
            result = false;
         }
         return result;
      }
      /** 
   	 * Sorts cards by suit order then evaluates if it is a flush. 
   	 * @return - boolean value represting if hand contains a flush.
   	 */
   	 
      boolean flush()
      {
         majorOrder();
         Card c1 = hand.get(0);
         int i = 1;
         while ((i < 5) && (hand.get(i).getSuit()) == (c1.getSuit()))
         {
            c1 = hand.get(i);
            i++;
         }
         if (i == 5)
         {
            return true;
         }
         return false;
      }
      // boolean flush()
      // {
         // boolean output = true;
         // for (int i = 0; i < 4; i++)
         // {
            // if (hand.get(i).getSuit() != hand.get(i + 1).getSuit())
            // {
               // output = false;
            // }
            // else
            // {
               // output = true;
            // }
         // }
         // return output;
      // }
    	/** 
   	 * Evaluates if the hand contains pairs of any kind. 
   	 * @return - int representing if hand conatins a pair.
   	 */
      public int pairs()
      {   
         for (int x = 0; x < 5; x++)
         {
            cardsInHand[hand.get(x).getVal()]++;
         }
      
         for (int x = 13; x >= 1; x--)
         {
            if (cardsInHand[x] > matches)
            {
               if (matches != 0)
               {
                  matches1 = matches;
                  lesserRank = greaterRank;
               }
               matches = cardsInHand[x];
               greaterRank = x;
            }
            else if (cardsInHand[x] > matches1)
            {
               matches1 = cardsInHand[x];
               lesserRank = x;
            }	
         }
         
         return 0;
      }
      /** 
   	 * Gets String representing what hand has evaluated to. 
   	 * @return - String represting if what the hand contains.
   	 */
      public String getEvaluation()
      {
         String handRank = "";
         String lowRank = "";
         String highRank = "";
       
         if (lesserRank == 1)
         {
            lowRank = "Ace";
         }
         else if (lesserRank == 11)
         {
            lowRank = "Jack";
         }
         else if (lesserRank == 12)
         {
            lowRank = "Queen";
         }
         else if (lesserRank == 13)
         {
            lowRank = "King";
         }  
         else
         {
            lowRank += lesserRank;
         }
         
         if (greaterRank == 1)
         {
            highRank = "Ace";
         }
         else if (greaterRank == 11)
         {
            highRank = "Jack";
         }
         else if (greaterRank == 12)
         {
            highRank = "Queen";
         }
         else if (greaterRank == 13)
         {
            highRank = "King";
         }  
         else
         {
            highRank += greaterRank;
         }
      	
      	
      	
         //straight flush
         if (straightFlush())
         {
            handRank = "Straight Flush";
            return handRank;
         }
         //four of a kind
         if (matches == 4 || matches1 == 4)
         {
            handRank = ("Four of a kind with " + highRank + "s");
            return handRank;
         }
         //full house goes here
         if (matches + matches1 == 5)
         {
            handRank = ("Full house with three " + highRank + "s and a pair of " + lowRank + "s");
            return handRank;
         }
         //flush
         if (flush())
         {
            handRank = "Flush";
            return handRank;
         }
         //straight
         if (straight())
         {
            handRank = "Straight";
            return handRank;
         }
         //three of a kind
         if (matches == 3 || matches1 == 3)
         {
            handRank = ("Three of a kind with three " + highRank + "s");
            return handRank;
         }  
      	//two pair
         if (matches == 2 && matches1 == 2)
         {
            handRank = ("Pair of " + lowRank + "s and a pair of " + highRank + "s");
            return handRank;
         }
         //pair
         if (matches == 2 || matches1 == 2)
         {
            handRank = ("Pair of " + highRank + "s");
            return handRank;
         }
         if (matches == 1 || matches1 == 1)
         {
            handRank = ("no pair with a high card " + highRank);
            return handRank;
         }
         return handRank;
      }
   }