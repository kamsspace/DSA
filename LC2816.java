// problem: 2816. Double a Number Represented as Linked List
// difficulty: medium
// time: 1 hour
// runtime: 2ms, beats 99.49%
// memory: 46.64MB, beats 45.94%

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
    public ListNode doubleIt(ListNode head) {
        ListNode r = new ListNode();
        int a = head.val * 2;

        if (a > 9) {
            r.next = new ListNode(a / 10);
            r.next.next = head;
        } else r.next = head;

        while (head != null) {
            a = head.val * 2;
            
            if (a > 9) head.val = a % 10;
            else head.val = a;

            if (head.next != null) if (head.next.val > 4) head.val = head.val + 1;

            head = head.next;
        }

        return r.next;
    }
}
