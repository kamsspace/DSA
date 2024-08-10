// problem: 160. Intersection of Two Linked Lists
// difficulty: easy
// time: 30 minutes

// solution 2
// runtime: 6ms, beats 23.58%
// memory: 47.76MB, beats 88.99%
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> map = new HashMap<>();

        while (headA != null) {
            map.put(headA, 1);
            headA = headA.next;
        }

        while (headB != null) {
            if (map.containsKey(headB)) return headB;
            headB = headB.next;
        }

        return null;
    }
}


// solution 1
// runtime: 8ms, beats 12.82%
// memory: 47.92MB, beats 82.84%
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode hA2 = headA;
        ListNode hB2 = headB;
        HashMap<ListNode, Integer> map = new HashMap<>();

        while (hA2 != null) {
            map.put(hA2, 1);
            hA2 = hA2.next;
        }

        while (hB2 != null) {
            if (map.containsKey(hB2)) return hB2;
            else {
                map.put(hB2, 1);
                hB2 = hB2.next;
            }
        }

        return null;
    }
}
