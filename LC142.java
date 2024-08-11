// problem: 142. Linked List Cycle II
// difficulty: medium
// time: 20 minutes
// runtime: 3ms, beats 13.94%

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        HashSet<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) return head; 
            else {
                set.add(head);
                head = head.next;
            }   
        }

        return null;
    }
}
