/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            length++;
        }

        int target = length - n;

        curr = head;
        ListNode prev = null;
        for (int i = 0; i < target; i++) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == head) {
            head = curr.next;
        } else {
            prev.next = curr.next;
        }
        curr.next = null;

        return head;
    }
}