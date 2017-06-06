package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProteinSequenceTest {

	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementExceptionb() {
		char[] letters = { 'a', 'C', 'b', 'D' };
		new ProteinSequence(letters);
	}

	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementExceptionB() {
		char[] letters = { 'c', 'B', 'q', 'P' };
		new ProteinSequence(letters);
	}

	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementExceptionj() {
		char[] letters = { 'C', 'j', 'D', 's' };
		new ProteinSequence(letters);
	}

	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementExceptionJ() {
		char[] letters = { 'C', 'd', 'J', 'q' };
		new ProteinSequence(letters);
	}

	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementExceptiono() {
		char[] letters = { 'o', 'd', 'D', 'C' };
		new ProteinSequence(letters);
	}

	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementExceptionO() {
		char[] letters = { 'C', 'd', 'D', 'O' };
		new ProteinSequence(letters);
	}

	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementExceptionu() {
		char[] letters = { 'C', 'u', 'D', 'Q' };
		new ProteinSequence(letters);
	}

	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementExceptionU() {
		char[] letters = { 'C', 'q', 'U', 'B' };
		new ProteinSequence(letters);
	}

	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementExceptionx() {
		char[] letters = { 'x', 's', 'e', 'Y' };
		new ProteinSequence(letters);
	}

	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementExceptionX() {
		char[] letters = { 'C', 'X', 'D', 'h' };
		new ProteinSequence(letters);
	}

	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementExceptionz() {
		char[] letters = { 'C', 'd', 'D', 'z' };
		new ProteinSequence(letters);
	}

	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementExceptionZ() {
		char[] letters = { 'C', 'd', 'Z', 'n' };
		new ProteinSequence(letters);
	}

	@Test
	public void isVaildLetter1() {
		char[] letters = { 'a', 'A', 'c', 'C', 'y', 'Y' };
		ProteinSequence seq = new ProteinSequence(letters);
		assertEquals(true, seq.isValidLetter(letters[0]));
	}

	@Test
	public void isVaildLetter2() {
		char[] letters = { 'a', 'A', 'c', 'C', 'y', 'Y' };
		ProteinSequence seq = new ProteinSequence(letters);
		assertEquals(true, seq.isValidLetter(letters[1]));
	}
	
	@Test
	public void isVaildLetter3() {
		char[] letters = { 'a', 'A', 'c', 'C', 'y', 'Y' };
		ProteinSequence seq = new ProteinSequence(letters);
		assertEquals(true, seq.isValidLetter(letters[2]));
	}
	
	@Test
	public void isVaildLetter4() {
		char[] letters = { 'a', 'A', 'c', 'C', 'y', 'Y' };
		ProteinSequence seq = new ProteinSequence(letters);
		assertEquals(true, seq.isValidLetter(letters[3]));
	}
	
	@Test
	public void isVaildLetter5() {
		char[] letters = { 'a', 'A', 'c', 'C', 'y', 'Y' };
		ProteinSequence seq = new ProteinSequence(letters);
		assertEquals(true, seq.isValidLetter(letters[4]));
	}
	
	@Test
	public void isVaildLetter6() {
		char[] letters = { 'a', 'A', 'c', 'C', 'y', 'Y' };
		ProteinSequence seq = new ProteinSequence(letters);
		assertEquals(true, seq.isValidLetter(letters[5]));
	}
}
