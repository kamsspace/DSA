// problem: 2074. Reverse Nodes in Even Length Groups
// difficulty: medium
// time: 1 hour
// runtime: 11ms, beats 31.03%
// memory: 64.75MB, beats 94.36%

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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head.next == null) return head;

        int odd = 1, even = 2;
        ListNode r = new ListNode();
        ListNode a = r;
        ListNode h1 = head;
        int i = 1, k = 1, j = 1, l = 2, c = 0;

        while (h1 != null) {
            h1 = h1.next;
            c++;
        }

        while (head != null) {
            ListNode prev = new ListNode();
            ListNode next = new ListNode();

            if (c > j || (c < l && c % 2 == 1)) {
                c -= j;

                while (i++ <= j && head != null) {
                    a.next = head;
                    a = a.next;
                    head = head.next;
                }
            }

            if (c > l || (c < j && c % 2 == 0)) {
                c -= l;

                while (k++ <= l && head != null) {
                    ListNode cur = new ListNode(head.val);
                    prev.next = cur;
                    cur.next = next.next;
                    next.next = prev.next;
                    head = head.next;
                }

                while (prev.next != null) {
                    a.next = prev.next;
                    prev = prev.next;
                    a = a.next;
                }
            }

            j += 2;
            l += 2;
            i = 1;
            k = 1;
        }

        return r.next;
    }
}
