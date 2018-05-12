package pers.lxs.offer.from01to10;

import org.junit.Test;

public class Main04 {
	@Test
	public void test() {
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };

		TreeNode root = reConstructBinaryTree(pre, in);

		preTravel(root);
		System.out.println();

		midTravel(root);
		System.out.println();

		afterTravel(root);
		System.out.println();
	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	public TreeNode reConstructBinaryTree(int[] pre, int ls, int le, int[] in, int rs, int re) {
		if ((le < ls) || (re < rs)) {
			return null;
		}

		TreeNode root = new TreeNode(pre[ls]);

		int index = 0;

		while (in[(rs + index)] != root.val) {
			index++;
		}

		root.left = reConstructBinaryTree(pre, ls + 1, ls + index, in, rs, rs + index - 1);
		root.right = reConstructBinaryTree(pre, ls + index + 1, le, in, rs + index + 1, re);

		String strRoot = "root: " + root.val;
		String strLeft = "left: " + root.left.val + " ";
		String strRight = "right: " + root.right.val + " ";

		System.out.println(strRoot + " " + strLeft + " " + strRight);

		return root;
	}

	private void preTravel(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			preTravel(root.left);
			preTravel(root.right);
		}
	}

	private void midTravel(TreeNode root) {
		if (root != null) {
			midTravel(root.left);
			System.out.print(root.val + " ");
			midTravel(root.right);
		}
	}

	private void afterTravel(TreeNode root) {
		if (root != null) {
			afterTravel(root.left);
			afterTravel(root.right);
			System.out.print(root.val + " ");
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			this.val = x;
		}

	}
}