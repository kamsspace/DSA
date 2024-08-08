// problem: 1290. Convert Binary Number in a Linked List to Integer.
// difficulty: easy
// time: 20 minutes
// runtime: 0ms, beats 100%
// memory: 40.67MB, beats 93.35%

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
    public int getDecimalValue(ListNode head) {
        int decVal = 0;
        while (head != null) {
            decVal = (2 * decVal + head.val);
            head = head.next;
        }
        return decVal;
    }
}
