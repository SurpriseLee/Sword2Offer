package pers.lxs.offer.from21to30;

import java.util.Arrays;
import org.junit.Test;

public class Main28 {
	@Test
	public void test() {
		int[] array = { 1, 1, 2, 1, 3, 2, 4, 4, 1, 4, 1, 2, 1, 2, 1, 1, 1, 1 };
		System.out.println(MoreThanHalfNum_Solution(array));
		System.out.println(MoreThanHalfNum_Solution_n(array));
	}

	public int MoreThanHalfNum_Solution_n(int[] array) {
		int n = array.length;
		if (n == 0)
			return 0;

		int num = array[0];
		int count = 1;
		for (int i = 1; i < n; i++) {
			if (array[i] == num)
				count++;
			else
				count--;
			if (count == 0) {
				num = array[i];
				count = 1;
			}
		}

		count = 0;
		for (int i = 0; i < n; i++) {
			if (array[i] == num)
				count++;
		}
		if (count * 2 > n)
			return num;
		return 0;
	}

	public int MoreThanHalfNum_Solution(int[] array) {
		if (array.length <= 0) {
			return 0;
		}

		if (array.length == 1) {
			return array[0];
		}

		int N = array.length / 2;

		Arrays.sort(array);

		int max = 1;
		int count = 1;

		int flag = 0;
		int index = 1;
		while (index < array.length) {
			if (array[index] == array[(index - 1)]) {
				count++;

				if (count > max) {
					flag = array[index];
					max = count;
				}
			} else {
				count = 1;
			}

			index++;
		}

		return max > N ? flag : 0;
	}
}
