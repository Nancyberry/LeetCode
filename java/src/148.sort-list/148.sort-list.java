/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // divide and conquer
        ListNode slow = head;
        ListNode fast = head.next.next;     // trick

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;

        head = mergeSort(head);
        secondHead = mergeSort(secondHead);

        return mergeSortedList(head, secondHead);
    }

    public ListNode mergeSortedList(ListNode p, ListNode q) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (p != null && q != null) {
            if (p.val <= q.val) {
                tail.next = p;
                p = p.next;
            } else {
                tail.next = q;
                q = q.next;
            }
            tail = tail.next;
        }

        if (p != null) {
            tail.next = p;
        } else {
            tail.next = q;
        }

        return dummy.next;
    }
}