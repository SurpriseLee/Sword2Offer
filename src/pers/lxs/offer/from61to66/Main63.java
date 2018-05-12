package pers.lxs.offer.from61to66;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class Main63 {
	List<Integer> list = new ArrayList<Integer>();

	@Test
	public void test() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		for (int e : array) {
			Insert(Integer.valueOf(e));

			Double midian = GetMedian();
			System.out.print(midian + " ");
		}
	}

	public void Insert(Integer num) {
		this.list.add(num);
	}

	public Double GetMedian() {
		if (this.list.size() == 1) {
			return Double.valueOf(((Integer) this.list.get(0)).intValue() * 1.0D);
		}

		Collections.sort(this.list);

		if (this.list.size() % 2 != 0) {
			return Double.valueOf(((Integer) this.list.get(this.list.size() / 2)).intValue() * 1.0D);
		}

		int right = ((Integer) this.list.get(this.list.size() / 2)).intValue();
		int left = ((Integer) this.list.get(this.list.size() / 2 - 1)).intValue();

		return Double.valueOf((left + right) * 1.0D / 2.0D);
	}
}