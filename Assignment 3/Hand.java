   import java.util.ArrayList;
   import java.util.Collections;
  
  /**
 * A program that creates a hand of cards all with a suit and value.
 * 
 * @author	Joshua Kane (jgk0004@auburn.edu) and Brian Houghton (bmh0008@auburn.edu)
 * @version	2011-10-02
 */
 
   public class Hand
   {
      
      private ArrayList<Card> hand = new ArrayList<Card>();
      private PokerHandEvaluate evaluate;
      
      
      /** 
   	 * Constructs a hand of 5 cards.
   	 * @param d uses Deck of cards as the input.
   	 */
      public Hand(Deck d)
      {
         for (int i = 0; i < 5; i++)
         {
            hand.add(d.draw());
         }
      }
       /** 
   	 * Constructs a hand of 5 cards.
   	 * @param d uses Deck of cards as the input.
   	 * @param handSize takes in the desired size of hand.
   	 */
      public Hand(Deck d, int handSize)
      {
         for (int i = 0; i < handSize; i++)
         {
            hand.add(d.draw());
         }
      }
      /** Sorts hand into rank major order. */
      public void rankMajorOrder()
      {
         Collections.sort(hand, new CompareCards());
      }
      /** Sorts hand in order by suit. */
      public void rankSuitOrder()
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
   	 * Prints String displaying what cards are in hand.
   	 * @return - string of cards in hand.
   	 */
      public String display()
      {
         int i = 0;
         int lineCount = 0;
      
         String output = "";
         while (i < hand.size())
         {
            String val = "";
            int valInt = hand.get(i).getVal();
            if (valInt == 1)
            {
               val = "Ace";
            }
            else if (valInt == 11)
            {
               val = "Jack";
            }
            else if (valInt == 12)
            {
               val = "Queen";
            }
            else if (valInt == 13)
            {
               val = "King";
            }
            else
            {
               val += hand.get(i).getVal();
            }
            
            if (i % 13 == 0)
            {
               output += ("\n");
            }
         	
            output += (val + hand.get(i).getSuit() + " ");
            i++;
         }
         
      	
         return output;
      }
      /** 
   	 * generates array list of cards.
   	 * @return - returns arraylist of cards in hand.
   	 */
      public ArrayList<Card> getHand()
      {
         return hand;
      }
      
   // // 	/** test method */
      // public void setCard(Card c, int i)
      // {
         // hand.set(i, c);
      // }
   }