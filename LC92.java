// problem: 92. Reverse Linked List II
// difficulty: medium
// time: 2 hours
// runtime: 0ms, beats 100%
// memory: 40.94MB, beats 78.74%
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null) return head;

        ListNode letsGo = new ListNode();
        ListNode reversedNode = letsGo;
        ListNode prev = null;
        int counter = 1;

        while (head != null) {
            while (counter >= left && counter <= right) { // while loop reverses the string
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
                counter++;
            }
            if (counter < left) {
                reversedNode.next = head;
                reversedNode = reversedNode.next;
                head = head.next;
                counter++;
            }
            if (counter > right) {
                break;
            }
        }

        reversedNode.next = prev;
        while (prev.next != null) prev = prev.next;
        prev.next = head;

        return letsGo.next;
    }
}
