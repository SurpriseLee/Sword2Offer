package pers.lxs.offer.from21to30;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;

public class Main21 {
	@Test
	public void test() {
		int[] pushA = { 1, 2, 3, 4, 5 };
		int[] popA = { 3, 4, 5, 2 };

		System.out.println(IsPopOrder(pushA, popA));
	}

	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if ((pushA == null) && (popA == null)) {
			return true;
		}

		if ((pushA != null) && (popA == null)) {
			return false;
		}

		if ((popA != null) && (pushA == null)) {
			return false;
		}

		if (popA.length != pushA.length) {
			return false;
		}

		Deque<Integer> stack = new ArrayDeque<Integer>();

		int index = 0;
		for (int i = 0; i < popA.length; i++) {
			int curr = popA[i];

			while (((stack.isEmpty()) && (index < pushA.length))
					|| ((((Integer) stack.peekFirst()).intValue() != curr) && (index < pushA.length))) {
				stack.offerFirst(Integer.valueOf(pushA[(index++)]));
			}

			if ((stack.isEmpty()) || (((Integer) stack.pollFirst()).intValue() != curr)) {
				return false;
			}
		}

		return true;
	}
}