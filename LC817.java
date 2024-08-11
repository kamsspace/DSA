// problem: 817. Linked List Components
// difficulty: medium
// time 1 hour
// runtime: 6ms, beats 95.37%
// memory: 44.69MB, beats 96.94%

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
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> s = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            s.add(nums[i]);
        }

        int c = 0, temp = 0;

        while (head != null) {

            if (s.contains(head.val)) {
                temp++;

                if (head.next == null) c++;
            } else {
                if (temp > 0) {
                    temp = 0;
                    c++;
                }
            }

            head = head.next;
        }

        return c;
    }
}
