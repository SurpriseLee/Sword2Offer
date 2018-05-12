package pers.lxs.offer.from21to30;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.Test;

public class Main29 {
	@Test
	public void test() {
		int[] array = { 4, 5, 1, 6, 2, 7, 3, 8 };
		int k = 10;

		ArrayList<Integer> list = GetLeastNumbers_Solution(array, k);

		System.out.println(list.toString());
	}

	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		if ((k <= 0) || (input == null) || (input.length == 0) || (input.length < k)) {
			return list;
		}

		if (input.length <= k) {
			for (int e : input) {
				list.add(Integer.valueOf(e));
			}
			return list;
		}

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2.intValue() - o1.intValue();
			}
		});
		for (int i = 0; i < k; i++) {
			maxHeap.add(Integer.valueOf(input[i]));
		}

		int index = k;
		while (index < input.length) {
			if (input[index] < ((Integer) maxHeap.peek()).intValue()) {
				maxHeap.remove();
				maxHeap.add(Integer.valueOf(input[index]));
			}

			index++;
		}

		while (!maxHeap.isEmpty()) {
			list.add((Integer) maxHeap.remove());
		}

		return list;
	}
}