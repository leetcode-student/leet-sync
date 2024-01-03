/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        NodeTracker nodeTracker = treeToDoublyListHelper(root);

        if (nodeTracker == null) {
            return null;
        }

        nodeTracker.last.right = nodeTracker.first;
        nodeTracker.first.left = nodeTracker.last;

        return nodeTracker.smallest;
    }

    private NodeTracker treeToDoublyListHelper(Node root) {
        if (root == null) {
            return null;
        }

        NodeTracker left = treeToDoublyListHelper(root.left);
        NodeTracker right = treeToDoublyListHelper(root.right);

        Node first = root;
        Node last = root;
        Node smallest = root;

        if (left != null) {
            first = left.first;
            if (left.smallest.val < smallest.val) {
                smallest = left.smallest;
            }
            root.left = left.last;
            left.last.right = root;
        }

        if (right != null) {
            last = right.last;
            if (right.smallest.val < smallest.val) {
                smallest = right.smallest;
            }
            root.right = right.first;
            right.first.left = root;
        }

        NodeTracker nodeTracker = new NodeTracker();
        nodeTracker.first = first;
        nodeTracker.last = last;
        nodeTracker.smallest = smallest;

        return nodeTracker;
    }

    private static class NodeTracker {
        Node first;
        Node last;
        Node smallest;
    }
}