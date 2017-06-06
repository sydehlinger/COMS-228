package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SequenceTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementException1() {
		char[] letters = {'a', 'B', ';'};
		new Sequence(letters);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementException2() {
		char[] letters = {'a', '*', 'c'};
		new Sequence(letters);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementException3() {
		char[] letters = {'$', 'B', 'c'};
		new Sequence(letters);
	}

	@Test
	public void isVaildLetter1() {
		char[] letters = {'a', 'B', 'c'};
		Sequence seq = new Sequence(letters);
		assertEquals(true, seq.isValidLetter(letters[0]));
	}
	
	@Test
	public void isVaildLetter2() {
		char[] letters = {'a', 'B', 'c'};
		Sequence seq = new Sequence(letters);
		assertEquals(true, seq.isValidLetter(letters[1]));
	}
	
	@Test
	public void isVaildLetter3() {
		char[] letters = {'a', 'B', 'c'};
		char[] letters2 = {'a', 'B', ';'};
		Sequence seq = new Sequence(letters);
		assertEquals(false, seq.isValidLetter(letters2[2]));
	}
	
	@Test
	public void seqLength1() {
		char[] letters = {'a', 'B', 'c'};
		Sequence seq = new Sequence(letters);
		assertEquals(3, seq.seqLength());
	}
	@Test
	public void seqLength2() {
		char[] letters = {'a', 'B', 'c', 'd'};
		Sequence seq = new Sequence(letters);
		assertEquals(4, seq.seqLength());
	}
	
	@Test
	public void seqLength3() {
		char[] letters = {'a', 'B'};
		Sequence seq = new Sequence(letters);
		assertEquals(2, seq.seqLength());
	}
	
	@Test
	public void getSeq1() {
		char[] letters = {'a', 'B', 'c'};
		Sequence seq = new Sequence(letters);
		assertEquals(true, Arrays.equals(letters, seq.getSeq()));
	}
	
	@Test
	public void getSeq2() {
		char[] letters = {'a', 'B', 'c', 'd'};
		Sequence seq = new Sequence(letters);
		assertEquals(true, Arrays.equals(letters, seq.getSeq()));
	}
	
	@Test
	public void getSeq3() {
		char[] letters = {'a', 'B'};
		Sequence seq = new Sequence(letters);
		assertEquals(true, Arrays.equals(letters, seq.getSeq()));
	}
	
	@Test
	public void equals1() {
		char[] letters = {'a', 'B'};
		char[] letters2 = {'a', 'B'};
		Sequence seq = new Sequence(letters);
		Sequence seq2 = new Sequence(letters2);
		assertEquals(true, seq.equals(seq2));
	}
	
	@Test
	public void equals2() {
		char[] letters = {'a', 'B', 'c'};
		char[] letters2 = {'a', 'B'};
		Sequence seq = new Sequence(letters);
		Sequence seq2 = new Sequence(letters2);
		assertEquals(false, seq.equals(seq2));
	}
	
	@Test
	public void equals3() {
		char[] letters = {'a', 'B', 'c'};
		char[] letters2 = {'a', 'b', 'c'};
		Sequence seq = new Sequence(letters);
		Sequence seq2 = new Sequence(letters2);
		assertEquals(true, seq.equals(seq2));
	}
	
	@Test
	public void toString1() {
		char[] letters = {'a', 'B', 'c'};
		Sequence seq = new Sequence(letters);
		assertEquals("aBc", seq.toString());
	}
	
	@Test
	public void toString2() {
		char[] letters = {'a', 'B'};
		Sequence seq = new Sequence(letters);
		assertEquals("aB", seq.toString());
	}
	
	@Test
	public void toString3() {
		char[] letters = {'a', 'B', 'c', 'D'};
		Sequence seq = new Sequence(letters);
		assertEquals("aBcD", seq.toString());
	}
}