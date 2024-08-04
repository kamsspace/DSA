// problem: 203. Remove Linked List Elements
// difficulty: easy

// runtime: 2ms, beats
// memory:

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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        
        ListNode res = new ListNode(0);
        ListNode newNode = res;

        while (head != null) {
            if (head.val == val) {
                head = head.next;
            }
            else {
                newNode.next = new ListNode(head.val);
                head = head.next;
                newNode = newNode.next;
            }
        }
        return res.next;
    }
}




// runtime: 0ms, beats 100%
// memory: 45.52MB, 31.60%

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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        if (head.val == val) {
            return removeElements(head.next, val);
        }
        else {
            ListNode newNode = head;
            newNode.next = removeElements(head.next, val);
            return newNode;
        }
    }
}
