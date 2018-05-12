package pers.lxs.offer.from51to60;

import org.junit.Test;

public class Main53 {
	@Test
	public void test() {
		String str = "-.123";
		System.out.println(isNumeric(str.toCharArray()));
	}

	public boolean isNumeric(char[] str) {
		if ((str == null) || (str.length <= 0)) {
			return false;
		}

		String s = String.valueOf(str);

		return s.matches("[+-]?[0-9]*(\\.[0-9]+)?([eE][+-]?[0-9]+)?");
	}

	public boolean isNumeric2(char[] str) {
		if ((str == null) || (str.length <= 0)) {
			return false;
		}

		if ((str[(str.length - 1)] == 'e') || (str[(str.length - 1)] == 'E')) {
			return false;
		}

		String s = String.valueOf(str);

		String[] ss = s.split("e|E");

		if (ss.length > 2) {
			return false;
		}

		if ((ss.length == 2) && (ss[1].contains("."))) {
			return false;
		}

		for (String temp : ss) {
			System.out.println("Len: " + temp.split("\\.").length);

			if (temp.split("\\.").length > 2) {
				return false;
			}

			if ((temp.charAt(0) == '+') || (temp.charAt(0) == '-')) {
				temp = temp.substring(1, temp.length());
			}

			int index = 0;
			while (index < temp.length()) {
				char ch = temp.charAt(index);

				if ((ch == '.') || ((ch >= '0') && (ch <= '9')))
					index++;
				else {
					return false;
				}
			}

		}

		return true;
	}
}
