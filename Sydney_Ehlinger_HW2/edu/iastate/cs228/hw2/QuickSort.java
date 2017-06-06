package edu.iastate.cs228.hw2;

/**
 * QuickSort Class
 * @author Sydney Ehlinger
 */

import java.util.Comparator;

public class QuickSort extends SorterWithStatistics {
	
	/**
	 * Performs a recursive quick sort on the given array using the given comparator
	 */
	@Override
	public void sortHelper(String[] words, Comparator<String> comp) {
		quickSortRec(words, 0, words.length - 1, comp);
	}
	
	/**
	 * Performs a recursive quick sort on the given array using the given comparator. Gets pivot from partition
	 * @param words
	 * 		given array
	 * @param first
	 * 		first index in array
	 * @param last
	 * 		last index in array
	 * @param comp
	 * 		given comparator
	 */
	public void quickSortRec(String[] words, int first, int last, Comparator<String> comp){
		if(first >= last){
			return;
		}
		int pivot = partition(words, first, last, comp);
        quickSortRec(words, first, pivot - 1, comp);
        quickSortRec(words, pivot + 1, last, comp);
	}
	
	/**
	 * Arranges array from least to greatest compared to the pivot
	 * @param words
	 * 		given array
	 * @param first
	 * 		first index in array
	 * @param last
	 * 		last index in array
	 * @param comp
	 * 		given comparator
	 * @return
	 * 		pivot value
	 */
	public int partition(String[] words, int first, int last, Comparator<String> comp){
        String pivot = words[first];
        int i = first + 1;
        int j = last;
        
        while(i <= j){
        	while(comp.compare(words[i], pivot) < 0){
        		i++;
        	}
        	while(comp.compare(words[j], pivot) > 0){
        		j--;
        	}
            if(i <= j){
        		String temp = words[i];
        		words[i] = words[j];
        		words[j] = temp;
        		i++;
        		j--;
        	}
        }
		String temp = words[first];
		words[first] = words[j];
		words[j] = temp;
        return j;
	}
}
