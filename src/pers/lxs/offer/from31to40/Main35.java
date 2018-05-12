package pers.lxs.offer.from31to40;

import org.junit.Test;

public class Main35 {
	int count = 0;

	@Test
	public void test() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(InversePairs(array));
	}

	public int InversePairs(int[] array) {
		if ((array == null) || (array.length < 2)) {
			return 0;
		}

		InversePairs(array, 0, array.length - 1);

		return this.count % 1000000007;
	}

	public void InversePairs(int[] array, int start, int end) {
		if (end <= start) {
			return;
		}

		int mid = start + end >> 1;

		InversePairs(array, start, mid);
		InversePairs(array, mid + 1, end);

		merge(array, start, mid, end);
	}

	private void merge(int[] array, int start, int mid, int end) {
		if ((array == null) || (array.length <= 1) || (end <= start)) {
			return;
		}

		int[] temp = new int[end - start + 1];

		int index = temp.length - 1;
		int p = mid;
		int q = end;
		do {
			if (array[p] > array[q]) {
				temp[index] = array[(p--)];
				this.count += q - mid;
				this.count %= 1000000007;
			} else {
				temp[index] = array[(q--)];
			}
			index--;

			if (p < start)
				break;
		} while (q > mid);

		while (p >= start) {
			temp[(index--)] = array[(p--)];
		}

		while (q > mid) {
			temp[(index--)] = array[(q--)];
		}

		index = 0;
		while (index < temp.length) {
			array[(start + index)] = temp[index];
			index++;
		}
	}
}