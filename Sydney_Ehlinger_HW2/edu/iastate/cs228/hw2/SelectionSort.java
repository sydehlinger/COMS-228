package edu.iastate.cs228.hw2;

/**
 * SelectionSort Class
 * @author Sydney Ehlinger
 */

import java.util.Comparator;

public class SelectionSort extends SorterWithStatistics {
	
	/**
	 * Performs selection sort on the given array using the given comparator
	 */
	@Override
	public void sortHelper(String[] words, Comparator<String> comp) {
		int n = words.length;
	    for (int i = 0; i < n - 1; i++){
	    	int minIndex = i;
	        for (int j = i + 1; j < n; j++){
	        	if (comp.compare(words[j], words[minIndex]) < 0)
	        		minIndex = j;
	        }
	        if (minIndex != i){
	        	String temp = words[i];
	            words[i] = words[minIndex];
	            words[minIndex] = temp;
	        }
	    }
	}
}
