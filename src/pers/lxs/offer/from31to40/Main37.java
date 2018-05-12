package pers.lxs.offer.from31to40;

import org.junit.Test;

public class Main37 {
	@Test
	public void test() {
		int k = 7;
		int[] array = { 1, 1, 2, 3, 4, 5, 6, 6, 6, 6, 7, 8, 8, 9, 9 };

		int result = GetNumberOfK(array, k);
		System.out.println(result);
	}

	public int GetNumberOfK(int[] array, int k) {
		if ((array == null) || (array.length <= 0)) {
			return 0;
		}

		int left = 0;
		int right = array.length - 1;
		int index = 0;
		while ((right >= left) && (array[index] != k)) {
			index = left + right >> 1;
			if (array[index] > k)
				right = index - 1;
			else if (array[index] < k) {
				left = index + 1;
			}
		}

		if (array[index] != k) {
			return 0;
		}

		int count = 1;
		int tempIndex = index - 1;
		while ((tempIndex >= 0) && (array[tempIndex] == k)) {
			count++;
			tempIndex--;
		}

		tempIndex = index + 1;
		while ((tempIndex < array.length) && (array[tempIndex] == k)) {
			count++;
			tempIndex++;
		}

		return count;
	}
}
