package com.shoumo.geek.dynamic.programming;

/**
 * This solution takes pascal's triangle approach
 * 
 * @author shoumo
 *
 */
public class BinomialCoefficient {

	/**
	 * C(n,k) = C(n-1,k-1)+C(n-1,k) <br/>
	 * C(n,n) = C(0,0) = 1
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public int getBinomialCoefficient(int n, int k) {
		int[] coefficientArray = new int[k + 1];

		/**
		 * initialize the array with 0's
		 */
		for (int i = 0; i <= k; i++)
			coefficientArray[i] = 0;

		coefficientArray[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = Math.min(i, k); j > 0; j--)
				coefficientArray[j] = coefficientArray[j]
						+ coefficientArray[j - 1];
		}
		return coefficientArray[k];
	}

	public static void main(String[] args) {
		System.out.println("Binomial coefficient is:"
				+ new BinomialCoefficient().getBinomialCoefficient(5, 2));
	}
}
