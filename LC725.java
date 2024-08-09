// problem: 725. Split Linked List Parts
// difficulty: medium
// time: 40 minutes
// runtime: 0ms, beats 100%
// memory: 43.40MB, beats 25.88%

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
    public ListNode[] splitListToParts(ListNode head, int k) {
        if (k == 1) return new ListNode[] {head};
        if (head == null) return new ListNode[k];
        
        ListNode h2 = head;
        int c = 0;

        while (h2 != null) {
            c++;
            h2 = h2.next;
        }

        int r = c % k, d = c / k;
        ListNode[] h3 = new ListNode[k];

        for (int i = 0; i < k; i++) {
            if (c <= k) {
                if (head != null) {
                    h3[i] = new ListNode(head.val);
                    head = head.next;
                } else {
                    h3[i] = null;
                }
            } else {
                ListNode te = new ListNode();
                ListNode cu = te;
                for (int j = 0; j < d; j++) {
                    cu.next = new ListNode(head.val);
                    cu = cu.next;
                    head = head.next;
                }
                if (r-- > 0) {
                    cu.next = new ListNode(head.val);
                    cu = cu.next;
                    head = head.next;
                }
                h3[i] = te.next;
            }
        }
        return h3;
    }
}
