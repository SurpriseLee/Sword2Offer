package pers.lxs.offer.from31to40;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import org.junit.Test;

public class Main32 {
	@Test
	public void test() {
		int[] numbers = { 3, 32, 321 };

		System.out.println(printMinNumber(numbers));
	}

	public String printMinNumber(int[] numbers) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		if ((numbers == null) || (numbers.length == 0)) {
			return list.toString();
		}

		for (int e : numbers) {
			list.add(Integer.valueOf(e));
		}

		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer str1, Integer str2) {
				String s1 = str1 + "" + str2;
				String s2 = str2 + "" + str1;

				return s1.compareTo(s2);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (Iterator<Integer> localIterator = list.iterator(); localIterator.hasNext();) {
			int e = ((Integer) localIterator.next()).intValue();
			sb.append(e);
		}

		return sb.toString();
	}

	public String PrintMinNumber(int[] numbers) {
		if ((numbers == null) || (numbers.length == 0)) {
			return "";
		}

		String[] strs = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			strs[i] = String.valueOf(numbers[i]);
		}

		TreeSet<String> result = new TreeSet<String>();

		permutation(strs, 0, result);

		return (String) result.first();
	}

	public void permutation(String[] strs, int start, TreeSet<String> set) {
		if ((strs == null) || (strs.length == 0)) {
			return;
		}

		if (start == strs.length - 1) {
			set.add(convert2Str(strs));
		}

		for (int i = start; i < strs.length; i++) {
			swap(strs, start, i);
			permutation(strs, start + 1, set);
			swap(strs, start, i);
		}
	}

	public void swap(String[] strs, int left, int right) {
		String temp = strs[left];
		strs[left] = strs[right];
		strs[right] = temp;
	}

	public String convert2Str(String[] strs) {
		StringBuilder sb = new StringBuilder();

		for (String str : strs) {
			sb.append(str);
		}

		return sb.toString();
	}
}
