   import java.util.ArrayList;
   import java.util.Collections;

 /**
 * A program that creates a single deck of cards all with a suit and value.
 * 
 * @author	Joshua Kane (jgk0004@auburn.edu) and Brian Houghton (bmh0008@auburn.edu)
 * @version	2011-10-02
 */

   public class Deck
   {
   /** The deck of cards. **/
      private ArrayList<Card> deck = new ArrayList<Card>();
         
    /**
    * Constructs a deck of cards starting with each suit.
    **/  
   	
      public Deck()
      {
         int i = 0;
         while (i < 52)
         {
            if (i < 13)
            {
               deck.add(new Card((i + 1), "D"));
               i++;
            }
            else if (13 <= i && i < 26)
            {
               deck.add(new Card((i - 12), "H"));
               i++;
            }
            else if (26 <= i && i < 39)
            {
               deck.add(new Card((i - 25), "S"));
               i++;
            }
            else if (39 <= i && i < 52)
            {
               deck.add(new Card((i - 38), "C"));
               i++;
            }   
         }
      }
      
   	/**
   	* Shuffles or randomizes the deck of cards.
   	**/
   	
      public void shuffle()
      {
         Collections.shuffle(deck);
      }
      
   	/**
   	* sorts the deck of cards in rank major order (ace-king).
   	**/
      
      public void rankMajorOrder()
      {
         Collections.sort(deck, new CompareCards());
      }
      
   	/**
   	* sorts the deck of cards in rank and suit order (ace-king hearts, ace-king diamonds, etc.).
   	**/
      
      public void rankSuitOrder()
      {
         Collections.sort(deck, new CompareCards());
         int i = 0;
         ArrayList<Card> tempDeck = new ArrayList<Card>();
         while (i < deck.size())
         {
            if (deck.get(i).getSuit() == "C")
            {
               tempDeck.add(deck.get(i));
               deck.remove(i);
            }
            else
            {
               i++;
            }
         }
         i = 0;
         while (i < deck.size())
         {
            if (deck.get(i).getSuit() == "D")
            {
               tempDeck.add(deck.get(i));
               deck.remove(i);
            }
            else
            {
               i++;
            }
         }
         i = 0;
         while (i < deck.size())
         {
            if (deck.get(i).getSuit() == "H")
            {
               tempDeck.add(deck.get(i));
               deck.remove(i);
            }
            else
            {
               i++;
            }
         }
         i = 0;
         while (i < deck.size())
         {
            if (deck.get(i).getSuit() == "S")
            {
               tempDeck.add(deck.get(i));
               i++;
            }
         }
         
         deck = tempDeck;
      }
    
    /**
    * Prints out the cards in the deck by their rank value followed by their suit.
    *
    *@return the deck in text form.
    **/  
   	
      public String display()
      {
         int i = 0;
         int lineCount = 0;
      
         String output = "";
         while (i < deck.size())
         {
            String val = "";
            int valInt = deck.get(i).getVal();
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
               val += deck.get(i).getVal();
            }
            
            if (i % 13 == 0)
            {
               output += ("\n");
            }
         	
            output += (val + deck.get(i).getSuit() + " ");
            i++;
         }
         
      	
         return output;
      }
      
   	/**
   	* A method to take cards out of the deck.
   	*
   	*@return returns the first card of the deck and removes it from the deck.
   	**/
      
      public Card draw()
      {
         return deck.remove(0);
      }
      
   }