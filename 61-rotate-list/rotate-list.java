/* Definition for singly-linked list.
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
        // Handle edge cases
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find the length of the list and the tail node
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Connect tail to head to make a circular linked list
        tail.next = head;

        // Find the new tail position: (length - k % length) steps from head
        int stepsToNewTail = length - (k % length);
        ListNode newTail = tail;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // The node after newTail will be the new head
        ListNode newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }
}