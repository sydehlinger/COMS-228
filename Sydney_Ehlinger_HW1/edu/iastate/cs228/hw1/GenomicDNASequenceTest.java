package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import org.junit.Test;

public class GenomicDNASequenceTest {

	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementExceptionNoExons() {
		char[] letters = {'A', 'C', 'C', 'G', 'T', 'A', 'G', 'C', 'G', 'T', 'A', 'C', 'G', 'T', 'A', 'C', 'G', 'T'};
		int[] nums = {};
		GenomicDNASequence seq = new GenomicDNASequence(letters);
		new String(seq.extractExons(nums));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementExceptionOddNumOfExons() {
		char[] letters = {'A', 'C', 'C', 'G', 'T', 'A', 'G', 'C', 'G', 'T', 'A', 'C', 'G', 'T', 'A', 'C', 'G', 'T'};
		int[] nums = {0, 2, 5};
		GenomicDNASequence seq = new GenomicDNASequence(letters);
		new String(seq.extractExons(nums));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementExceptionLessThan0() {
		char[] letters = {'A', 'C', 'C', 'G', 'T', 'A', 'G', 'C', 'G', 'T', 'A', 'C', 'G', 'T', 'A', 'C', 'G', 'T'};
		int[] nums = {-2, 0, 2, 5};
		GenomicDNASequence seq = new GenomicDNASequence(letters);
		new String(seq.extractExons(nums));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementExceptionGreaterThanLength() {
		char[] letters = {'A', 'C', 'C', 'G', 'T', 'A', 'G', 'C', 'G', 'T', 'A', 'C', 'G', 'T', 'A', 'C', 'G', 'T'};
		int[] nums = {-2, 0, 2, 20};
		GenomicDNASequence seq = new GenomicDNASequence(letters);
		new String(seq.extractExons(nums));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void IllegalArguementExceptionOutOfOrder() {
		char[] letters = {'A', 'C', 'C', 'G', 'T', 'A', 'G', 'C', 'G', 'T', 'A', 'C', 'G', 'T', 'A', 'C', 'G', 'T'};
		int[] nums = {0, 2, 5, 3};
		GenomicDNASequence seq = new GenomicDNASequence(letters);
		new String(seq.extractExons(nums));
	}

	@Test
	public void extractExons1() {
		char[] letters = {'A', 'C', 'C', 'G', 'T', 'A', 'G', 'C', 'G', 'T', 'A', 'C', 'G', 'T', 'A', 'C', 'G', 'T'};
		int[] nums = {0, 2, 6, 9, 12, 15};
		GenomicDNASequence seq = new GenomicDNASequence(letters);
		String s = new String(seq.extractExons(nums));
		assertEquals("ACCGCGTGTAC", s);
	}
	
	@Test
	public void extractExons2() {
		char[] letters = {'A', 'C', 'C', 'G', 'T', 'A', 'G', 'C', 'G', 'T', 'A', 'C', 'G', 'T', 'A', 'C', 'G', 'T'};
		int[] nums = {0, 4, 12, 16};
		GenomicDNASequence seq = new GenomicDNASequence(letters);
		String s = new String(seq.extractExons(nums));
		assertEquals("ACCGTGTACG", s);
	}
	
	@Test
	public void extractExons3() {
		char[] letters = {'A', 'C', 'C', 'G', 'T', 'A', 'G', 'C', 'G', 'T', 'A', 'C', 'G', 'T', 'A', 'C', 'G', 'T'};
		int[] nums = {0, 6, 8, 12, 15, 16};
		GenomicDNASequence seq = new GenomicDNASequence(letters);
		String s = new String(seq.extractExons(nums));
		assertEquals("ACCGTAGGTACGCG", s);
	}

}
