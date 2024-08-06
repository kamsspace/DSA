// problem: 24. Swap Nodes in Pairs
// difficulty: medium
// runtime: 0ms, beats 100%
// memory: 41.16MB, beats 45.74%
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode res = swapPairs(head.next.next);
        ListNode swapNode = head.next;
        swapNode.next = head;
        swapNode.next.next = res;
        return swapNode;
    }
}
