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
 */
class Solution {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return longestUnivaluePathHelper(root).maxPath;
    }

    private PathTracker longestUnivaluePathHelper(TreeNode root) {
        PathTracker rootPath = new PathTracker();

        int maxWithRoot = 0;
        
        if (root.left != null) {
            PathTracker leftPath = longestUnivaluePathHelper(root.left);
            if (root.left.val == root.val) {
                rootPath.throughPath = Math.max(rootPath.throughPath, leftPath.throughPath + 1);
                maxWithRoot += leftPath.throughPath + 1;
            }
            rootPath.maxPath = Math.max(rootPath.maxPath, leftPath.maxPath);
        }

        if (root.right != null) {
            PathTracker rightPath = longestUnivaluePathHelper(root.right);
            if (root.right.val == root.val) {
                rootPath.throughPath = Math.max(rootPath.throughPath, rightPath.throughPath + 1);
                maxWithRoot += rightPath.throughPath + 1;
            }
            rootPath.maxPath = Math.max(rootPath.maxPath, rightPath.maxPath);
        }

        rootPath.maxPath = Math.max(rootPath.maxPath, maxWithRoot);

        return rootPath;
    }

    private static class PathTracker {
        int throughPath;
        int maxPath;
    }
}