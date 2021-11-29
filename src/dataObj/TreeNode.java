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

    @Override
    public String toString() {
        List<Integer> nodeList = new ArrayList<>();
        LinkedList<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(this);
        while (!treeNodeQueue.isEmpty()) {
            TreeNode root = treeNodeQueue.poll();
            nodeList.add(root.val);
            if (root.left != null) {
                treeNodeQueue.add(root.left);
            }
            if (root.right != null) {
                treeNodeQueue.add(root.right);
            }
        }
        return "[" + nodeList.stream().map(String::valueOf).collect(Collectors.joining(",")) + "]";
    }
}
