package pers.lxs.offer.from31to40;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class Main34 {
	@Test
	public void test() {
		String str = "bbcefcefg";
		System.out.println(FirstNotRepeatingChar(str));
	}

	public int FirstNotRepeatingChar(String str) {
		if ((str == null) || (str.length() <= 0)) {
			return -1;
		}

		char[] chs = str.toCharArray();

		Set<Character> set = new HashSet<Character>();

		for (int i = 0; i < chs.length; i++) {
			if (!set.contains(Character.valueOf(chs[i]))) {
				if (i == chs.length - 1) {
					return i;
				}

				set.add(Character.valueOf(chs[i]));

				int j = i + 1;

				while (j < chs.length) {
					if (chs[j] == chs[i]) {
						break;
					}
					j++;
				}

				if (j == chs.length) {
					return i;
				}

			}

		}

		return -1;
	}
}