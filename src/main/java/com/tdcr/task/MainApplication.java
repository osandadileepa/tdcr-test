package com.tdcr.task;

import java.util.HashMap;
import java.util.Map;

public class MainApplication {

	public static void main(String[] args) {
		int[] x = {1, 2, 3, 1, 2};
		int[] y = {2, 4, 6, 5, 10};

		int result = getCountForCommonFractions(x, y);
		System.out.println("Number of occurrences of the most common fraction: " + result);
	}

	public static int getCountForCommonFractions(int[] x, int[] y) {
		if (x.length != y.length) {
			throw new IllegalArgumentException("Arrays must have the same length");
		}

		int n = x.length;
		Map<String, Integer> fractionCount = new HashMap<>();

		int maxCount = 0;

		for (int i = 0; i < n; i++) {
			int gcd = findGCD(x[i], y[i]);
			String fraction = (x[i] / gcd) + "/" + (y[i] / gcd);

			fractionCount.put(fraction, fractionCount.getOrDefault(fraction, 0) + 1);
			maxCount = Math.max(maxCount, fractionCount.get(fraction));
		}

		return maxCount;
	}

	// Find the greatest common divisor
	private static int findGCD(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}
