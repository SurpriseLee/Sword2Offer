package pers.lxs.offer.from31to40;

import org.junit.Test;

public class Main31 {
	@Test
	public void test() {
		int n = 13000;
		System.out.println(NumberOf1Between1AndN_Solution(n));
	}

	public int NumberOf1Between1AndN_Solution2(int n) {
		int count = 0;
		while (n > 0) {
			String str = String.valueOf(n);
			char[] chars = str.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				if (chars[i] == '1')
					count++;
			}
			n--;
		}
		return count;
	}

	public int NumberOf1Between1AndN_Solution(int n) {
		int count = 0;

		int index = 1;
		while (index <= n) {
			int curr = index;

			while (curr / 10 > 0) {
				int temp = curr % 10;
				curr /= 10;

				if (temp == 1) {
					count++;
				}
			}

			if (curr == 1) {
				count++;
			}

			index++;
		}

		return count;
	}
}