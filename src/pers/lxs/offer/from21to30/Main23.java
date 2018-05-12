package pers.lxs.offer.from21to30;

import org.junit.Test;

public class Main23 {
	@Test
	public void test() {
		int[] sequence = new int[0];

		System.out.println(VerifySquenceOfBST(sequence));
	}

	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence.length <= 0) {
			return false;
		}
		return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
	}

	public boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
		if (end <= start) {
			return true;
		}

		int root = sequence[end];

		int index = start;
		while (sequence[index] < root) {
			index++;
		}

		int temp = index;
		while (temp < end) {
			if (sequence[(temp++)] < root) {
				return false;
			}
		}

		return (VerifySquenceOfBST(sequence, start, index - 1)) && (VerifySquenceOfBST(sequence, index, end - 1));
	}
}