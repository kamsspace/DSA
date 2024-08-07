// problem: 25. Reverse Node in k-Group
// difficulty: hard
// runtime: 0ms, beats 100%
// memory: 44.65MB, 7.22%
// time: ~ 1-2 hours (taken to solve the problem)

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;

        ListNode chunkNode = new ListNode();
        ListNode mover = chunkNode;
        int i = k;

        while (i-- > 0 && head != null) {
            mover.next = head;
            head = head.next;
            mover = mover.next;
        }

        mover.next = null;
        ListNode result = new ListNode();
        ListNode reversedNode = result;
      
        if (i == -1) {
            reversedNode.next = reverseList(chunkNode.next);

            while (reversedNode.next != null) {
                reversedNode = reversedNode.next;
            }

            reversedNode.next = reverseKGroup(head, k);
        } else {
            reversedNode.next = chunkNode.next;
        }

        return result.next;
    }
    
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode nextNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return nextNode;
    }
}
