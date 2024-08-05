// problem: 19. Remove Nth Node from the List
// difficulty: medium
// runtime: 0ms, beats 100%
// memory: 41.44MB, beats 69.71%

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
        ListNode begin = head;
        int counter = 0;

        while (head != null) {
            counter++;
            head = head.next;
        }

        head = new ListNode(0);
        ListNode res = head;

        int pos = counter - n;

        while (pos-- > 0) {
            res.next = begin;
            res = res.next;
            begin = begin.next;
        }

        res.next = begin.next;
        return head.next;
    }
}
