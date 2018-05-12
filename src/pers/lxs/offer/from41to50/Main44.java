package pers.lxs.offer.from41to50;

import org.junit.Test;

public class Main44 {
	@Test
	public void test() {
		String str = " ";

		System.out.println(ReverseSentence(str));
	}

	public String ReverseSentence(String str) {
		if ((str == null) || (str.length() <= 1) || (str.trim().equals(""))) {
			return str;
		}

		String[] strs = str.split(" ");

		int len = strs.length;
		int mid = len / 2;

		int index = 0;
		while (index < mid) {
			String temp = strs[index];
			strs[index] = strs[(len - index - 1)];
			strs[(len - index - 1)] = temp;
			index++;
		}

		StringBuilder sb = new StringBuilder();

		for (String s : strs) {
			sb.append(s + " ");
		}

		sb.deleteCharAt(sb.length() - 1);

		return sb.toString();
	}
}