/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

[1,2,3,4,5]
1-2-null-null-3-4-null-null-5-null-null



 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val + ",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        Queue<Integer> preOrderPath = new LinkedList<>();
        for (String val : vals) {
            if (val.equals("null")) {
                preOrderPath.add(null);
            } else {
                preOrderPath.add(Integer.parseInt(val));
            }
        }
        TreeNode root = deserialize(preOrderPath);
        return root;
    }

    private TreeNode deserialize(Queue<Integer> preOrderPath) {
        Integer nextVal = preOrderPath.poll();

        if (nextVal == null) {
            return null;
        }

        TreeNode root = new TreeNode();
        root.val = nextVal;

        TreeNode left = deserialize(preOrderPath);
        TreeNode right = deserialize(preOrderPath);

        root.left = left;
        root.right = right;

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));