// problem: 21. Merge Two Sorted Lists
// difficulty: easy

// runtime: 1ms, beats 100%
// memory: 42.53MB, beats 27.72%

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list3 = new ListNode(0);
        ListNode current = list3;

        while (list1 != null || list2 != null) {
            boolean wait1 = true;
            boolean wait2 = true;

            if (list1 == null && list2 != null) {
                current.next = list2;
                return list3.next;
            }
            if (list2 == null && list1 != null){
                current.next = list1;
                return list3.next;
            }
            int a = (list1 != null) ? list1.val : 0;
            int b = (list2 != null) ? list2.val : 0;
            if (a <= b) {
                current.next = new ListNode(a);
                wait2 = false;
//                if (list2 == null) current.next.next = list1;
//                else current.next.next = new ListNode(b);
            } else {
                current.next = new ListNode(b);
                wait1 = false;
//                if (list1 == null) current.next.next = list2;
//                else current.next.next = new ListNode(a);
            }

            current = current.next;

            if (list1 != null && wait1) list1 = list1.next;
            if (list2 != null && wait2) list2 = list2.next;
        }

        return list3.next;
    }
}
