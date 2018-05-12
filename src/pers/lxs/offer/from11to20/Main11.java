package pers.lxs.offer.from11to20;

import org.junit.Test;

public class Main11 {
	@Test
	public void test() {
		int target = 15;

		System.out.println(NumberOf1(target));
	}

	public int NumberOf1(int n) {
		String str = Integer.toBinaryString(n);

		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				result++;
			}
		}

		return result;
	}
}