package pers.lxs.offer.from11to20;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import org.junit.Test;

public class Main18 {
	@Test
	public void test() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		TreeNode root = buildTree(array);
		preTravel(root);
		System.out.println();

		Mirror(root);
		preTravel(root);
		System.out.println();
	}

	public TreeNode buildTree(int[] array) {
		if (array.length <= 0) {
			return null;
		}

		TreeNode root = new TreeNode(array[0]);

		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(root);

		int index = 1;
		while (index < array.length) {
			TreeNode curr = (TreeNode) list.remove(0);

			curr.left = new TreeNode(array[(index++)]);
			list.add(curr.left);

			if (index < array.length) {
				curr.right = new TreeNode(array[(index++)]);
				list.add(curr.right);
			}
		}

		return root;
	}

	public void Mirror(TreeNode root) {
		if (root == null) {
			return;
		}

		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.offerLast(root);

		while (!queue.isEmpty()) {
			TreeNode curr = (TreeNode) queue.pollFirst();

			TreeNode temp = curr.left;
			curr.left = curr.right;
			curr.right = temp;

			if (curr.left != null) {
				queue.offerLast(curr.left);
			}

			if (curr.right != null)
				queue.offerLast(curr.right);
		}
	}

	public void preTravel(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			preTravel(root.left);
			preTravel(root.right);
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