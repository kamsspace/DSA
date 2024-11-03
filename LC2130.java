// problem: 2130. Maximum Twin Sum of a Linked List
// difficulty: medium
// runtime: 5ms, beats 71%
// memory: 5%

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
    public int pairSum(ListNode head) {
        ListNode h=new ListNode(0,head);
        int c=0;
        
        while (head != null) {
            head=head.next.next;
            c+=2;
        }

        int i=c/2;
        int[] _f=new int[i+1];
        int last=-1;
        int[] _s=new int[i+1];
        int last2=i;

        while (--i>=0) {
            _f[++last]=h.next.val;
            h=h.next;
        }

        i=c/2;

        while (--i>=0) {
            _s[--last2]=h.next.val;
            h=h.next;
        }

        int max=0,max2=0;
        i=0;
        int j=last;

        while (i<=j) {
            max=Math.max(_f[i]+_s[i++],max);
            max2=Math.max(_f[j]+_s[j--],max2);
        }

        if (max>=max2) return max;
        else return max2;
    }
}
