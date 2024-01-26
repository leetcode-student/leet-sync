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

        Node curr = head;
        while (curr != null) {
            Node currCopy = new Node(curr.val);
            currCopy.val = curr.val;
            currCopy.next = curr.next;

            curr.next = currCopy;

            curr = curr.next.next;
        }

        curr = head;
        while (curr != null) {
            Node currCopy = curr.next;

            if (curr.random != null) {
                Node randomCopy = curr.random.next;
                currCopy.random = randomCopy;
            }
            
            curr = curr.next.next;
        }

        Node copyHead = new Node(0);
        Node copyPtr = copyHead;
        curr = head;
        while (curr != null) {
            Node currCopy = curr.next;
            curr.next = currCopy.next;
            currCopy.next = null;

            copyPtr.next = currCopy;
            copyPtr = currCopy;

            curr = curr.next;
        }

        return copyHead.next;
    }
}