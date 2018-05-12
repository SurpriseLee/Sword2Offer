package pers.lxs.offer.from11to20;

import java.util.ArrayList;
import org.junit.Test;

public class Main19 {
	@Test
	public void test() {
		int[][] matrix = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 } };

		ArrayList<Integer> list = printMatrix(matrix);

		System.out.println(list.size());
		System.out.println(list.toString());
	}

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		if ((matrix == null) || (matrix.length == 0)) {
			return list;
		}

		int minr = 0;
		int maxr = matrix.length - 1;
		int minc = 0;
		int maxc = matrix[0].length - 1;

		System.out.println("minr: " + minr + " maxr: " + maxr);
		System.out.println("minc: " + minc + " maxc: " + maxc);

		int r = 0;
		int c = 0;
		while (true) {
			list.add(Integer.valueOf(matrix[r][(c++)]));

			while (c > maxc) {
				c--;
				r++;
				minr++;

				if (r > maxr) {
					break;
				}

				while (r <= maxr) {
					list.add(Integer.valueOf(matrix[(r++)][c]));
				}
				r--;
				c--;
				maxc--;

				if (c < minc) {
					break;
				}

				while (c >= minc) {
					list.add(Integer.valueOf(matrix[r][(c--)]));
				}
				c++;
				r--;
				maxr--;

				if (r < minr) {
					break;
				}

				while (r >= minr) {
					list.add(Integer.valueOf(matrix[(r--)][c]));
				}
				r++;
				c++;
				minc++;

				if (c > maxc) {
					break;
				}
			}
		}
	}
}
