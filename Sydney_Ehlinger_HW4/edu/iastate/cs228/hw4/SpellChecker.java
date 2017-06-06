package edu.iastate.cs228.hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SpellChecker {

    /**
     * Displays usage information.
     *
     * There's no reason that you should need to modify this.
     */
    private static void doUsage() {
        System.out.println("Usage: SpellChecker [-i] <dictionary> <document>\n"
                         + "                    -d <dictionary>\n"
                         + "                    -h");
    }

    /**
     * Displays detailed usage information and exits.
     *
     * There's no reason that you should need to modify this.
     */
    private static void doHelp() {
        doUsage();
        System.out.println("\n"                                                                                +
                           "When passed a dictionary and a document, spell check the document.  Optionally,\n" +
                           "the switch -n toggles non-interactive mode; by default, the tool operates in\n"   +
                           "interactive mode.  Interactive mode will write the corrected document to disk,\n"  +
                           "backing up the uncorrected document by concatenating a tilde onto its name.\n\n"   +
                           "The optional -d switch with a dictionary parameter enters dictionary edit mode.\n" +
                           "Dictionary edit mode allows the user to query and update a dictionary.  Upon\n"    +
                           "completion, the updated dictionary is written to disk, while the original is\n"    +
                           "backed up by concatenating a tilde onto its name.\n\n"                             +
                           "The switch -h displays this help and exits.");
        System.exit(0);
    }

    /**
     * Runs the three modes of the SpellChecker based on the input arguments. DO
     * NOT change this method in any way other than to set the name and sect
     * variables.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            doUsage();
            System.exit(-1);
        }

        /* In order to be considered for the competition, set these variables. */
        String name = "Sydney Ehlinger"; // First and Last
        String sect = "B"; // "A" or "B"

        Timer timer = new Timer();

        timer.start();

        if (args[0].equals("-h"))
            doHelp();
        else if (args[0].equals("-n"))
            doNonInteractiveMode(args);
        else if (args[0].equals("-d"))
            doDictionaryEditMode(args);
        else
            doInteractiveMode(args);

        timer.stop();

        System.out.println("Student name:   " + name);
        System.out.println("Student sect:   " + sect);
        System.out.println("Execution time: " + timer.runtime() + " ms");
    }

    /**
     * Carries out the Interactive mode of the Spell Checker.
     * 
     * @param args
     *            the arguments given to the main. The correct number of
     *            arguments may or may not be contained in it.
     *            Call doUsage() and exit if the parameter count is incorrect.
     */
    public static void doInteractiveMode(String[] args) {
    	try{
	    	if(args.length != 3){
	    		doUsage();
	    		System.exit(-1);
	    	}
	    	File originalDic = new File(args[1]);
	    	Dictionary dict = new Dictionary(args[1]);
	    	File document = new File(args[2]);
	    	Scanner fileScanner = new Scanner(document);
	    	Scanner user = new Scanner(System.in);
	    	doNonInteractiveMode(args);
	    	while(fileScanner.hasNextLine()){
	    		String line = fileScanner.nextLine().toLowerCase();
		    	Scanner lineScanner = new Scanner(line);
		    	while(lineScanner.hasNext()){
		    		String word = lineScanner.next().toLowerCase();
		    		if(!dict.hasWord(word)){
		    			System.out.println(word + ": [r]eplace/[a]ccept?");
		    			String answer = user.next().toLowerCase();
		    			if(answer.equals("r")){
		    				System.out.println("Replacement text: ");
		    				String replace = user.next();
		    				String replacedLine = line.replaceAll(word, replace);
		    				doNonInteractiveMode(args);
		    			}else if(answer.equals("a")){
		    				dict.addEntry(word);
		    				dict.printToFile(args[1]);
		    				doNonInteractiveMode(args);
		    			}
		    		}
		    	}
		    	lineScanner.close();
	    	}
	    	fileScanner.close();
	    	PrintWriter out = new PrintWriter(originalDic + "~");
			dict.printToFile(args[1]);
			System.out.println("Wrote " + args[1] + ". Original backed up to " + args[1] + "~");
			out.close();
    	}catch(FileNotFoundException e){
    		System.out.println("**Not A Valid File**");
    	}
    }

    /**
     * Carries out the Non-Interactive mode of the Spell Checker.
     * 
     * @param args
     *            the arguments given to the main. The correct number of
     *            arguments may or may not be contained in it.
     *            Call doUsage() and exit if the parameter count is incorrect.
     */
    public static void doNonInteractiveMode(String[] args) {
    	try{
	    	if(args.length != 3){
	    		doUsage();
	    		System.exit(-1);
	    	}
	    	Dictionary dict = new Dictionary(args[1]);
	    	File document = new File(args[2]);
	    	Scanner fileScanner = new Scanner(document);
	    	while(fileScanner.hasNextLine()){
		    	int count = 0;
		    	int correct = 0;
		    	ArrayList<Integer> list = new ArrayList<>();
	    		String line = fileScanner.nextLine();
		    	Scanner lineScanner = new Scanner(line);
		    	while(lineScanner.hasNext()){
		    		String word = lineScanner.next().toLowerCase();
		    		if(!dict.hasWord(word)){
		    			list.add(count);
		    			count = -1;
		    			correct = -1;
		    		}
		    		count += word.length() + 1;
		    	}
		    	lineScanner.close();
	    		System.out.println(line);
	    		if(correct != 0){
		    		String spaces = "";
		    		for(int i = 0; i < list.size(); i++){
		    			for(int j = 0; j < list.get(i); j++){
			    			spaces += " ";
		    			}
		    			spaces += "^";
		    		}
		    		System.out.println(spaces);
	    		}
	    	}
	    	fileScanner.close();
    	}catch(FileNotFoundException e){
    		System.out.println("**Not A Valid File**");
    	}
    }

    /**
     * Carries out the Dictionary Edit mode of the Spell Checker.
     * 
     * @param args
     *            the arguments given to the main. The correct number of
     *            arguments may or may not be contained in it.
     *            Call doUsage() and exit if the parameter count is incorrect.
     */
    public static void doDictionaryEditMode(String[] args) {
    	try{
    	System.out.println("DictionaryEdit");
	    	if(args.length < 2){
	    		doUsage();
	    		System.exit(-1);
	    	}
	    	File originalDic = new File(args[1]);
	    	Dictionary dict = new Dictionary(args[1]);
	    	dict.printToFile(args[1]);
	    	Scanner user = new Scanner(System.in);
		    System.out.println("Editing " + args[1]);
			while(true){
				boolean invalid = false;
				System.out.println("Word:");
				String answer = user.next().toLowerCase();
				if(answer.equals("!quit")){
			    	PrintWriter out = new PrintWriter(originalDic + "~");
					dict.printToFile(args[1]);
					System.out.println("Wrote " + args[1] + ". Original backed up to " + args[1] + "~");
					out.close();
					return;
				}
				for(int i = 0; i < answer.length(); i++){
					char let = answer.charAt(i);
					if(!Character.isLetter(let) && let != '-' && let != '\''){
						invalid = true;
						System.out.println("'" + answer + "'" + " is invalid. Please enter a valid word.");
					}
				}
				if(!invalid){
					if(dict.hasWord(answer)){
					    System.out.println("'" + answer + "'" + " was found.");
					    System.out.println("[r]emove/[g]et definition/[c]hange definition/do [n]othing: ");
					    String answer2 = user.next().toLowerCase();
					    if(answer2.equals("r")){
					    	dict.removeEntry(answer);
					    }else if(answer2.equals("g")){
					    	String def = dict.getDefinitionOf(answer);
					    	if(def == null){
					    		System.out.println("<undefined>");
					    	}else{
					    		System.out.println(def);
					    	}
					    }else if(answer2.equals("c")){
					    	Scanner def = new Scanner(System.in);
					    	System.out.println("Definition: ");
					    	String newDef = def.nextLine();
					    	dict.updateEntry(answer, newDef);
					    }else if(answer2.equals("n")){	
					    }
					}else{
					    System.out.println("'" + answer + "'" + " not found.");
					    System.out.println("[a]dd/add with [d]efinition/do [n]othing: ");
					    String answer3 = user.next().toLowerCase();
					    if(answer3.equals("a")){
					    	dict.addEntry(answer);
					    }else if(answer3.equals("d")){
					    	Scanner def2 = new Scanner(System.in);
					    	System.out.println("Definition: ");
					    	String addedDef = def2.nextLine();
					    	dict.addEntry(answer, addedDef);
					    }if(answer3.equals("n")){
					    }
					}
				}
			}
    	}catch(FileNotFoundException e){
    		System.out.println("**Not A Valid File**");
    	}
    }

    /**
     * Timer class used for this project's competition. DO NOT modify this class
     * in any way or you will be ineligible for Eternal Glory.
     */
    private static class Timer {
        private long startTime;
        private long endTime;

        public void start() {
            startTime = System.nanoTime();
        }

        public void stop() {
            endTime = System.nanoTime();
        }

        public long runtime() {
            return endTime - startTime;
        }
    }
}
