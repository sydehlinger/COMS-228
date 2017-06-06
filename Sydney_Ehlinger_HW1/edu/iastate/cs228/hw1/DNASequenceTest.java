package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import org.junit.Test;

public class DNASequenceTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementException1() {
		char[] letters = {'a', 'D', 'c', 'C'};
		new DNASequence(letters);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementException2() {
		char[] letters = {'a', 'D', 'c', 'Z'};
		new DNASequence(letters);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementException3() {
		char[] letters = {'K', 'D', 'c', 'C'};
		new DNASequence(letters);
	}

	@Test
	public void isVaildLetter1a() {
		char[] letters = {'a', 'A', 'c', 'C'};
		DNASequence seq = new DNASequence(letters);
		assertEquals(true, seq.isValidLetter(letters[0]));
	}
	
	@Test
	public void isVaildLetter1b() {
		char[] letters = {'a', 'A', 'c', 'C'};
		DNASequence seq = new DNASequence(letters);
		assertEquals(true, seq.isValidLetter(letters[1]));
	}
	
	@Test
	public void isVaildLetter1c() {
		char[] letters = {'a', 'A', 'c', 'C'};
		DNASequence seq = new DNASequence(letters);
		assertEquals(true, seq.isValidLetter(letters[2]));
	}
	
	@Test
	public void isVaildLetter1d() {
		char[] letters = {'a', 'A', 'c', 'C'};
		DNASequence seq = new DNASequence(letters);
		assertEquals(true, seq.isValidLetter(letters[3]));
	}

	@Test
	public void isVaildLetter2a() {
		char[] letters = {'g', 'G', 't', 'T'};
		DNASequence seq = new DNASequence(letters);
		assertEquals(true, seq.isValidLetter(letters[0]));
	}
	
	@Test
	public void isVaildLetter2b() {
		char[] letters = {'g', 'G', 't', 'T'};
		DNASequence seq = new DNASequence(letters);
		assertEquals(true, seq.isValidLetter(letters[1]));
	}
	
	@Test
	public void isVaildLetter2c() {
		char[] letters = {'g', 'G', 't', 'T'};
		DNASequence seq = new DNASequence(letters);
		assertEquals(true, seq.isValidLetter(letters[2]));
	}
	
	@Test
	public void isVaildLetter2d() {
		char[] letters = {'g', 'G', 't', 'T'};
		DNASequence seq = new DNASequence(letters);
		assertEquals(true, seq.isValidLetter(letters[3]));
	}
	

}
