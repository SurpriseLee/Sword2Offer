package pers.lxs.offer.from51to60;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;

public class Main58 {
	@Test
	public void test() {
		int[] array = { 8, 6, 6, 5, 7, 7, 5 };

		TreeNode root = buildTree(array);

		System.out.println(isSymmetrical(root));
	}

	public boolean isSymmetrical(TreeNode pRoot) {
		if (pRoot == null) {
			return true;
		}

		return isSymmetrical(pRoot.left, pRoot.right);
	}

	public boolean isSymmetrical(TreeNode left, TreeNode right) {
		if ((left == null) && (right == null)) {
			return true;
		}

		if (((left == null) && (right != null)) || ((left != null) && (right == null))) {
			return false;
		}

		return (left.val == right.val) && (isSymmetrical(left.left, right.right))
				&& (isSymmetrical(left.right, right.left));
	}

	public TreeNode buildTree(int[] array) {
		if ((array == null) || (array.length <= 0)) {
			return null;
		}

		TreeNode root = new TreeNode(array[0]);
		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.offerLast(root);

		int index = 1;
		while (index < array.length) {
			TreeNode node = (TreeNode) queue.pollFirst();
			node.left = new TreeNode(array[(index++)]);
			queue.offerLast(node.left);

			if (index < array.length) {
				node.right = new TreeNode(array[(index++)]);
				queue.offerLast(node.right);
			}

		}

		return root;
	}

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}
}