package pers.lxs.offer.from21to30;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class Main24 {
	@Test
	public void test() {
		int[] array = { 1, 2, 3, 4, 5, 6, 12, 8, 9 };

		TreeNode root = buildTree(array);

		int target = 16;

		ArrayList<ArrayList<Integer>> list = FindPath(root, target);

		System.out.println(list.toString());
	}

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();

		if (root == null) {
			return lists;
		}

		int sum = 0;

		ArrayList<Integer> list = new ArrayList<Integer>();

		FindPath(root, sum, target, list, lists);

		return lists;
	}

	public void FindPath(TreeNode root, int sum, int target, ArrayList<Integer> list,
			ArrayList<ArrayList<Integer>> lists) {
		if (root == null) {
			return;
		}

		sum += root.val;

		if (sum > target) {
			return;
		}

		list.add(Integer.valueOf(root.val));

		FindPath(root.left, sum, target, list, lists);

		FindPath(root.right, sum, target, list, lists);

		if ((root.left == null) && (root.right == null) && (sum == target)) {
			lists.add(new ArrayList<Integer>(list));
		}

		list.remove(list.size() - 1);
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