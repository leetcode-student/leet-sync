/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

Brute Force

For each element in output list
    Scan all lists for the list with smallest element

Time: O(n * k)
extra space: O(k)

Store the lists into min heap

time: O(n * log(k))
Space: O(k)

Divide lists into two halves. Merge the first half, then merge the second half. Then merge two merged lists.

time: O(n * log(k))
extra space: O(log(k))

Divide and conquer with constant space

Merge each pair of lists at the front until there's one list left

time: O(n * log(k))

 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        for (int i = 0; i + 1 < lists.length; i++) {
            ListNode subMerge = mergeLists(lists[i], lists[i + 1]);
            lists[i + 1] = subMerge;
        }
        
        return lists[lists.length - 1];
    }

    public ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode();
        ListNode curr = merged;

        while (list1 != null || list2 != null) {
            if (list2 == null || (list1 != null && list1.val <= list2.val)) {
                ListNode next = list1;
                
                list1 = list1.next;
                next.next = null;
                curr.next = next;
                curr = curr.next;
            } else {
                ListNode next = list2;
                
                list2 = list2.next;
                next.next = null;
                curr.next = next;
                curr = curr.next;
            }
        }

        return merged.next;
    }
}