package pers.lxs.offer.from41to50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.junit.Test;

public class Main41 {
	@Test
	public void test() {
		int sum = 1000;

		ArrayList<ArrayList<Integer>> resultList = FindContinuousSequence(sum);

		for (ArrayList<Integer> list : resultList)
			System.out.println(list.toString());
	}

	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();

		if (sum <= 1) {
			return resultList;
		}

		int index = 2;

		while (sum / index * 2 >= index) {
			boolean odd = (index % 2 == 1) && (sum % index == 0);
			boolean even = (index % 2 == 0) && (sum / index * index != sum)
					&& (sum * 10 / index / 5 * 5 * index == sum * 10);

			if ((odd) || (even)) {
				ArrayList<Integer> list = new ArrayList<Integer>();

				int mid = sum / index;

				int temp = 0;
				if (odd)
					temp = index / 2;
				else {
					temp = index / 2 - 1;
				}

				while (temp > 0) {
					list.add(Integer.valueOf(mid - temp));
					temp--;
				}

				while (temp <= index / 2) {
					list.add(Integer.valueOf(mid + temp));
					temp++;
				}

				resultList.add(list);
			}

			index++;
		}

		Collections.sort(resultList, new Comparator<ArrayList<Integer>>() {
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				return ((Integer) o1.get(0)).intValue() - ((Integer) o2.get(0)).intValue();
			}
		});
		return resultList;
	}
}