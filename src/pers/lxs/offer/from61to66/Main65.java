package pers.lxs.offer.from61to66;

import org.junit.Test;

public class Main65 {
	@Test
	public void test() {
		String matStr = "abcesfcsadee";
		String pathStr = "abcb";

		char[] matrix = matStr.toCharArray();
		char[] str = pathStr.toCharArray();

		int rows = 3;
		int cols = 4;

		boolean hasPath = hasPath(matrix, rows, cols, str);

		System.out.println(hasPath);
	}

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if ((matrix == null) || (matrix.length < rows)) {
			return false;
		}

		char[][] mat = new char[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				mat[i][j] = matrix[(cols * i + j)];
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (mat[i][j] == str[0]) {
					boolean[][] isVisited = new boolean[mat.length][mat[0].length];
					boolean hasPath = hasPath(mat, i, j, str, 0, isVisited);
					if (hasPath) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean hasPath(char[][] mat, int m, int n, char[] str, int index, boolean[][] isVisited) {
		if ((mat == null) || (mat.length <= 0) || (mat[m][n] != str[index])) {
			return false;
		}

		if (index == str.length - 1) {
			return true;
		}

		boolean hasPath = false;

		isVisited[m][n] = true;

		if ((m > 0) && !isVisited[m - 1][n] && (index < str.length - 1)
				&& (mat[(m - 1)][n] == str[(index + 1)])) {
			hasPath = hasPath(mat, m - 1, n, str, index + 1, isVisited);
		}
		if (hasPath) {
			return true;
		}

		if ((m < mat.length - 1) && !isVisited[m - 1][n] && (index < str.length - 1)
				&& (mat[(m + 1)][n] == str[(index + 1)])) {
			hasPath = hasPath(mat, m + 1, n, str, index + 1, isVisited);
		}
		if (hasPath) {
			return true;
		}

		if ((n > 0) && !isVisited[m - 1][n] && (index < str.length - 1)
				&& (mat[m][(n - 1)] == str[(index + 1)])) {
			hasPath = hasPath(mat, m, n - 1, str, index + 1, isVisited);
		}
		if (hasPath) {
			return true;
		}

		if ((n < mat[m].length - 1) && !isVisited[m - 1][n] && (index < str.length - 1)
				&& (mat[m][(n + 1)] == str[(index + 1)])) {
			hasPath = hasPath(mat, m, n + 1, str, index + 1, isVisited);
		}
		if (hasPath) {
			return true;
		}

		isVisited[m][n] = false;

		return false;
	}
}