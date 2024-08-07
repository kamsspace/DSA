// problem: 61. Rotate List
// difficulty: medium
// runtime: 0ms, beats 100%
// memory: 42.28MB, beats 73.20%
// time: 30 minutes (taken to solve)

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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode iNode = head;
        int counter = 0;

        while (iNode != null) {
            counter++;
            iNode = iNode.next;
        }

        if (counter == k) return head;
        else if (counter < k) {
            if (k % counter == 0) return head;
            k %= counter;
        }

        iNode = head;
        ListNode[] arrayNodes = new ListNode[counter];

        for (int i = k; i < counter; i++) {
            arrayNodes[i] = iNode;
            iNode = iNode.next;
        }

        for (int i = 0; i < k; i++) {
            arrayNodes[i] = iNode;
            iNode = iNode.next;
        }

        for (int i = 1; i < counter; i++) {
            arrayNodes[i-1].next = arrayNodes[i];
            arrayNodes[i].next = null;
        }

        return arrayNodes[0];
    }
}
