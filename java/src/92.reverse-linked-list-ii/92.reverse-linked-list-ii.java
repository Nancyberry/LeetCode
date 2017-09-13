/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m < 1 || n < 1 || m >= n) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode firstTail = dummy;

        for (int i = 1; i < m; ++i) {
            firstTail = firstTail.next;
        }
        ListNode prev = firstTail;
        ListNode curr = prev.next;
        ListNode next = null;
        for (int i = 0; i <= n - m; ++i) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        firstTail.next.next = next;
        firstTail.next = curr;
        return dummy.next;
    }
}