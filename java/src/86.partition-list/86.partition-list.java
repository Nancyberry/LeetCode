/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);
        ListNode smallTail = smallHead;
        ListNode largeTail = largeHead;

        while (head != null) {
            if (head.val < x) {
                smallTail.next = head;
                smallTail = smallTail.next;
            } else {
                largeTail.next = head;
                largeTail = largeTail.next;
            }
            head = head.next;
        }

        smallTail.next = largeHead.next;
        largeTail.next = null;  // in case there's a loop
        return smallHead.next;
    }
}