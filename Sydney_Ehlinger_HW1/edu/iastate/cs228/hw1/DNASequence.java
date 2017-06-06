package edu.iastate.cs228.hw1;

/**
 * Class for DNASequence, subclass of Sequence. Used to input DNA sequences
 * @author Sydney Ehlinger
 *
 */

public class DNASequence extends Sequence
{
	/**
	 * DNASequence constructor that passes the inputed DNA character array to the superclass to check if the sequence contains valid letters
	 * @param dnaarr
	 * 	DNA sequence
	 */
  public DNASequence(char[] dnaarr)
  {
	  super(dnaarr);
  }

  /**
   * Overrides the superclass's isValidLetter() to check if the character is A/a, C/c, G/g, or T/t
   * @return
   * 	True if it is a valid letter, false if otherwise
   */
  @Override
  public boolean isValidLetter(char let)
  {
	if(let == 'a' || let == 'A' || let == 'c' || let == 'C' || let == 'g' || let == 'G' || let == 't' || let == 'T'){
		return true;
	}
	return false;
  }

}
