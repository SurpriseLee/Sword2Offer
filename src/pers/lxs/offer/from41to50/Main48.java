package pers.lxs.offer.from41to50;

import org.junit.Test;

public class Main48 {
	@Test
	public void test() {
		int a = 10;
		int b = 12;

		System.out.println(Add(a, b));
	}

	public int Add(int num1, int num2) {
		while (num2 != 0) {
			int temp = num1 ^ num2;
			num2 = (num1 & num2) << 1;
			num1 = temp;
		}

		return num1;
	}
}