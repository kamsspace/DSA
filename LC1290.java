// LeetCode problem: 1290. Convert Binary Number in a Linked List to Integer
// difficulty: easy
// time: O(n)
// space: O(1)

// VERSION 2
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
    public int getDecimalValue(ListNode head) {
        int r = 0;

        while (head != null) {
            r <<= 1;
            if (head.val == 1) {
                r |= 1;
            }
            head = head.next;
        }

        return r;
    }
}

// VERSION 1
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
    public int getDecimalValue(ListNode head) {
        int decVal = 0;
        while (head != null) {
            decVal = (2 * decVal + head.val);
            head = head.next;
        }
        return decVal;
    }
}
