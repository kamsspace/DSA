// problem: 82. Remove Duplicates from Sorted List II
// difficulty: medium
// runtime: 0ms, beats 100%
// memory: 42.9MB, beats 65.84%
// time: 1-2 hours (taken to solve the problem)

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
        ListNode result = new ListNode(0, head);
        ListNode move = result;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                move.next = head.next;
            } else {
                move = move.next;
            }
            head = head.next;
        }
        return result.next;
    }
}
