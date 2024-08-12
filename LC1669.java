// problem: 1669. Merge In Between Linked Lists
// difficulty: medium
// time: 30 minutes
// runtime: 2ms, beats 33.43%
// memory: 46.16MB, beats 88.15%

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode l3 = new ListNode();
        ListNode go = l3;

        while (b-- >= 0) {
            if (a-- > 0) {
                go.next = list1;
                go = go.next;
            }
            list1 = list1.next;
        }

        while (list2 != null) {
            go.next = list2;
            list2 = list2.next;
            go = go.next;
        }

        go.next = list1;
        return l3.next;
    }
}
