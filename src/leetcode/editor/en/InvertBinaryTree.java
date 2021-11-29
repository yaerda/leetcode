//Given the root of a binary tree, invert the tree, and return its root. 
//
// 
// Example 1: 
//
// 
//Input: root = [4,2,7,1,3,6,9]
//Output: [4,7,2,9,6,3,1]
// 
//
// Example 2: 
//
// 
//Input: root = [2,1,3]
//Output: [2,3,1]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 
// 👍 6970 👎 95


package leetcode.editor.en;

import dataObj.TreeNode;
import tool.Tool;

public class InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8), new TreeNode(9)),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6), new TreeNode(7)));
        Tool.print(treeNode);
        Tool.print(solution.invertTree(treeNode));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode tempLeft = root.left;
            root.left = root.right;
            root.right = tempLeft;
            if (root.left != null) {
                invertTree(root.left);
            }
            if (root.right != null) {
                invertTree(root.right);
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
