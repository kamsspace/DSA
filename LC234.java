// problem: 234. Palindrome Linked List
// difficulty: easy
// runtime: 9ms, beats 28.95%
// memory: 71.86MB, beats 5.43%
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode base = head;
        ListNode pointer = head;
        ListNode middleNode = new ListNode();
        int counter = 0;

        while (head != null) {
            counter++;
            if (counter % 2 == 0) {
                middleNode = pointer.next;
                pointer = pointer.next;
            }
            else middleNode = pointer;
            head = head.next;
        }
        ListNode reversedNode = reverseList(middleNode);
        while (reversedNode != null && base != null) {
            if (reversedNode.val != base.val) return false;
            reversedNode = reversedNode.next;
            base = base.next;
        }

        return true;
    }
    public ListNode reverseList(ListNode head) {
        if ((head == null || head.next == null)) return head;
        ListNode nextNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return nextNode;
    }
}
