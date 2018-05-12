package pers.lxs.offer.from41to50;

import java.util.ArrayList;
import org.junit.Test;

public class Main42 {
	@Test
	public void test() {
		int sum = 22;
		int[] array = { 1, 2, 4, 6, 8, 10, 12, 15, 16, 18, 20 };

		ArrayList<Integer> list = FindNumbersWithSum(array, sum);

		System.out.println(list.toString());
	}

	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		if ((array == null) || (array.length < 2)) {
			return list;
		}

		int left = 0;
		int right = array.length - 1;

		while ((list.isEmpty()) && (left < right)) {
			if (array[left] + array[right] == sum) {
				list.add(Integer.valueOf(array[left]));
				list.add(Integer.valueOf(array[right]));
				break;
			}

			if (array[left] + array[right] < sum)
				left++;
			else if (array[left] + array[right] > sum) {
				right--;
			}
		}

		return list;
	}
}