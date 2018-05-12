package pers.lxs.offer.from41to50;

import java.util.Arrays;
import org.junit.Test;

public class Main45 {
	@Test
	public void test() {
		int[] numbers = { 1, 3, 0, 0, 5 };

		System.out.println(isContinuous(numbers));
	}

	public boolean isContinuous(int[] numbers) {
		if ((numbers == null) || (numbers.length != 5)) {
			return false;
		}

		Arrays.sort(numbers);

		int p = 0;
		while ((p < numbers.length) && (numbers[p] == 0)) {
			p++;
		}

		int index = p;
		while (index < numbers.length - 1) {
			if (numbers[index] != numbers[(index + 1)]) {
				return false;
			}
		}

		if (numbers[(numbers.length - 1)] - numbers[p] <= 4) {
			return true;
		}

		return false;
	}
}