package pers.lxs.offer.from21to30;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;

public class Main27 {
	@Test
	public void test() {
		String str = "aab";

		ArrayList<String> list = Permutation(str);

		for (String s : list)
			System.out.println(s);
	}

	public ArrayList<String> Permutation(String str) {
		Set<String> set = PermutationSet(str);
		ArrayList<String> list = new ArrayList<String>(set);
		return list;
	}

	public Set<String> PermutationSet(String str) {
		Set<String> allSet = new TreeSet<String>();

		if ((str == null) || (str.equals(""))) {
			return allSet;
		}

		if (str.length() == 1) {
			allSet.add(str);
		}

		for (int i = 0; i < str.length(); i++) {
			String s = str.charAt(i) + "";

			String subStr = str.substring(0, i) + str.substring(i + 1, str.length());

			Set<String> set = PermutationSet(subStr);

			set = allAdd(s, set);

			allSet.addAll(set);
			set.clear();
		}

		return allSet;
	}

	public Set<String> allAdd(String s, Set<String> set) {
		if (set == null) {
			return null;
		}

		Set<String> newSet = new TreeSet<String>();

		for (String str : set) {
			newSet.add(s + str);
		}

		set.clear();

		return newSet;
	}
}
