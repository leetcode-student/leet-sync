/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> originalToCopy = new HashMap<>();

        Node curr = head;

        while (curr != null) {
            if (!originalToCopy.containsKey(curr)) {
                originalToCopy.put(curr, new Node(curr.val));
            }

            Node currCopy = originalToCopy.get(curr);
            currCopy.val = curr.val;

            if (curr.next != null) {
                if (!originalToCopy.containsKey(curr.next)) {
                    originalToCopy.put(curr.next, new Node(curr.next.val));
                }

                currCopy.next = originalToCopy.get(curr.next);

            }

            if (curr.random != null) {
                if (!originalToCopy.containsKey(curr.random)) {
                    originalToCopy.put(curr.random, new Node(curr.random.val));
                }
                
                currCopy.random = originalToCopy.get(curr.random);
            }

            curr = curr.next;
        }

        return originalToCopy.get(head);
    }
}