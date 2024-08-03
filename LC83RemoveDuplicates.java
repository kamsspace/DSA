// problem: 83. Remove Duplicates from Sorted List
// difficulty: easy

// runtime: 0ms, beats 100%
// memory: 44.41MB, beats 5.78%

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = new ListNode(0);
        ListNode noDupl = res;
        int prevVal = head.val;
        noDupl.next = new ListNode(head.val);
        noDupl = noDupl.next;
        while (head.next != null) {
            if (prevVal == head.next.val) head = head.next;
            else {
                head = head.next;
                prevVal = head.val;
                noDupl.next = new ListNode(prevVal);
                noDupl = noDupl.next;
            }
        }
        return res.next;
    }
}
