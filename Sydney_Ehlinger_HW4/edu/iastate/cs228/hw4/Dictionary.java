package edu.iastate.cs228.hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Dictionary {
    /**
     * An instance of a BinarySearchTree which stores this Dictionary's list of
     * words.
     */
	private BinarySearchTree<Entry> tree;

    /**
     * Constructs a new Dictionary which is empty.
     */
    public Dictionary() {
    	tree = new BinarySearchTree<Entry>();
    }

    /**
     * Constructs a new Dictionary whose word list is exactly (a deep copy
     * of) the list stored in the given tree. (For testing purposes, you can
     * set this Dictionary's BST to the given BST, rather clone it, but your
     * final method must do the deep copy)
     * 
     * @param tree
     *            - The tree of the existing word list
     */
    public Dictionary(BinarySearchTree<Entry> tree) {
    	this.tree = new BinarySearchTree<Entry>();
    	ArrayList<Entry> list = tree.getInorderTravseral();
    	for(int i = 0; i < list.size(); i++){
    		this.tree.add(list.get(i));
    	}
    }

    /**
     * Constructs a new Dictionary from the file specified by the given file
     * name. Each line of the file will contain at least one word with an
     * optional definition. Each line will have no leading or trailing
     * whitespace. For each line of the file, create a new Entry containing the
     * word and definition (if given) and add it to the BST.
     * 
     * @param filename
     *            - The file containing the wordlist
     * @throws FileNotFoundException
     *             - If the given file does not exist
     */
    public Dictionary(String filename) throws FileNotFoundException {
    	this.tree = new BinarySearchTree<Entry>();
    	File file = new File(filename);
        Scanner scan = new Scanner(file).useDelimiter(":");
        while(scan.hasNextLine()){
        	String word = scan.nextLine();
        	if(word.contains(":")){
        		String[] definition = word.split(":");
        		Entry entry = new Entry(definition[0], definition[1]);
        		tree.add(entry);
        	}else{
        		Entry entry = new Entry(word);
        		tree.add(entry);
        	}
        }
    }

    /**
     * Adds a new Entry to the Dictionary for the given word with no definition.
     * 
     * @param word
     *            - The word to add to the Dictionary
     * @return true only if the Entry was successfully added to the Dictionary,
     *         false otherwise.
     */
    public boolean addEntry(String word) {
        if(word == null || tree.contains(word)){
        	return false;
        }
        Entry entry = new Entry(word);
        tree.add(entry);
        return true;
    }

    /**
     * Adds a new Entry to the Dictionary for the given word and definition.
     * 
     * @param word
     *            - The word to add to the Dictionary
     * @param definition
     *            - The definition of the given word
     * @return true only if the Entry was successfully added to the Dictionary,
     *         false otherwise.
     */
    public boolean addEntry(String word, String definition) {
        if(word == null || tree.contains(word)){
        	return false;
        }
        Entry entry = new Entry(word, definition);
        tree.add(entry);
        return true;
    }

    /**
     * Tests whether or not word exists in this Dictionary.
     * 
     * @param word
     *            - The word to test.
     * @return true is word exists in this Dictionary, false otherwise.
     */
    public boolean hasWord(String word) {
    	if(findEntry(word) != null){
        	return true;
        }
        return false;
    }

    /**
     * Returns the definition of the given word in the Dictionary, if it is
     * there.
     * 
     * @param word
     *            - The word to retrieve the definition of.
     * @return the definition of the word.
     * @throws IllegalArgumentExeception
     *             - If word does not exist in the Dictionary.
     */
    public String getDefinitionOf(String word) throws IllegalArgumentException {
        if(findEntry(word) == null){
        	throw new IllegalArgumentException();
        }
        return findEntry(word).definition;
    }
    
    /**
     * Searches through the dictionary to find the Entry that contains the word
     * @param word
     * 	Word to find
     * @return
     * 	Entry containing word
     */
    private Entry findEntry(String word){
    	ArrayList<Entry> list = getSortedEntries();
    	for(int i = 0; i < list.size(); i++){
    		if(word.compareTo(list.get(i).word) == 0){
    			return list.get(i);
    		}
    	}
    	return null;
    }

    /**
     * Removes the given word from the word dictionary if it is there.
     * 
     * @param word
     *            - The word to remove from Dictionary.
     * @return true only if the word is successfully removed from the
     *         BinarySearchTree, false otherwise.
     */
    public boolean removeEntry(String word) {
        if(word == null || findEntry(word) == null){
        	return false;
        }
        Entry entry = new Entry(word);
        tree.remove(entry);
        return true;
    }

    /**
     * Changes the definition of given word if it is there.
     * 
     * @param word
     *            - The word to change the definition of
     * @param newDef
     *            - The new definition of the word
     * @return true if the definition was successfully updated, false otherwise.
     */
    public boolean updateEntry(String word, String newDef) {
        if(findEntry(word) != null){
        	findEntry(word).definition = newDef;
	        return true;
        }
        return false;
    }

    /**
     * Outputs this Dictionary to the given file. The file should be formatted
     * as follows: 1) One word and definition should appear per line separated
     * by exactly one space. 2) Lines should not have any leading or trailing
     * whitespace except for a single newline. 3) Each line of the file should
     * have text. There should be no empty lines. 4) The words should be sorted
     * alphabetically (i.e. using the BST's inorder traversal)
     * 
     * @param filename
     * @throws FileNotFoundException
     */
    public void printToFile(String filename) throws FileNotFoundException {
        File outFile = new File(filename);
        if(outFile.exists()){
	        PrintWriter out = new PrintWriter(outFile);
	        Iterator<Entry> iter = tree.iterator();
	        while(iter.hasNext()){
	          Entry entry = iter.next();
	          if(entry.definition == null){
	        	  out.println(entry.word);
	          }else{
	        	  out.println(entry.word + ":" + entry.definition);
	          }
	        }
	        out.close();
        }else{
        	throw new FileNotFoundException();
        }
    }

    /**
     * Returns the number of items stored in the Dictionary.
     */
    public int entryCount() {
        return tree.size();
    }

    /**
     * Returns a sorted list of Entries (as returned by an inorder traversal of
     * the BST)
     * 
     * @return an ArrayList of sorted Entries
     */
    public ArrayList<Entry> getSortedEntries() {
        return tree.getInorderTravseral();
    }

    /**
     * A Key-Value Pair class which represents an entry in a Dictionary.
     * 
     * @author
     */
    public static class Entry implements Comparable<Entry> {

        /**
         * Instance variables storing the word and definition of this Entry
         */
    	private String word;
    	
    	private String definition;

        /**
         * Constructs a new Entry with the given word with no definition
         * 
         * @param w
         *            - The word to create an entry for.
         */
        public Entry(String w) {
            word = w;
            definition = null;
        }

        /**
         * Constructs a new Entry with the given word and definition
         * 
         * @param w
         *            - The word to create an entry for.
         * @param d
         *            - The definition of the given word.
         */
        public Entry(String w, String d) {
            word = w;
            definition = d;
        }

        /**
         * Compares the word contained in this entry to the word in other.
         * Returns a value < 0 if the word in this Entry is alphabetically
         * before the other word, = 0 if the words are the same, and > 0
         * otherwise.
         */
        @Override
        public int compareTo(Entry other) {
        	if(this.word.equals(other.word)){
        		return 0;
        	}
        	String minWord = "";
        	if(this.word.length() >= other.word.length()){
        		minWord = other.word;
        	}else if(this.word.length() < other.word.length()){
        		minWord = this.word;
        	}else{
        		minWord = this.word;
        	}
        	for(int i = 0; i < minWord.length(); i++){
        		if(this.word.charAt(i) != other.word.charAt(i)){
        			if(this.word.charAt(i) > other.word.charAt(i)){
        				return 1;
        			}else{
        				return -1;
        			}
        		}
        	}
            if(this.word == minWord){
            	return 1;
            }else{
            	return -1;
            }
        }

        /**
         * Tests for equality of this Entry with the given Object. Two entries
         * are considered equal if the words they contain are equal regardless
         * of their definitions.
         */
        @Override
        public boolean equals(Object o) {
        	if(o == null || o.getClass() != this.getClass()){
        		return false;
        	}	
        	Entry entry = (Entry) o;
        	if(this.word == entry.word){
        		return true;
        	}
        	if(this.word.length() == entry.word.length()){
        		for(int i = 0; i < this.word.length(); i++){
        			if(this.word.charAt(i) != entry.word.length()){
        				return false;
        			}
        		}
        		return true;
        	}
            return false;
        }
    }
}