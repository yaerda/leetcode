package swordMeansOffer;

import dataObj.TreeNode;
import tool.Tool;

import java.util.ArrayList;
import java.util.List;

public class FindPath {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, null, 5, 6, null, null, null, 10, 11, 8};
        TreeNode root = new TreeNode(nums);
        Tool.print(new FindPath().solution(root, 18));
    }

    public List solution(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> pathList = new ArrayList<>();
        calculatePath(root, target, pathList, new ArrayList<>());
        return pathList;
    }

    private void calculatePath(TreeNode node, int target, List<List<Integer>> pathList, List<Integer> path) {
        target -= node.val;
        path.add(node.val);
        if (node.left == null && node.right == null && target == 0) {
            pathList.add(path);
            return;
        }
        if (node.left != null && node.right != null) {
            List<Integer> path2 = new ArrayList<>(path);
            calculatePath(node.left, target, pathList, path);
            calculatePath(node.right, target, pathList, path2);
        } else if (node.left != null) {
            calculatePath(node.left, target, pathList, path);
        } else if (node.right != null) {
            calculatePath(node.right, target, pathList, path);
        }

    }
}
