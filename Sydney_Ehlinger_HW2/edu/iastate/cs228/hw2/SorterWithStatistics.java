package edu.iastate.cs228.hw2;

/**
 * SorterWithStatistics Class
 * @author Sydney Ehlinger
 */

import java.util.Comparator;

public abstract class SorterWithStatistics implements Sorter {
	/**
	 * Private instance of timer
	 */
	private Stopwatch timer = new Stopwatch();
	
	/**
	 * Stores the previous time it took to sort
	 */
	private long pastSortTime;
	
	/**
	 * Stores the total time it took to sort
	 */
	private long totalSortTime;
	
	/**
	 * Stores the words sorted
	 */
	private int wordsSorted;
	
	/**
	 * Stores the total words sorted
	 */
	private int totalWordsSorted;
	
        /***
         * Default constructor
         */
	public SorterWithStatistics() {
	}

        /***
         * Public interface to sortHelper that keeps track of performance
         * statistics, including counting words sorted and timing sort
         * instances.
	 * @param words input array to be sorted.
	 * @param comp Comparator used to sort the input array.
         */
	public void sort(String[] words, Comparator<String> comp) {
          timer.start();
          sortHelper(words, comp);
          timer.stop();
          pastSortTime = timer.getElapsedTime();
          totalSortTime += pastSortTime;
          wordsSorted = words.length;
          totalWordsSorted += wordsSorted;
	}
	
	/**
	 * Sorts the array words.
	 * @param words input array to be sorted.
	 * @param comp Comparator used to sort the input array.
	 */
	protected abstract void sortHelper(String[] words, Comparator<String> comp);

	/**
	 * Returns number of words sorted in last sort.  Throws IllegalStateException if nothing has been sorted.
	 * @return number of words sorted in last sort.
	 */
	public int getWordsSorted() {
          return wordsSorted;
	}
	
	/**
	 * Returns time the last sort took.  Throws IllegalStateException if nothing has been sorted.
	 * @return time last sort took.
	 */
	public long getTimeToSortWords() {
		if(pastSortTime == 0){
			throw new IllegalStateException("Nothing has been sorted yet");
		}
		return pastSortTime;
	}
	
	/**
	 * Returns total words sorted by this instance.
	 * @return total number of words sorted.
	 */
	public int getTotalWordsSorted() {
          return totalWordsSorted;
	}
	
	/**
	 * Returns the total amount of time spent sorting by this instance.
	 * @return total time spent sorting.
	 */
	public long getTotalTimeToSortWords() {
		return totalSortTime;
	}
}