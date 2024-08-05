// problem: 876. Middle of the Linked List
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 41.16MB, 25.57%
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
    public ListNode middleNode(ListNode head) {
        if (head == null) return head;

        ListNode begin = head;
        ListNode middleNode = new ListNode();
        int counter = 0;

        while (head != null) {
            counter++;
            if (counter % 2 == 0) {
                middleNode = begin.next;
                begin = begin.next;
            }
            else middleNode = begin;

            head = head.next;
        }
        return middleNode;
    }
}
