package pers.lxs.offer.from01to10;

import org.junit.Test;

public class Main06 {
	@Test
	public void test() {
		int[] a = { 1, 2, 4, 7, 3, 5, 8, 6 };

		System.out.println(minNumberInRotateArray(a));
	}

	public int minNumberInRotateArray(int[] array) {
		if (array.length == 0) {
			return 0;
		}

		int min = 2147483647;
		for (int i = 0; i < array.length; i++) {
			min = array[i] < min ? array[i] : min;
		}

		return min;
	}
}