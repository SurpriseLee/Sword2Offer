package pers.lxs.offer.from61to66;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;

public class Main66 {
	@Test
	public void test() {
		int threshold = -10;

		int rows = 10;
		int cols = 10;

		System.out.println(movingCount(threshold, rows, cols));
	}

	public int movingCount(int threshold, int rows, int cols) {
		if (threshold < 0) {
			return 0;
		}

		Deque<Point> deque = new ArrayDeque<Point>();
		boolean[][] isVisited = new boolean[rows][cols];

		deque.offerLast(new Point(0, 0));
		isVisited[0][0] = true;
		int count = 0;

		while (!deque.isEmpty()) {
			Point p = (Point) deque.pollFirst();
			count++;

			if ((p.row > 0) && !isVisited[(p.row - 1)][p.col]
					&& (sumOfIndexNumber(p.row - 1, p.col) <= threshold)) {
				deque.offerLast(new Point(p.row - 1, p.col));
				isVisited[(p.row - 1)][p.col] = true;
			}

			if ((p.row < rows - 1) && !isVisited[(p.row - 1)][p.col]
					&& (sumOfIndexNumber(p.row + 1, p.col) <= threshold)) {
				deque.offerLast(new Point(p.row + 1, p.col));
				isVisited[(p.row + 1)][p.col] = true;
			}

			if ((p.col > 0) && !isVisited[(p.row - 1)][p.col]
					&& (sumOfIndexNumber(p.row, p.col - 1) <= threshold)) {
				deque.offerLast(new Point(p.row, p.col - 1));
				isVisited[p.row][(p.col - 1)] = true;
			}

			if ((p.col < cols - 1) && !isVisited[(p.row - 1)][p.col]
					&& (sumOfIndexNumber(p.row, p.col + 1) <= threshold)) {
				deque.offerLast(new Point(p.row, p.col + 1));
				isVisited[p.row][(p.col + 1)] = true;
			}
		}

		return count;
	}

	public int sumOfIndexNumber(int row, int col) {
		int sum = 0;

		while (row >= 10) {
			sum += row % 10;
			row /= 10;
		}
		sum += row;

		while (col >= 10) {
			sum += col % 10;
			col /= 10;
		}
		sum += col;

		return sum;
	}

	class Point {
		int row;
		int col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}