package edu.iastate.cs228.hw1;

/**
 * Class for GenomicDNASequence, subclass of DNASequence. Used to input Genomic DNA sequences
 * @author Sydney Ehlinger
 *
 */

public class GenomicDNASequence extends DNASequence
{
	/**
	 * GenomicDNASequence constructor that passes the inputed Genomic DNA character array to the superclass to check if the sequence contains valid letters
	 * @param gdnaarr
	 * 	Genomic DNA sequence
	 */
  public GenomicDNASequence(char[] gdnaarr)
  {
	  super(gdnaarr);
  }

  /**
   * Extracts characters from the genomic sequence using the exons start and end positions
   * @param exonpos
   * 	Integer array used to specify the start and end positions of every coding exon in the genomic sequence
   * @return
   * 	Character array of genomic sequence that contains all the letters from the start and end positions of the exons
   */
  public char[] extractExons(int[] exonpos)
  {
	int preNum = 0;
    if(exonpos.length == 0 || exonpos.length % 2 == 1){
    	throw new IllegalArgumentException("Empty array or odd number of array elements");
    }
    for(int i = 0; i < exonpos.length; i++){
    	if(exonpos[i] < 0 || exonpos[i] >= super.seqLength()){
    		throw new IllegalArgumentException("Exon position is out of bound");
    	}
    	if(exonpos[i] >= preNum){
    		preNum = exonpos[i];
    	}else{
    		throw new IllegalArgumentException("Exon positions are not in order");
    	}
    } 
    char[] seq = super.getSeq();
    int charLength = 0;
    for(int i = 0; i < exonpos.length; i += 2){
    	charLength += (exonpos[i + 1] - exonpos[i]) + 1;
    }
    char[] exons = new char[charLength];
    int index = 0;
    for(int i = 0; i < exonpos.length - 1; i += 2){
    	int startIndex = exonpos[i];
    	int endIndex = exonpos[i + 1];
    	for(int j = startIndex; j <= endIndex; j++){
    		exons[index] = seq[j];
    		index++;
    	}
    }
    return exons;
  }

}
