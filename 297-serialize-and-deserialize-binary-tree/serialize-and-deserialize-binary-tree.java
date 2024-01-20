/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

[1,2,3,4,5]
[1,2,null,null,3,4,null,null,5,null,null]

[1,    2,null,null,3,    4,null,null,5,null,null]


 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();

        sb.append(root.val + ",");
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left == null) {
                sb.append("null,");
            } else {
                sb.append(node.left.val + ",");
                queue.add(node.left);
            }

            if (node.right == null) {
                sb.append("null,");
            } else {
                sb.append(node.right.val + ",");
                queue.add(node.right);
            }
        }

        sb.deleteCharAt(sb.length() - 1);

        System.out.println("serialized=" + sb.toString());

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        List<String> vals = Arrays.asList(data.split(","));
        System.out.println("vals=" + vals);

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode();
        root.val = Integer.parseInt(vals.get(0));
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();

            if (!vals.get(i).equals("null")) {
                TreeNode left = new TreeNode();
                left.val = Integer.parseInt(vals.get(i));
                parent.left = left;
                queue.add(left);
            }

            if (!vals.get(i + 1).equals("null")) {
                TreeNode right = new TreeNode();
                right.val = Integer.parseInt(vals.get(i + 1));
                parent.right = right;
                queue.add(right);
            }

            i += 2;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));