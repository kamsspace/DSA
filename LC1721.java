// problem: 1721. Swap Nodes in a Linked List
// difficulty: medium
// time: 1 hour
// runtime: 4ms, beats 15.54%
// memory: 60.62MB, beats 8.94%

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
    public ListNode swapNodes(ListNode head, int k) {
        if (head.next == null) return head;

        ListNode h1 = new ListNode();
        h1.next = head;
        ListNode h2 = head;
        ListNode h3 = head;
        int c = 0, i = 0, j = 0, k2 = 0, k3 = 0;

        while (h2 != null) {
            if (++i == k) k2 = h2.val;

            h2 = h2.next;
            c++;
        }

        c = c - k + 1;
        i = 0;

        while (h3 != null) {
            if (++j == c) k3 = h3.val;
            h3 = h3.next;
        }

        j = 0;

        while (head != null) {
            if (++i == k) head.val = k3;
            if (++j == c) head.val = k2;
            head = head.next;
        }

        return h1.next;
    }
}
