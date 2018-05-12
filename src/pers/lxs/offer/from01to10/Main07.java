package pers.lxs.offer.from01to10;

import org.junit.Test;

public class Main07 {
	@Test
	public void test() {
		int n = 39;

		for (int i = 1; i <= n; i++) {
			System.out.print(Fibonacci(i, true) + " ");
		}
		System.out.println();
	}

	public int Fibonacci(int n) {
		if ((n == 1) || (n == 2)) {
			return 1;
		}

		return Fibonacci(n - 1) + Fibonacci(n - 2);
	}

	public int Fibonacci(int n, boolean flag) {
		if ((n == 1) || (n == 2)) {
			return 1;
		}

		int first = 1;
		int second = 1;

		int result = 0;

		for (int i = 3; i <= n; i++) {
			result = first + second;
			first = second;
			second = result;
		}

		return result;
	}
}