package edu.iastate.cs228.hw1;

/**
 * Class for ProteinSequence, subclass of Sequence. Used to input Protein sequences
 * @author Sydney Ehlinger
 *
 */

public class ProteinSequence extends Sequence
{
	/**
	 * ProteinSequence constructor that passes the inputed protein sequence character array to the superclass to check if the sequence contains valid letters
	 * @param psarr
	 */
  public ProteinSequence(char[] psarr)
  {
    super(psarr);
  }

  /**
   * Overrides the superclass's isValidLetter() to check if the character is not B/b, J/j, O/o, U/u, X/x, or Z/z
   * @return
   * 	True if it does not match one of those characters, false otherwise
   */
  @Override
  public boolean isValidLetter(char aa)
  {
	if(aa == 'b' || aa == 'B' || aa == 'j' || aa == 'J' || aa == 'o' || aa == 'O' || aa == 'u' || aa == 'U' || aa == 'x' || aa == 'X' || aa == 'z' || aa == 'Z'){
		return false;
	}
	return true;
  }
}
