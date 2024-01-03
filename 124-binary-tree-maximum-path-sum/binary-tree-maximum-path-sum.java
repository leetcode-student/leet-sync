/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }

for each root, find:
1) longest path leading up from left to the root
2) longest path leading up from right to the root
3) longest path in any subtree

 */
class Solution {
    public int maxPathSum(TreeNode root) {
        return maxPathSumHelper(root).any;
    }

    private MaxPathSum maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return null;
        }

        MaxPathSum maxPathSum = new MaxPathSum();


        MaxPathSum left = root.left != null ? maxPathSumHelper(root.left) : null;
        MaxPathSum right = root.right != null ? maxPathSumHelper(root.right) : null;

        maxPathSum.throughRoot = root.val;
        if (left != null) {
            maxPathSum.throughRoot = Math.max(maxPathSum.throughRoot, root.val + left.throughRoot);
        }
        if (right != null) {
            maxPathSum.throughRoot = Math.max(maxPathSum.throughRoot, root.val + right.throughRoot);
        }

        maxPathSum.any = root.val;
        maxPathSum.any = Math.max(maxPathSum.any, maxPathSum.throughRoot);
        maxPathSum.any = Math.max(maxPathSum.any, (left != null ? left.throughRoot : 0) + root.val + (right != null ? right.throughRoot : 0));
        if (left != null) {
            maxPathSum.any = Math.max(maxPathSum.any, left.any);
        }
        if (right != null) {
            maxPathSum.any = Math.max(maxPathSum.any, right.any);
        }

        return maxPathSum;
    }

    private static class MaxPathSum {
        private int throughRoot;
        private int any;
    }
}