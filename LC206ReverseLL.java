// problem: 206. Reverse Linked List
// difficulty: easy

// runtime: 0ms, beats 100%
// memory: 42.17MB, beats 75.81%

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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode nextNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return nextNode;
    }
}
