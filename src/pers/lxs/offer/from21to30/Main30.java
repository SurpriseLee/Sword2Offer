package pers.lxs.offer.from21to30;

import org.junit.Test;

public class Main30 {
	@Test
	public void test() {
		int[] array = { 6, -3, -2, 7, -15, 1, 2, 2 };
		System.out.println(FindGreatestSumOfSubArray(array));
	}

	public int FindGreatestSumOfSubArray(int[] array) {
		if ((array == null) || (array.length == 0)) {
			return -2147483648;
		}

		int max = -2147483648;
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum = 0;
			for (int j = i; j < array.length; j++) {
				sum += array[j];
				max = sum > max ? sum : max;
			}
		}

		return max;
	}
}
