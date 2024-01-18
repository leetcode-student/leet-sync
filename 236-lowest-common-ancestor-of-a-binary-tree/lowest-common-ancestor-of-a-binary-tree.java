/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

16 minutes

 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        System.out.println("root.val=" + root.val);
        if (leftLCA != null && rightLCA != null) {
            return root;
        } else if (root == p || root == q) {
            return root;
        } else if (leftLCA != null) {
            return leftLCA;
        } else if (rightLCA != null) {
            return rightLCA;
        }

        return null;
    }
}