package pers.lxs.offer.from41to50;

import org.junit.Test;

public class Main43 {
	@Test
	public void test() {
		int n = 3;
		String str = "abcABC";

		System.out.println(LeftRotateString(str, n));
	}

	public String LeftRotateString(String str, int n) {
		if ((str == null) || (str.length() <= 0)) {
			return "";
		}

		if (str.length() == 1) {
			return str;
		}

		while (n > 0) {
			str = str.substring(1, str.length()) + str.charAt(0);
			n--;
		}

		return str;
	}
}