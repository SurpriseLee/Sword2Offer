package pers.lxs.offer.from11to20;

import java.util.Arrays;
import org.junit.Test;

public class Main13 {
	@Test
	public void test() {
		int[] a = { 1, 2, 3, 4, 5, 6, 7 };

		reOrderArray(a);

		System.out.println(Arrays.toString(a));
	}

	public void reOrderArray(int[] array) {
		int p = 0;
		int q = 0;

		while (p < array.length) {
			while ((p < array.length) && (array[p] % 2 == 0)) {
				p++;
			}

			if (p == array.length)
				return;

			for (int i = p; i > q; i--) {
				swap(array, i, i - 1);
			}

			q++;
			p++;
		}
	}

	public void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}