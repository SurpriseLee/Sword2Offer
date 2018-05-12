package pers.lxs.offer.from61to66;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import org.junit.Test;

public class Main64 {
	@Test
	public void test() {
		int[] num = { 2, 3, 4, 2, 6, 2, 5, 1 };
		int size = 3;

		ArrayList<Integer> list = maxInWindows(num, size);

		System.out.println(list.toString());
	}

	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		if ((num == null) || (num.length <= 0) || (size == 0)) {
			return list;
		}

		Deque<Integer> deque = new ArrayDeque<Integer>();
		deque.offerLast(Integer.valueOf(0));

		int index = 0;
		while (index < size - 1) {
			while ((!deque.isEmpty()) && (num[((Integer) deque.getLast()).intValue()] <= num[index])) {
				deque.pollLast();
			}

			deque.offerLast(Integer.valueOf(index++));
		}

		while (index < num.length) {
			while ((!deque.isEmpty()) && (num[((Integer) deque.getLast()).intValue()] <= num[index])) {
				deque.pollLast();
			}

			deque.offerLast(Integer.valueOf(index));

			if (((Integer) deque.peekFirst()).intValue() <= index - size) {
				deque.pollFirst();
			}

			list.add(Integer.valueOf(num[((Integer) deque.peekFirst()).intValue()]));
			index++;
		}

		return list;
	}

	public ArrayList<Integer> maxInWindows2(int[] num, int size) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		if ((num == null) || (num.length <= 0) || (size == 0)) {
			return list;
		}

		for (int i = 0; i <= num.length - size; i++) {
			list.add(Integer.valueOf(getMax(num, i, i + size - 1)));
		}

		return list;
	}

	public int getMax(int[] array, int start, int end) {
		if ((array == null) || (array.length <= 0)) {
			return -1;
		}

		int max = array[start];
		int index = start + 1;

		while (index <= end) {
			max = array[index] > max ? array[index] : max;
			index++;
		}

		return max;
	}
}