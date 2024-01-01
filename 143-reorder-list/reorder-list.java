/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 47 minutes

 length=4
 second half starts at 2

 length = 5
 second half starts at 3

 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode secondHalf = null;
        ListNode curr;

        curr = head;
        int nodeCount = 0;
        while (curr != null) {
            nodeCount++;
            curr = curr.next;
        }
        int secondHalfStart = (nodeCount + 1) / 2;

        curr = head;
        for (int i = 0; i < nodeCount; i++) {
            ListNode next = curr.next;
            
            if (i + 1 == secondHalfStart) {
                curr.next = null;
            } else if (i == secondHalfStart) {
                secondHalf = curr;
                curr.next = null;
            } else if (i > secondHalfStart) {
                curr.next = secondHalf;
                secondHalf = curr;
            }

            curr = next;
        }

        curr = head;
        while (curr != null) {
            if (secondHalf != null) {
                ListNode nextNext = curr.next;
                ListNode next = secondHalf;
                secondHalf = secondHalf.next;
                curr.next = next;
                next.next = nextNext;
                curr = nextNext;
            } else {
                curr = curr.next;
            }
        }
    }
}