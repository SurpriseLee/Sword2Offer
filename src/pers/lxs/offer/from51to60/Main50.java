package pers.lxs.offer.from51to60;

import org.junit.Test;

public class Main50 {
	@Test
	public void test() {
		int[] numbers = { 1, 0, 3, 2, 4, 3, 6 };
		int[] duplication = new int[1];

		System.out.println(duplicate(numbers, numbers.length, duplication) + " " + duplication[0]);
	}

	public boolean duplicate(int[] numbers, int length, int[] duplication) {
		if (length <= 0) {
			return false;
		}

		int[] temp = new int[length];

		for (int e : numbers) {
			temp[e] += 1;
		}

		for (int e : numbers) {
			if (temp[e] >= 2) {
				duplication[0] = e;
				return true;
			}
		}

		return false;
	}
}