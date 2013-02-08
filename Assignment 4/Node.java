/**
 * Simple implemenation of a singly-linked node for dynamic storage schemes.
 *
 * @param	<T>	type of elements stored in the nodes.
 *
 * @author Joshua Kane (jgk0004@auburn.edu) and Jamal Adams (jaa0011@auburn.edu)
 * @version	2011-10-20
 *
 */
   public class Node<T>
   {
   
   /** Data stored in the node. */
      private T element;
   
   /** Pointer to the node following this one. */
      private Node<T> next;   
   
   
    /**
     * Creates an empty node.
     *
     */
      public Node()
      {
         next = null;
         element = null;
      }
   
    /**
     * Creates a node storing the specified element.
     *
     * @param elem	the element to store in this node
     *
     */
      public Node(T elem)
      {
         next = null;
         element = elem;
      }
      
    /**
     * Creates a node storing the specified element and a
     * link to the next node.
     *
     * @param elem	the element to store in this node
     * @param n		a pointer to the node that should follow this one
     *
     */
      public Node(T elem, Node<T> n)
      {
         next = n;
         element = elem;
      }
   
   
    /**
     * Returns the node that follows this one.
     *
     * @return		the node that follows this one
     *
     */
      public Node<T> getNext()
      {
         return next;
      }
   
    /**
     * Sets the node that follows this one to the parameter.
     *
     * @param node	a pointer to the node that should follow this one
     *
     */
      public void setNext(Node<T> node)
      {
         next = node;
      }
   
    /**
     * Returns the element stored in this node.
     *
     * @return		the element stored in this node
     *
     */
      public T getElement()
      {
         return element;
      }
   
    /**
     * Sets the element stored in this node to the parameter.
     *
     * @param elem	the element to be stored in this node
     *
     */
      public void setElement(T elem)
      {
         element = elem;
      }
   }
