// problem: 237. Delete Node in a Linked List
// difficulty: medium
// time: 2 minutes
// runtime: 0ms, beats 100%
// memory: 43.9MB, beats 46.33%

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
