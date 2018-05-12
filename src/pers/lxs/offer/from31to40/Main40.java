package pers.lxs.offer.from31to40;

import java.util.Arrays;
import org.junit.Test;

public class Main40 {
	@Test
	public void test() {
		int[] array = { 2, 4, 3, 6, 3, 2, 5, 5 };
		int[] num1 = new int[1];
		int[] num2 = new int[1];

		FindNumsAppearOnce(array, num1, num2);

		System.out.println(num1[0] + " " + num2[0]);
	}

	public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
		if ((array == null) || (array.length < 2)) {
			return;
		}

		if (array.length == 2) {
			num1[0] = array[0];
			num2[0] = array[1];
			return;
		}

		Arrays.sort(array);

		System.out.println(Arrays.toString(array));

		int count = 0;
		int index = 0;
		while ((index < array.length) && (count < 2)) {
			while ((index < array.length - 1) && (array[index] == array[(index + 1)])) {
				index += 2;
			}

			if (index == array.length - 1) {
				num2[0] = array[index];
				return;
			}

			if (array[index] != array[(index + 1)]) {
				if (count == 0) {
					num1[0] = array[index];
					count++;
				} else if (count == 1) {
					num2[0] = array[index];
					return;
				}

				index++;
			}
		}
	}
}