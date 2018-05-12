package pers.lxs.offer.from41to50;

import org.junit.Test;

public class Main49 {
	@Test
	public void test() {
		String str = "123";

		System.out.println(StrToInt(str));
	}

	public int StrToInt(String str) {
		if ((str == null) || (str.trim().equals(""))) {
			return 0;
		}

		int sign = 1;
		if (str.charAt(0) == '+') {
			sign = 1;
			str = str.substring(1, str.length());
		} else if (str.charAt(0) == '-') {
			sign = -1;
			str = str.substring(1, str.length());
		}

		int sum = 0;
		int time = 1;
		int index = str.length() - 1;
		while (index >= 0) {
			char ch = str.charAt(index);

			if ((ch < '0') || (ch > '9')) {
				return 0;
			}

			int temp = ch - '0';

			sum += temp * time;
			time *= 10;
			index--;
		}

		return sign * sum;
	}
}