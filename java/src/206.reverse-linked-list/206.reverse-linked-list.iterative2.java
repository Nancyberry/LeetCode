/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode  prev = head;

        while (prev.next!= null) {
            // insert curr to the between of dummy and dummy.next
            ListNode curr = prev.next;
            prev.next = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
        }

        return dummy.next;
    }
}
