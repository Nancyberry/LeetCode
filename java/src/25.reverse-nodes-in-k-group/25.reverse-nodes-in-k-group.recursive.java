/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        } 
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = getLength(head);
        reverseKGroupRecur(dummy, k, len);
        return dummy.next;
    }

    public void reverseKGroupRecur(ListNode prevTail, int k, int len) {
        if (len < k) {
            return;
        }

        ListNode prev = prevTail.next;
        for (int i = 0; i < k - 1; ++i) {
            ListNode curr = prev.next;
            prev.next = curr.next;
            curr.next = prevTail.next;
            prevTail.next = curr;
        }
        reverseKGroupRecur(prev, k, len - k);
    }
    
    public int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            ++len;
            head = head.next;
        }
        return len;
    }
}
