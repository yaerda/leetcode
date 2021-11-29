//Given the roots of two binary trees root and subRoot, return true if there is 
//a subtree of root with the same structure and node values of subRoot and false o
//therwise. 
//
// A subtree of a binary tree tree is a tree that consists of a node in tree and
// all of this node's descendants. The tree tree could also be considered as a sub
//tree of itself. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,4,5,1,2], subRoot = [4,1,2]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the root tree is in the range [1, 2000]. 
// The number of nodes in the subRoot tree is in the range [1, 1000]. 
// -104 <= root.val <= 104 
// -104 <= subRoot.val <= 104 
// 
// Related Topics Tree Depth-First Search String Matching Binary Tree Hash Funct
//ion 
// 👍 4413 👎 213


package leetcode.editor.en;

import dataObj.TreeNode;
import tool.Tool;

public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        Solution solution = new SubtreeOfAnotherTree().new Solution();
        TreeNode A = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8), new TreeNode(9)),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6), new TreeNode(7)));
        TreeNode B = new TreeNode(2,
                new TreeNode(4), new TreeNode(5));
        Tool.print(solution.isSubtree(A, B));
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
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (subRoot == null && root == null) {
                return true;
            }
            if (subRoot == null || root == null) {
                return false;
            }
            if (isSame(root, subRoot)) return true;
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        private boolean isSame(TreeNode root, TreeNode subRoot) {
            if (root == null && subRoot == null) {
                return true;
            }
            if (root == null || subRoot == null) {
                return false;
            }
            if (root.val != subRoot.val) {
                return false;
            }
            return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
