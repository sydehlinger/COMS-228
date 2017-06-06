package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import org.junit.Test;

public class CodingDNASequenceTest {

	@Test
	public void checkStartCodon1() {
		char[] letters = {'A', 'c', 'G'};
		CodingDNASequence seq = new CodingDNASequence(letters);
		assertEquals(false, seq.checkStartCodon());
	}
	
	@Test
	public void checkStartCodon2() {
		char[] letters = {'A', 't', 'G'};
		CodingDNASequence seq = new CodingDNASequence(letters);
		assertEquals(true, seq.checkStartCodon());
	}
	
	@Test(expected = RuntimeException.class)
	public void translate(){
		char[] letters = {'A', 'c', 'G', 'A', 'G', 'A'};
		CodingDNASequence seq = new CodingDNASequence(letters);
		new String(seq.translate());
	}
	
	@Test
	public void translate1(){
		char[] letters = {'A', 't', 'G', 'A', 'G', 'A'};
		CodingDNASequence seq = new CodingDNASequence(letters);
		String s = new String(seq.translate());
		assertEquals("MR", s);
	}
	
	@Test
	public void translate2(){
		char[] letters = {'A', 't', 'G', 'A', 'G', 'A', 'T'};
		CodingDNASequence seq = new CodingDNASequence(letters);
		String s = new String(seq.translate());
		assertEquals("MR", s);
	}
	
	@Test
	public void translate3(){
		char[] letters = {'A', 't', 'G', 'A', 'G', 'A', 'T', 'c'};
		CodingDNASequence seq = new CodingDNASequence(letters);
		String s = new String(seq.translate());
		assertEquals("MR", s);
	}
	
	@Test
	public void translate4(){
		char[] letters = {'A', 't', 'G', 'A', 'G', 'A', 'T', 'c', 'G'};
		CodingDNASequence seq = new CodingDNASequence(letters);
		String s = new String(seq.translate());
		assertEquals("MRS", s);
	}

}
