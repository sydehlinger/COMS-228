package edu.iastate.cs228.hw1;

/**
 * Class for CodingDNASequence, subclass of DNASequence. Used to input Coding DNA sequences
 * @author Sydney Ehlinger
 *
 */

public class CodingDNASequence extends DNASequence
{
	/**
	 * CodingDNASequence constructor that passes the inputed Coding DNA character array to the superclass to check if the sequence contains valid letters
	 * @param cdnaarr
	 */
  public CodingDNASequence(char[] cdnaarr)
  {
	  super(cdnaarr);
  }

  /**
   * Checks if the sequence begins with A/a, T/t, or G/g
   * @return
   * 	True if it does, false otherwise
   */
  public boolean checkStartCodon()
  {
	char[] seq = super.getSeq();
    if(super.seqLength() < 3){
    	return false;
    }
    if(seq[0] == 'A' || seq[0] == 'a'){
    	if(seq[1] == 'T' || seq[1] == 't'){
    		if(seq[2] == 'G' || seq[2] == 'g'){
    	    	return true;
    		}
    	}
    }
    return false;
  }

  /**
   * Translate the coding sequence into amino acids
   * @return
   * 	Character array of translated amino acids
   */
  public char[] translate()
  {
	char[] seq = super.getSeq();
    if(!checkStartCodon()){
    	throw new RuntimeException("No start codon");
    }
    if(seq.length % 3 == 0){
    	char[] codon = new char[seq.length / 3];
		int index = 0;
    	for(int i = 0; i <= seq.length - 2; i += 3){
    		String s = "";
    		s = "" + seq[i] + seq[i + 1] + seq[i + 2];
    		if(getAminoAcid(s) != '$'){
	    		codon[index] = getAminoAcid(s);
	    		index++;
    		}else{
    			return codon;
    		}
    	}
    	return codon;
    }else{
    	char[] codon = new char[(seq.length / 3)];
		int index = 0;
    	for(int i = 0; i < seq.length; i +=3){
    		if(i == seq.length - 1){
    			String s = "";
    			s = "" + seq[i];
    	    	if(getAminoAcid(s) != '$'){
    		    	codon[index] = getAminoAcid(s);
    		    	index++;
    	    	}else{
    	    		return codon;
    	    	}
    		}else if(i == seq.length - 2){
    			String s = "";
    			s = "" + seq[i] + seq[i + 1];
    	    	if(getAminoAcid(s) != '$'){
    		    	codon[index] = getAminoAcid(s);
    		    	index++;
    	    	}else{
    	    		return codon;
    	    	}
    		}else{
    	    	String s = "";
    	    	s = "" + seq[i] + seq[i + 1] + seq[i + 2];
    	    	if(getAminoAcid(s) != '$'){
    		    	codon[index] = getAminoAcid(s);
    		    	index++;
    	    	}else{
    	    		return codon;
    	    	}
    		}
    	}
    	return codon;
    }
  }

  /**
   * Takes in string and returns a character representing the string
   * @param codon
   * 	String to be changed into an amino acid
   * @return
   * 	Amino acid character
   */
  private char getAminoAcid(String codon)
  {
    if ( codon == null ) return '$';
    char aa = '$';
    switch ( codon.toUpperCase() )
    {
      case "AAA": aa = 'K'; break;
      case "AAC": aa = 'N'; break;
      case "AAG": aa = 'K'; break;
      case "AAT": aa = 'N'; break;

      case "ACA": aa = 'T'; break;
      case "ACC": aa = 'T'; break;
      case "ACG": aa = 'T'; break;
      case "ACT": aa = 'T'; break;

      case "AGA": aa = 'R'; break;
      case "AGC": aa = 'S'; break;
      case "AGG": aa = 'R'; break;
      case "AGT": aa = 'S'; break;

      case "ATA": aa = 'I'; break;
      case "ATC": aa = 'I'; break;
      case "ATG": aa = 'M'; break;
      case "ATT": aa = 'I'; break;

      case "CAA": aa = 'Q'; break;
      case "CAC": aa = 'H'; break;
      case "CAG": aa = 'Q'; break;
      case "CAT": aa = 'H'; break;

      case "CCA": aa = 'P'; break;
      case "CCC": aa = 'P'; break;
      case "CCG": aa = 'P'; break;
      case "CCT": aa = 'P'; break;

      case "CGA": aa = 'R'; break;
      case "CGC": aa = 'R'; break;
      case "CGG": aa = 'R'; break;
      case "CGT": aa = 'R'; break;

      case "CTA": aa = 'L'; break;
      case "CTC": aa = 'L'; break;
      case "CTG": aa = 'L'; break;
      case "CTT": aa = 'L'; break;

      case "GAA": aa = 'E'; break;
      case "GAC": aa = 'D'; break;
      case "GAG": aa = 'E'; break;
      case "GAT": aa = 'D'; break;

      case "GCA": aa = 'A'; break;
      case "GCC": aa = 'A'; break;
      case "GCG": aa = 'A'; break;
      case "GCT": aa = 'A'; break;

      case "GGA": aa = 'G'; break;
      case "GGC": aa = 'G'; break;
      case "GGG": aa = 'G'; break;
      case "GGT": aa = 'G'; break;

      case "GTA": aa = 'V'; break;
      case "GTC": aa = 'V'; break;
      case "GTG": aa = 'V'; break;
      case "GTT": aa = 'V'; break;

      case "TAA": aa = '$'; break;
      case "TAC": aa = 'Y'; break;
      case "TAG": aa = '$'; break;
      case "TAT": aa = 'Y'; break;

      case "TCA": aa = 'S'; break;
      case "TCC": aa = 'S'; break;
      case "TCG": aa = 'S'; break;
      case "TCT": aa = 'S'; break;

      case "TGA": aa = '$'; break;
      case "TGC": aa = 'C'; break;
      case "TGG": aa = 'W'; break;
      case "TGT": aa = 'C'; break;

      case "TTA": aa = 'L'; break;
      case "TTC": aa = 'F'; break;
      case "TTG": aa = 'L'; break;
      case "TTT": aa = 'F'; break;
      default:    aa = '$'; break;
    }
    return aa;
  }
}