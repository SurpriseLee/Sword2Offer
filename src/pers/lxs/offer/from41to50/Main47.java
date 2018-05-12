package pers.lxs.offer.from41to50;

import org.junit.Test;

public class Main47 {
	@Test
	public void test() {
		int n = 10;
		System.out.println(Sum_Solution(n));
	}

	public int Sum_Solution(int n) {
		int sum = n;

		boolean flag = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
		
		System.out.println(flag);
		
		return sum;
	}

	public int Sum_Solution2(int n) {
		int sum = (int) (Math.pow(n, 2.0D) + n);
		return sum >> 1;
	}
}