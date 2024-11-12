// problem: 83. Remove Duplicates from Sorted List
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 26%
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if (head == 0 || head->next == 0) return head;

        ListNode *result = new ListNode(0,head);

        while (head != 0 && head->next != 0) {
            if (head->val == head->next->val) {
                ListNode *skipNode = head->next->next;
                head->next = skipNode;
            } else {
                head=head->next;
            }
        }

        return result->next;
    }
};
