package pers.lxs.offer.from51to60;

import java.util.Arrays;
import org.junit.Test;

public class Main51 {
	@Test
	public void test() {
		int[] A = { 1, 3, 5, 7, 9 };
		int[] B = multiply(A);

		System.out.println(Arrays.toString(B));
	}

	public int[] multiply(int[] A) {
		if ((A == null) || (A.length <= 0)) {
			return null;
		}

		int[] result = new int[A.length];

		int[] temp = new int[A.length + 1];
		temp[A.length] = 1;
		int product = 1;

		for (int i = A.length - 1; i >= 0; i--) {
			product *= A[i];
			temp[i] = product;
		}

		product = 1;
		for (int i = 0; i < A.length; i++) {
			result[i] = (product * temp[(i + 1)]);
			product *= A[i];
		}

		return result;
	}
}