package pers.lxs.offer.from31to40;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;

public class Main38 {
	int maxDepth = 0;

	@Test
	public void test() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };

		TreeNode root = buildTree(array);

		int depth = TreeDepth(root);
		System.out.println(depth);
	}

	public int TreeDepth(TreeNode root) {
		if (root == null) {
			return this.maxDepth;
		}

		TreeDepth(root, 1);

		return this.maxDepth;
	}

	public void TreeDepth(TreeNode root, int depth) {
		if (root == null) {
			return;
		}

		this.maxDepth = (depth > this.maxDepth ? depth : this.maxDepth);

		TreeDepth(root.left, depth + 1);
		TreeDepth(root.right, depth + 1);
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