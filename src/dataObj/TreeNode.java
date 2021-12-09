package dataObj;

import java.util.*;
import java.util.stream.Collectors;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("Empty tree");
        }
        this.val = (nums[0]);
        this.left = construcTreeNode(nums, 2);
        this.right = construcTreeNode(nums, 3);
    }

    private TreeNode construcTreeNode(Integer[] nums, int idx) {
        if (idx - 1 >= nums.length) {
            return null;
        }
        Integer rootVal = nums[idx - 1];
        if (rootVal == null) {
            return null;
        }
        TreeNode root = new TreeNode(rootVal);
        TreeNode left = construcTreeNode(nums, idx * 2);
        TreeNode right = construcTreeNode(nums, idx * 2 + 1);
        root.left = left;
        root.right = right;
        return root;
    }

    @Override
    public String toString() {
        List<Integer> nodeList = new ArrayList<>();
        LinkedList<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(this);
        while (!treeNodeQueue.isEmpty()) {
            TreeNode root = treeNodeQueue.poll();
            if (root == null) {
                nodeList.add(null);
                continue;
            } else {
                nodeList.add(root.val);
            }
            treeNodeQueue.add(root.left);
            treeNodeQueue.add(root.right);
        }

        return "[" + nodeList.stream().map(String::valueOf).collect(Collectors.joining(",")) + "]";
    }
}
