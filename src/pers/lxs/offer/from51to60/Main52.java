package pers.lxs.offer.from51to60;

import org.junit.Test;

public class Main52 {
	@Test
	public void test() {
		String str = "aaa";
		String pattern = "ab*a*c*a";
		System.out.println(match(str.toCharArray(), pattern.toCharArray()));
	}

	public boolean match(char[] str, char[] pattern) {
		if ((str == null) || (pattern == null)) {
			return false;
		}
		int strIndex = 0;
		int patternIndex = 0;
		return matchCore(str, strIndex, pattern, patternIndex);
	}

	public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
		if ((strIndex == str.length) && (patternIndex == pattern.length)) {
			return true;
		}

		if ((strIndex != str.length) && (patternIndex == pattern.length)) {
			return false;
		}

		if ((patternIndex + 1 < pattern.length) && (pattern[(patternIndex + 1)] == '*')) {
			if (((strIndex != str.length) && (pattern[patternIndex] == str[strIndex]))
					|| ((pattern[patternIndex] == '.') && (strIndex != str.length))) {
				return (matchCore(str, strIndex, pattern, patternIndex + 2))
						|| (matchCore(str, strIndex + 1, pattern, patternIndex + 2))
						|| (matchCore(str, strIndex + 1, pattern, patternIndex));
			}
			return matchCore(str, strIndex, pattern, patternIndex + 2);
		}

		if (((strIndex != str.length) && (pattern[patternIndex] == str[strIndex]))
				|| ((pattern[patternIndex] == '.') && (strIndex != str.length))) {
			return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
		}
		return false;
	}
}
