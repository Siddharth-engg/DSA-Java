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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half of the list
        ListNode prev = null;
        ListNode curr = slow; // slow is the head of the second half
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // Step 3: Merge the first half and reversed second half alternately
        ListNode firstHalf = head;
        ListNode secondHalf = prev; // prev is the new head of the reversed second half
        
        while (secondHalf.next != null) {
            // Keep track of next pointers
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;
            
            // Re-wire connections
            firstHalf.next = secondHalf;
            secondHalf.next = temp1;
            
            // Advance pointers
            firstHalf = temp1;
            secondHalf = temp2;
        }
    }
}
