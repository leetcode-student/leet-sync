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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        binaryTreePaths(root, new StringBuilder(), paths);
        return paths;
    }

    private void binaryTreePaths(TreeNode root, StringBuilder currPath, List<String> paths) {
        String rootValString = Integer.toString(root.val);

        if (root.left == null && root.right == null) {
            paths.add(currPath.toString() + root.val);
            return;
        }

        currPath.append(rootValString + "->");

        if (root.left != null) {
            binaryTreePaths(root.left, currPath, paths);
        }

        if (root.right != null) {
            binaryTreePaths(root.right, currPath, paths);
        }

        for (int i = 0; i < rootValString.length() + 2; i++) {
            currPath.deleteCharAt(currPath.length() - 1);
        }
    }
}