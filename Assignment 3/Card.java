 /**
 * A program that creates a single card with a suit and value.
 * 
 * @author	Joshua Kane (jgk0004@auburn.edu) and Brian Houghton (bmh0008@auburn.edu)
 * @version	2011-10-02
 */

   public class Card
   {
   /** value of card. **/
      private int value;
   /** suit of card. **/
      private String cardSuit;
      
   	/**
   	* Constructs the card with its value and suit.
   	*
   	*@param val - value of card
   	*@param suit - suit of card
   	**/
   
      public Card(int val, String suit)
      {
         value = val;
         cardSuit = suit;
      }
      
   	/**
   	* get method that returns the value of the card.
   	*
   	*@return value of card.
   	**/
      
      public int getVal()
      {
         return value;
      }
      
   	/**
   	* get method that returns the suit of the card.
   	*
   	*@return suit of card.
   	**/
   	
      public String getSuit()
      {
         return cardSuit;
      }
      
   	/**
   	* Compare method that compares this card to another card
   	* based on the value.
     	*
   	*@param otherCard card that this card will be compared to.
   	*@return the difference of the two cards values.
   	**/
      
      public int compareToMajorRank(Card otherCard)
      {
         return this.value - otherCard.value;
      }
   }