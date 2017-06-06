package edu.iastate.cs228.hw2;

/**
 * MergeSort Class
 * @author Sydney Ehlinger
 */

import java.util.Comparator;

public class MergeSort extends SorterWithStatistics {
	
	/**
	 * Performs a recursive merge sort on the given array using the given comparator 
	 */
	@Override
	public void sortHelper(String[] words, Comparator<String> comp) {
	    if (words.length <= 1){
	      return;
	    }
	    
	    int mid = words.length / 2;
	    int secondLength = words.length - mid;
	    
	    String[] first = new String[mid];   
	    for (int i = 0; i < mid; ++i){
	      first[i] = words[i];
	    }
	    
	    String[] second = new String[secondLength];
	    for (int i = 0; i < secondLength; ++i){
	      second[i] = words[mid + i];
	    }
	    
	    sortHelper(first, comp);
	    sortHelper(second, comp);
	    
	    String [] result = merge(first, second, comp);
	    for(int i = 0; i < result.length; i++){
	    	words[i] = result[i];
	    }
	}
	
	/**
	 * Merges the two arrays together
	 * @param first
	 * 		first array
	 * @param second
	 * 		second array
	 * @param comp
	 * 		given comparator
	 * @return
	 * 		merged array
	 */
	public String[] merge(String[] first, String[] second, Comparator<String> comp){
		String[] result = new String[first.length + second.length];
		
		int i = 0;
		int j = 0;
		int index = 0;
		
		while(i < first.length && j < second.length){
			if(comp.compare(first[i], second[j]) < 0){
				result[index] = first[i];
				i++;
				index++;
			}else{
				result[index] = second[j];
				j++;
				index++;
			}
		}
		while(i < first.length){
			result[index] = first[i];
			i++;
			index++;
		}
		while(j < second.length){
			result[index] = second[j];
			j++;
			index++;
		}
		return result;
	}

}
