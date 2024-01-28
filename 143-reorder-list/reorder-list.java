/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

get list length
put the second half on a stack
merge the lists

1,2,3,4
len=4
mid=2

1,2,3,4,5
len=5
mid=2



 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode temp = head;

        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        if (length <= 1) {
            return;
        }

        System.out.println("length=" + length);

        int secondHalfIdx = length / 2;

        ListNode firstHalfLast = head;
        for (int i = 0; i + 1 < secondHalfIdx; i++) {
            firstHalfLast = firstHalfLast.next;
        }
        ListNode secondHalfHead = firstHalfLast.next;
        firstHalfLast.next = null;

        ListNode secondHalfStack = null;
        temp = secondHalfHead;
        while (temp != null) {
            ListNode nextTemp = temp.next;
            temp.next = secondHalfStack;
            secondHalfStack = temp;
            temp = nextTemp;
        }

        System.out.println("merging...");

        ListNode headPtr = new ListNode();
        ListNode firstHalfPtr = head;
        ListNode secondHalfPtr = secondHalfStack;

        while (firstHalfPtr != null || secondHalfPtr != null) {
            System.out.println("firstHalfPtr=" + (firstHalfPtr == null ? "null" : firstHalfPtr.val));
            System.out.println("secondHalfPtr=" + (secondHalfPtr == null ? "null" : secondHalfPtr.val));
            if (firstHalfPtr != null) {
                headPtr.next = firstHalfPtr;
                headPtr = headPtr.next;
                firstHalfPtr = firstHalfPtr.next;
            }

            if (secondHalfPtr != null) {
                headPtr.next = secondHalfPtr;
                headPtr = headPtr.next;
                secondHalfPtr = secondHalfPtr.next;
            }
        }

        headPtr.next = null;
    }
}