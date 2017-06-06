package edu.iastate.cs228.hw2;

/**
 * Main Class
 * @author Sydney Ehlinger
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws FileNotFoundException, FileConfigurationException {
		
		CustomComparator tenAlphabet = new CustomComparator(readCharacterOrdering("10.alphabet.txt"));
		CustomComparator hundredAlphabet = new CustomComparator(readCharacterOrdering("100.alphabet.txt"));
		CustomComparator thousandAlphabet = new CustomComparator(readCharacterOrdering("1000.alphabet.txt"));
		CustomComparator tenThousandAlphabet = new CustomComparator(readCharacterOrdering("10000.alphabet.txt"));
		CustomComparator hundredThousandAlphabet = new CustomComparator(readCharacterOrdering("100000.alphabet.txt"));
		CustomComparator millonAlphabet = new CustomComparator(readCharacterOrdering("1000000.alphabet.txt"));

		System.out.println("Sort Type" + "        " + "Length of Word List" + "        " + "Number of Words Sorted" + "        " + "Total Time Sorting (in Seconds)" + "        " + "Averge Time to Sort (in Seconds)" + "         " + "Words Sorted per Second");
		
		//ten
			//QuickSort
			QuickSort qsTen = new QuickSort();
			qsTen.sort(readWordsFile("10.wordlist.txt", tenAlphabet), tenAlphabet);
			qsTen.sort(readWordsFile("10.wordlist.txt", tenAlphabet), tenAlphabet);
			qsTen.sort(readWordsFile("10.wordlist.txt", tenAlphabet), tenAlphabet);
			System.out.println("Quick Sort" + "              " + qsTen.getWordsSorted() + "                           " + qsTen.getTotalWordsSorted() + "                            " + qsTen.getTotalTimeToSortWords()/1000000000.0 + "                              " + (qsTen.getTotalTimeToSortWords()/3)/1000000000.0 + "                         " + qsTen.getTotalWordsSorted()/(qsTen.getTotalTimeToSortWords()/1000000000.0));
			//MergeSort
			MergeSort msTen = new MergeSort();
			msTen.sort(readWordsFile("10.wordlist.txt", tenAlphabet), tenAlphabet);
			msTen.sort(readWordsFile("10.wordlist.txt", tenAlphabet), tenAlphabet);
			msTen.sort(readWordsFile("10.wordlist.txt", tenAlphabet), tenAlphabet);
			System.out.println("Merge Sort" + "              " + msTen.getWordsSorted() + "                           " + msTen.getTotalWordsSorted() + "                            " + msTen.getTotalTimeToSortWords()/1000000000.0 + "                              " + (msTen.getTotalTimeToSortWords()/3)/1000000000.0 + "                         " + msTen.getWordsSorted()/(msTen.getTimeToSortWords()/1000000000.0));
			//SelectionSort
			SelectionSort ssTen = new SelectionSort();
			ssTen.sort(readWordsFile("10.wordlist.txt", tenAlphabet), tenAlphabet);
			ssTen.sort(readWordsFile("10.wordlist.txt", tenAlphabet), tenAlphabet);
			ssTen.sort(readWordsFile("10.wordlist.txt", tenAlphabet), tenAlphabet);
			System.out.println("Selection Sort" + "          " + ssTen.getWordsSorted() + "                           " + ssTen.getTotalWordsSorted() + "                            " + ssTen.getTotalTimeToSortWords()/1000000000.0 + "                              " + (ssTen.getTotalTimeToSortWords()/3)/1000000000.0 + "                         " + ssTen.getWordsSorted()/(ssTen.getTimeToSortWords()/1000000000.0));
		
		System.out.println();
		
		//hundred
			//QuickSort
			QuickSort qsHundred = new QuickSort();
			qsHundred.sort(readWordsFile("100.wordlist.txt", hundredAlphabet), hundredAlphabet);
			qsHundred.sort(readWordsFile("100.wordlist.txt", hundredAlphabet), hundredAlphabet);
			qsHundred.sort(readWordsFile("100.wordlist.txt", hundredAlphabet), hundredAlphabet);
			System.out.println("Quick Sort" + "              " + qsHundred.getWordsSorted() + "                          " + qsHundred.getTotalWordsSorted() + "                           " + qsHundred.getTotalTimeToSortWords()/1000000000.0 + "                             " + (qsHundred.getTotalTimeToSortWords()/3)/1000000000.0 + "                         " + qsHundred.getWordsSorted()/(qsHundred.getTimeToSortWords()/1000000000.0));
			//MergeSort
			MergeSort msHundred = new MergeSort();
			msHundred.sort(readWordsFile("100.wordlist.txt", hundredAlphabet), hundredAlphabet);
			msHundred.sort(readWordsFile("100.wordlist.txt", hundredAlphabet), hundredAlphabet);
			msHundred.sort(readWordsFile("100.wordlist.txt", hundredAlphabet), hundredAlphabet);
			System.out.println("Merge Sort" + "              " + msHundred.getWordsSorted() + "                          " + msHundred.getTotalWordsSorted() + "                           " + msHundred.getTotalTimeToSortWords()/1000000000.0 + "                             " + (msHundred.getTotalTimeToSortWords()/3)/1000000000.0 + "                         " + msHundred.getWordsSorted()/(msHundred.getTimeToSortWords()/1000000000.0));
			//SelectionSort
			SelectionSort ssHundred = new SelectionSort();
			ssHundred.sort(readWordsFile("100.wordlist.txt", hundredAlphabet), hundredAlphabet);
			ssHundred.sort(readWordsFile("100.wordlist.txt", hundredAlphabet), hundredAlphabet);
			ssHundred.sort(readWordsFile("100.wordlist.txt", hundredAlphabet), hundredAlphabet);
			System.out.println("Selection Sort" + "          " + ssHundred.getWordsSorted() + "                          " + ssHundred.getTotalWordsSorted() + "                           " + ssHundred.getTotalTimeToSortWords()/1000000000.0 + "                             " + (ssHundred.getTotalTimeToSortWords()/3)/1000000000.0 + "                         " + ssHundred.getWordsSorted()/(ssHundred.getTimeToSortWords()/1000000000.0));
		
		System.out.println();
			
		//thousand
			//QuickSort
			QuickSort qsThousand = new QuickSort();
			qsThousand.sort(readWordsFile("1000.wordlist.txt", thousandAlphabet), thousandAlphabet);
			qsThousand.sort(readWordsFile("1000.wordlist.txt", thousandAlphabet), thousandAlphabet);
			qsThousand.sort(readWordsFile("1000.wordlist.txt", thousandAlphabet), thousandAlphabet);
			System.out.println("Quick Sort" + "              " + qsThousand.getWordsSorted() + "                         " + qsThousand.getTotalWordsSorted() + "                          " + qsThousand.getTotalTimeToSortWords()/1000000000.0 + "                             " + (qsThousand.getTotalTimeToSortWords()/3)/1000000000.0 + "                       " + qsThousand.getWordsSorted()/(qsThousand.getTimeToSortWords()/1000000000.0));
			//MergeSort
			MergeSort msThousand = new MergeSort();
			msThousand.sort(readWordsFile("1000.wordlist.txt", thousandAlphabet), thousandAlphabet);
			msThousand.sort(readWordsFile("1000.wordlist.txt", thousandAlphabet), thousandAlphabet);
			msThousand.sort(readWordsFile("1000.wordlist.txt", thousandAlphabet), thousandAlphabet);
			System.out.println("Merge Sort" + "              " + msThousand.getWordsSorted() + "                         " + msThousand.getTotalWordsSorted() + "                          " + msThousand.getTotalTimeToSortWords()/1000000000.0 + "                             " + (msThousand.getTotalTimeToSortWords()/3)/1000000000.0 + "                       " + msThousand.getWordsSorted()/(msThousand.getTimeToSortWords()/1000000000.0));
			//SelectionSort
			SelectionSort ssThousand = new SelectionSort();
			ssThousand.sort(readWordsFile("1000.wordlist.txt", thousandAlphabet), thousandAlphabet);
			ssThousand.sort(readWordsFile("1000.wordlist.txt", thousandAlphabet), thousandAlphabet);
			ssThousand.sort(readWordsFile("1000.wordlist.txt", thousandAlphabet), thousandAlphabet);
			System.out.println("Selection Sort" + "          " + ssThousand.getWordsSorted() + "                         " + ssThousand.getTotalWordsSorted() + "                          " + ssThousand.getTotalTimeToSortWords()/1000000000.0 + "                            " + (ssThousand.getTotalTimeToSortWords()/3)/1000000000.0 + "                       " + ssThousand.getWordsSorted()/(ssThousand.getTimeToSortWords()/1000000000.0));
		
		System.out.println();
		
		//ten thousand
			//QuickSort
			QuickSort qsTenThousand = new QuickSort();
			qsTenThousand.sort(readWordsFile("10000.wordlist.txt", tenThousandAlphabet), tenThousandAlphabet);
			qsTenThousand.sort(readWordsFile("10000.wordlist.txt", tenThousandAlphabet), tenThousandAlphabet);
			qsTenThousand.sort(readWordsFile("10000.wordlist.txt", tenThousandAlphabet), tenThousandAlphabet);
			System.out.println("Quick Sort" + "              " + qsTenThousand.getWordsSorted() + "                        " + qsTenThousand.getTotalWordsSorted() + "                         " + qsTenThousand.getTotalTimeToSortWords()/1000000000.0 + "                             " + (qsTenThousand.getTotalTimeToSortWords()/3)/1000000000.0 + "                       " + qsTenThousand.getWordsSorted()/(qsTenThousand.getTimeToSortWords()/1000000000.0));
			//MergeSort
			MergeSort msTenThousand = new MergeSort();
			msTenThousand.sort(readWordsFile("10000.wordlist.txt", tenThousandAlphabet), tenThousandAlphabet);
			msTenThousand.sort(readWordsFile("10000.wordlist.txt", tenThousandAlphabet), tenThousandAlphabet);
			msTenThousand.sort(readWordsFile("10000.wordlist.txt", tenThousandAlphabet), tenThousandAlphabet);
			System.out.println("Merge Sort" + "              " + msTenThousand.getWordsSorted() + "                        " + msTenThousand.getTotalWordsSorted() + "                         " + msTenThousand.getTotalTimeToSortWords()/1000000000.0 + "                             " + (msTenThousand.getTotalTimeToSortWords()/3)/1000000000.0 + "                       " + msTenThousand.getTotalWordsSorted()/(msTenThousand.getTotalTimeToSortWords()/1000000000.0));
			//SelectionSort
			SelectionSort ssTenThousand = new SelectionSort();
			ssTenThousand.sort(readWordsFile("10000.wordlist.txt", tenThousandAlphabet), tenThousandAlphabet);
			ssTenThousand.sort(readWordsFile("10000.wordlist.txt", tenThousandAlphabet), tenThousandAlphabet);
			ssTenThousand.sort(readWordsFile("10000.wordlist.txt", tenThousandAlphabet), tenThousandAlphabet);
			System.out.println("Selection Sort" + "          " + ssTenThousand.getWordsSorted() + "                        " + ssTenThousand.getTotalWordsSorted() + "                         " + ssTenThousand.getTotalTimeToSortWords()/1000000000.0 + "                             " + (ssTenThousand.getTotalTimeToSortWords()/3)/1000000000.0 + "                       " + ssTenThousand.getWordsSorted()/(ssTenThousand.getTimeToSortWords()/1000000000.0));
		
		System.out.println();
		
		//hundred thousand
			//QuickSort
			QuickSort qsHundredThousand = new QuickSort();
			qsHundredThousand.sort(readWordsFile("100000.wordlist.txt", hundredThousandAlphabet), hundredThousandAlphabet);
			qsHundredThousand.sort(readWordsFile("100000.wordlist.txt", hundredThousandAlphabet), hundredThousandAlphabet);
			qsHundredThousand.sort(readWordsFile("100000.wordlist.txt", hundredThousandAlphabet), hundredThousandAlphabet);
			System.out.println("Quick Sort" + "              " + qsHundredThousand.getWordsSorted() + "                       " + qsHundredThousand.getTotalWordsSorted() + "                        " + qsHundredThousand.getTotalTimeToSortWords()/1000000000.0 + "                             " + (qsHundredThousand.getTotalTimeToSortWords()/3)/1000000000.0 + "                         " + qsHundredThousand.getWordsSorted()/(qsHundredThousand.getTimeToSortWords()/1000000000.0));
			//MergeSort
			MergeSort msHundredThousand = new MergeSort();
			msHundredThousand.sort(readWordsFile("100000.wordlist.txt", hundredThousandAlphabet), hundredThousandAlphabet);
			msHundredThousand.sort(readWordsFile("100000.wordlist.txt", hundredThousandAlphabet), hundredThousandAlphabet);
			msHundredThousand.sort(readWordsFile("100000.wordlist.txt", hundredThousandAlphabet), hundredThousandAlphabet);
			System.out.println("Merge Sort" + "              " + msHundredThousand.getWordsSorted() + "                       " + msHundredThousand.getTotalWordsSorted() + "                        " + msHundredThousand.getTotalTimeToSortWords()/1000000000.0 + "                             " + (msHundredThousand.getTotalTimeToSortWords()/3)/1000000000.0 + "                         " + msHundredThousand.getWordsSorted()/(msHundredThousand.getTimeToSortWords()/1000000000.0));
			//SelectionSort
			System.out.println("Selection Sort          ------                       ------                        -----------                             -----------                         ------------------");
			
		System.out.println();
		
		//millon
			//QuickSort
			QuickSort qsMillon = new QuickSort();
			qsMillon.sort(readWordsFile("1000000.wordlist.txt", millonAlphabet), millonAlphabet);
			qsMillon.sort(readWordsFile("1000000.wordlist.txt", millonAlphabet), millonAlphabet);
			qsMillon.sort(readWordsFile("1000000.wordlist.txt", millonAlphabet), millonAlphabet);
			System.out.println("Quick Sort" + "              " + qsMillon.getWordsSorted() + "                      " + qsMillon.getTotalWordsSorted() + "                       " + qsMillon.getTotalTimeToSortWords()/1000000000.0 + "                            " + (qsMillon.getTotalTimeToSortWords()/3)/1000000000.0 + "                         " + qsMillon.getWordsSorted()/(qsMillon.getTimeToSortWords()/1000000000.0));
			//MergeSort
			MergeSort msMillon = new MergeSort();
			msMillon.sort(readWordsFile("1000000.wordlist.txt", millonAlphabet), millonAlphabet);
			msMillon.sort(readWordsFile("1000000.wordlist.txt", millonAlphabet), millonAlphabet);
			msMillon.sort(readWordsFile("1000000.wordlist.txt", millonAlphabet), millonAlphabet);
			System.out.println("Merge Sort" + "              " + msMillon.getWordsSorted() + "                      " + msMillon.getTotalWordsSorted() + "                       " + msMillon.getTotalTimeToSortWords()/1000000000.0 + "                            " + (msMillon.getTotalTimeToSortWords()/3)/1000000000.0 + "                         " + msMillon.getWordsSorted()/(msMillon.getTimeToSortWords()/1000000000.0));
			//SelectionSort
			System.out.println("Selection Sort          -------                      -------                        -----------                              -----------                         ------------------");
	}
	
	/**
	 * Reads the characters contained in filename (the input alphabet) and returns them as a character array.
	 * @param filename the file containing the list of characters
	 * @returns an char array representing the ordering of characters to be used 
	 *          or null if there is an exception.
         * FileNotFoundException is thrown when filename is does not exist.
         * FileConfigurationException is thrown when any line of the input file is repeated or when any line contains other than exactly 1 byte before the terminating newline.
	 */
	public static char[] readCharacterOrdering(String filename) 
			throws FileNotFoundException, FileConfigurationException {
		File file = new File(filename);
		try{
		Scanner countLines = new Scanner(file);
		int lines = 0;
		while(countLines.hasNextLine()){
			lines++;
			countLines.nextLine();
		}
		countLines.close();
		char[] characterOrdering = new char[lines - 1];
		int index = 0;
		Scanner scan = new Scanner(file);
		while(index < lines - 1){
			characterOrdering[index] = scan.next().charAt(0);
			index++;
		}
		scan.close();
		return characterOrdering;
		}catch(FileNotFoundException e){
			System.out.println("File Not Found");
			return null;
		}
	}
	
	/**
	 * Reads the words from the file and returns them as a String array.
	 * @param filename file containing words
	 * @return the words contained in the file or null if there was an exception.
         * FileNotFoundException is thrown when filename is does not exist.
         * FileConfigurationException is thrown when the file contains any characters that didn't first appear in the input alphabet.
	 */
	public static String[] readWordsFile(String filename, CustomComparator comp)
			throws FileNotFoundException, FileConfigurationException {
		File file = new File(filename);
		Scanner countLines = new Scanner(file);
		try{
		int lines = 0;
		while(countLines.hasNextLine()){
			lines++;
			countLines.nextLine();
		}
		countLines.close();
		String[] characterOrdering = new String[lines];
		int index = 0;
		Scanner scan = new Scanner(file);
		while(index < lines){
			characterOrdering[index] = scan.next();
			if(isValid(characterOrdering[index], comp)){
				index++;
			}else{
				throw new FileConfigurationException();
			}
		}
		scan.close();
		return characterOrdering;
		}catch(FileNotFoundException e){
			System.out.println("File Not Found");
			return null;
		}
	}
	
	/**
	 * Returns whether or not word is valid.
	 * @param word word to be checked.
	 * @param comparator comparator used to check if characters are valid.
	 * @return true if every character in the word is in the input alphabet, else false.
	 */
	public static boolean isValid(String word, CustomComparator comparator) {
          for(int i = 0; i < word.length(); i++){
        	  if(comparator.getCharacterOrdering(word.charAt(i)) != -1){
        		  return true;
        	  }
          }
          return false;
	}
	
	private static class FileConfigurationException extends Exception {
	}
}
