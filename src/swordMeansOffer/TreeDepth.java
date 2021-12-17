package swordMeansOffer;

import dataObj.TreeNode;
import tool.Tool;

public class TreeDepth {
    public static void main(String[] args) {

        TreeNode node = new TreeNode(new Integer[]{1, 2, null, 4, null, null, null, null, 5});
        Tool.print(new TreeDepth().depth(node));
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left, right) + 1;
    }
}
