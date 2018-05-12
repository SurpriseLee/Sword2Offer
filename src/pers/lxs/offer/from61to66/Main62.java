package pers.lxs.offer.from61to66;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;

public class Main62 {
	TreeNode targetNode = null;
	int count = 0;

	@Test
	public void test() {
		int[] array = { 5, 3, 7, 2, 4, 6, 8 };

		TreeNode root = buildTree(array);

		int k = 3;

		TreeNode targetNode = KthNode(root, k);

		System.out.println(targetNode.val);
	}

	public TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null) {
			return null;
		}

		midTravel(pRoot, k);

		return this.targetNode;
	}

	public void midTravel(TreeNode root, int K) {
		if (root == null) {
			return;
		}

		midTravel(root.left, K);

		this.count += 1;
		if (this.count == K) {
			this.targetNode = root;
		}

		midTravel(root.right, K);
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