package edu.iastate.cs228.hw1;

/**
 * Class for Sequence which is the superclass for all the other classes
 * @author Sydney Ehlinger
 *
 */

public class Sequence
{
	/**
	* Character array that stores the character sequence from the constructor
	*/
  protected char[] seqarr;

  /**
   * Constructor for Sequence that checks if the inputed character array's values are are valid using isValidLetter()
   * @param sarr
   * 	Character array sequence
   */
  public Sequence(char[] sarr)
  {
	for(int i = 0; i < sarr.length; i++){
		if(!isValidLetter(sarr[i])){
			throw new IllegalArgumentException("Invalid sequence letter for " + getClass()); 
		}
	}
	seqarr = new char[sarr.length];
	for(int j = 0; j < sarr.length; j++){
		seqarr[j] = sarr[j];
	}
  }

  /**
   * Gets the length of the sequence 
   * @return
   * 	Length of sequence
   */
  public int seqLength()
  {
	return seqarr.length;
  }
  
  /**
   * Creates a copy of the sequence
   * @return
   * 	Copy of sequence
   */
  public char[] getSeq()
  {
	char[] seqarrCopy = new char[seqarr.length];
	for(int i = 0; i < seqarr.length; i++){
		seqarrCopy[i] = seqarr[i];
	}
	return seqarrCopy;
  }

  /**
   * Creates a string representation of the sequence's character array
   * @return
   * 	String representation of the sequence's character array
   */
  public String toString()
  {
	String s = "";
	for(int i = 0; i < seqarr.length; i++){
		s += seqarr[i];
	}
	return s;
  }

  /**
   * Checks if the two objects are equal to each other
   * @return
   * 	True if the objects are equal, false if they are not
   */
  public boolean equals(Object obj)
  { 
	if(this == obj){
		return true;
	}
    if(obj == null || this.getClass() != obj.getClass()){
    	return false;
    }
	Sequence seq = (Sequence) obj;
	if(seq.seqLength() != this.seqLength()){
		return false;
	}
	char[] getSeqObj = seq.getSeq();
	char[] getSeqThis = this.getSeq();
	for(int i = 0; i < seq.seqLength(); i++){
		if(Character.toLowerCase(getSeqObj[i]) != Character.toLowerCase(getSeqThis[i])){
			return false;
		}
	}
    return true;
  }

  /**
   * Checks if the character is a valid letter
   * @param let
   * 	Character to be checked
   * @return
   * 	True if it is a valid letter, false if otherwise
   */
  public boolean isValidLetter(char let)
  {
    if(Character.isUpperCase(let) || Character.isLowerCase(let)){
    	return true;
    }
    return false;
  }
}