 /**
 * Node based implementation of IDnaStrand. This implementation uses
 * Nodes to represent genomic/DNA data.
 *
 * @author Joshua Kane (jgk0004@auburn.edu) and Jamal Adams (jaa0011@auburn.edu)
 * @version	2011-10-20
 **/
   public class LinkedStrand implements IDnaStrand 
   {
      private static final LinkedStrand EMPTYSTRAND = new LinkedStrand();
   
      private Node<String> front = new Node<String>();
      
      private Node<String> rear;
      
      private long size;
   
     
     /**
     * Create a strand representing an empty DNA strand, length of zero.
     */
      public LinkedStrand()
      {
         front.setElement(null);
         rear = front;
      }
      
   	
     /**
     * Create a strand representing s. No error checking is done to see if s represents
     * valid genomic/DNA data.
     *
     * @param s is the source of cgat data for this strand
     */  
      public LinkedStrand(Node<String> s)
      {
         front = s;
         rear = front;
      }
   
     /**
     * Perform a cut with the enzyme as the source of the location for the cut. The strand
     * before the enzyme-cut becomes this strand (if no enzyme found, no cut is made). The strand
     * after the enzyme-cut is returned as a newly created Strand by this method. The first
     * occurrence of enzyme is the source of the cut being made by this method.
     *
     * @param enzyme is the enzyme/genome at which a cut is made.
     * @return new strand leaving original strand unchanged.
     **/
      public IDnaStrand cutWith(String enzyme)
      {
         String dna = front.getElement();
         int pos = dna.indexOf(enzyme);
         if (pos == -1)
         {
            return EMPTYSTRAND;
         }
         
         IDnaStrand ret = new LinkedStrand();
         ret.initializeFrom(dna.substring(pos + enzyme.length()));
         initializeFrom(dna.substring(0, pos));
         return ret;
      }
      
     /**
     * Cut this strand at every occurrence of enzyme, essentially replacing
     * every occurrence of enzyme with splicee.
     *
     * @param enzyme is the pattern/strand searched for and replaced
     * @param splicee is the pattern/strand replacing each occurrence of enzyme
     * @return the new strand leaving the original strand unchanged.
     */
      public IDnaStrand cutAndSplice(String enzyme, String splicee)
      {
         LinkedStrand recom = new LinkedStrand();    
         if (front.getNext() != null)
         {
            throw new RuntimeException("link strand has more than one node");
         }
         int pos = 0;
         int lastPos = -1;
         String search = front.getElement();
         boolean first = true;
         while ((pos = search.indexOf(enzyme, pos)) >= 0) {
            if (first) 
            {
               String s = search.substring(0, pos);
               recom.initializeFrom(s);
               first = false;
            }
            else {
               String s = search.substring(lastPos, pos);
               recom.append(s);
            }
            recom.append(splicee);
            pos += enzyme.length();
            lastPos = pos;
         }
         String s = search.substring(lastPos);
         recom.append(s);
         return recom;
      }
      
     /**
     * Returns the number of nucleotides/base-pairs in this strand.
     *
     * @return the number of base-pairs in this IDnaStrand
     */
      public long size()
      {
         if (front.getNext() == null)
         {
            return strandInfo().length();
         }
         else
         {
            return size;
         }
      }
      
     /**
     * Initialize this strand so that it represents source, no error
     * checking is done.
     *
     * @param source is the source of this enzyme
     */
      public void initializeFrom(String source) {
         front.setElement(source);
         front.setNext(null);
         this.size += source.length();
      }
   
     /**
     * Return some string identifying this class.
     *
     * @return a string representing this strand and its characteristics
     */
      public String strandInfo()
      {
         return front.getElement();
      }
      
     /**
     * Append a strand of DNA to this strand. If the strand being appended
     * is represented by a LinkedStrand object then an efficient append is
     * performed, otherwise the append is inefficient (even though it doesn't have to be).
     *
     * @param dna is the strand being appended
     * @return returns string with IDnaStrand appended to the end.
     */
      public IDnaStrand append(IDnaStrand dna)
      {
         rear.setNext(new Node<String>(dna.strandInfo()));
         rear = rear.getNext();
         this.size += dna.strandInfo().length();         
         return this;
      }
      
   	
     /**
     * Simply append a strand of dna data to this strand.
     *
     * @param dna is the String appended to this strand
     * @return returns IDnaStrand with string appended to the back.
     */
      public IDnaStrand append(String dna)
      {
         rear.setNext(new Node<String>(dna));
         rear = rear.getNext();
         this.size += dna.length();         
         return this;
      }
   
   }