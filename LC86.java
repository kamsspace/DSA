// problem:     86. Partition List.
// difficulty:  medium
// time:        10 minutes
// runtime:     0ms, beats 100%
// memory:      41.80MB, beats 80.62%

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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode lessStart = new ListNode();
        ListNode less = lessStart;
        ListNode restStart = new ListNode();
        ListNode rest = restStart;

        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            }
            else {
                rest.next = head;
                rest = rest.next;
            }
            head = head.next;
        }
        rest.next = null;
        less.next = restStart.next;
        return lessStart.next;
    }

}
