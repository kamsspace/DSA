// problem: 143. Reorder List
// difficulty: medium
// time: 2 hours
// runtime: 2ms, beats 83.10%
// memory: 48.44MB, beats 18.67%

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
    public void reorderList(ListNode head) {
        if (head.next == null);
        else {
            ListNode evenGo = new ListNode();
            ListNode even = evenGo;
            ListNode oddGo = new ListNode();
            ListNode odd = oddGo;
            ListNode lastGo = new ListNode();
            ListNode last = lastGo;
            int c = 0;
            ListNode rev = null;
            ListNode newHead = head;

            while (newHead != null) {
                newHead = newHead.next;
                c++;
            }

            int i = 1;
            int size;
            if (c % 2 == 1) size = c / 2 + 1;
            else size = c / 2;

            while (i <= c) {
                if (i <= size) {
                    odd.next = head;
                    head = head.next;
                    odd = odd.next;
                    odd.next = null;
                }
                if (i > size){
                    even.next = head;
                    head = head.next;
                    even = even.next;
                    even.next = null;
                }
                i++;
            }

            even = evenGo.next;

            while (even != null) {
                ListNode next = even.next;
                even.next = rev;
                rev = even;
                even = next;
            }

            odd = oddGo.next;
            i = 1;

            while (i <= c) {
                if (i % 2 == 1) {
                    last.next = odd;
                    odd = odd.next;
                }
                if (i % 2 == 0) {
                    last.next = rev;
                    rev = rev.next;
                }

                last = last.next;
                i++;
            }

            last.next = null;
            head = lastGo.next;
        }
    }
}
