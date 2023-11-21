package com.tdcr.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainApplicationTests {

	@Test
	void testFractionForArrays() {
		// Given tests cases for arrays
		int[] x1 = {1, 2, 3, 4, 0};
		int[] y1 = {2, 3, 6, 8, 4};
		assertEquals(3, MainApplication.getCountForCommonFractions(x1, y1));

		int[] x2 = {3, 3, 4};
		int[] y2 = {5, 4, 3};
		assertEquals(1, MainApplication.getCountForCommonFractions(x2, y2));

		int[] x3 = {4, 4, 7, 1, 2};
		int[] y3 = {4, 4, 8, 1, 2};
		assertEquals(4, MainApplication.getCountForCommonFractions(x3, y3));

		int[] x4 = {1, 2, 3, 1, 2};
		int[] y4 = {2, 4, 6, 5, 10};
		assertEquals(3, MainApplication.getCountForCommonFractions(x4, y4));


		// some additions inputs for testing
		int[] x5 = {1, 2, 3, 4, 2};
		int[] y5 = {2, 4, 6, 8, 4};
		assertEquals(5, MainApplication.getCountForCommonFractions(x5, y5));

		int[] x6 = {1};
		int[] y6 = {2};
		assertEquals(1, MainApplication.getCountForCommonFractions(x6, y6));

		int[] x7 = {1, 2};
		int[] y7 = {2, 3};
		assertEquals(1, MainApplication.getCountForCommonFractions(x7, y7));

		int[] x8 = {2, 4};
		int[] y8 = {4, 8};
		assertEquals(2, MainApplication.getCountForCommonFractions(x8, y8));

		int[] x9 = new int[1000000];
		int[] y9 = new int[1000000];
		for (int i = 0; i < 1000000; i++) {
			x9[i] = i + 1;
			y9[i] = i + 2;
		}
		assertEquals(1, MainApplication.getCountForCommonFractions(x9, y9));

		// Test with maximum allowed values
		int[] x10 = {Integer.MAX_VALUE};
		int[] y10 = {Integer.MAX_VALUE};
		assertEquals(1, MainApplication.getCountForCommonFractions(x10, y10));

		// Edge case with an empty array
		int[] emptyX = {};
		int[] emptyY = {};
		assertEquals(0, MainApplication.getCountForCommonFractions(emptyX, emptyY));
	}

	@Test
	void testFractionIllegalArgumentException() {
		// Edge case with arrays of different lengths
		int[] unequalLengthX = {1, 2, 3};
		int[] unequalLengthY = {4, 5};
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> MainApplication.getCountForCommonFractions(unequalLengthX, unequalLengthY));

		assertEquals("Arrays must have the same length", exception.getMessage());
	}
}

