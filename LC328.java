// problem: 328. Odd Even Linked List
// difficulty: medium
// time: 5-10 minutes
// runtime: 0ms, beats 100%
// memory: 44.77MB, beats 14.58%

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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        int c = 0;
        ListNode oddGo = new ListNode();
        ListNode evenGo = new ListNode();
        ListNode odd = oddGo;
        ListNode even = evenGo;

        while (head != null) {
            c++;

            if (c % 2 == 1) {
                odd.next = head;
                odd = odd.next;
                head = head.next;
                odd.next = null;
            } else {
                even.next = head;
                even = even.next;
                head = head.next;
                even.next = null;
            }
        }

        odd.next = evenGo.next;
        return oddGo.next;
    }
}
