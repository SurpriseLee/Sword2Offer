package pers.lxs.offer.from51to60;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import org.junit.Test;

public class Main59 {
	@Test
	public void test() {
		int[] array = { 5, 4, 3, 2 };

		TreeNode root = new TreeNode(0);
		TreeNode curr = root;

		int index = 0;
		while (index < array.length) {
			curr.left = new TreeNode(array[(index++)]);
			curr = curr.left;
		}

		ArrayList<ArrayList<Integer>> lists = Print(root);

		System.out.println(lists.size());

		for (ArrayList<Integer> list : lists)
			System.out.println(list.toString());
	}

	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>>  lists = new ArrayList<ArrayList<Integer>> ();

		if (pRoot == null) {
			return lists;
		}

		Deque<TreeNode> currQueue = new ArrayDeque<TreeNode>();
		Deque<TreeNode> nextQueue = new ArrayDeque<TreeNode>();

		currQueue.offerLast(pRoot);

		int index = 0;
		while (!currQueue.isEmpty()) {
			nextQueue.clear();
			ArrayList<Integer> list = new ArrayList<Integer>();
			while (!currQueue.isEmpty()) {
				TreeNode curr = (TreeNode) currQueue.pollFirst();
				list.add(Integer.valueOf(curr.val));

				if (index % 2 == 0) {
					if (curr.left != null)
						nextQueue.offerFirst(curr.left);
					if (curr.right != null)
						nextQueue.offerFirst(curr.right);
				} else {
					if (curr.right != null)
						nextQueue.offerFirst(curr.right);
					if (curr.left != null)
						nextQueue.offerFirst(curr.left);
				}
			}

			lists.add(list);

			index++;
			Deque<TreeNode> tempQueue = currQueue;
			currQueue = nextQueue;
			nextQueue = tempQueue;
		}

		return lists;
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