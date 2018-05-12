package pers.lxs.offer.from01to10;

import org.junit.Test;

public class Main09 {
	@Test
	public void test() {
		int target = 5;
		System.out.println(JumpFloorII(target));
	}

	public int JumpFloorII(int target) {
		if (target == 1)
			return 1;

		int sum = 2;

		int result = 0;

		for (int i = 2; i <= target; i++) {
			result = sum;
			sum = result + sum;
		}

		return result;
	}
}