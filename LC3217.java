// problem: 3217. Delete Nodes from Linked List Present in Array
// difficulty: medium
// time: 20 minutes
// runtime: 20ms, beats 87.10%
// memory: 66.49MB, beats 29.56%

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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode r = new ListNode();
        ListNode a = r;

        for (int i : nums) set.add(i);

        while (head != null) {
            if (!(set.contains(head.val))) {
                a.next = head;
                a = a.next;
            }

            head = head.next;
        }

        a.next = null;
        return r.next;
    }
}
