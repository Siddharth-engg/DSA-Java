class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        // Dummy node to handle edge cases like reversing from position 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lp = dummy; // node just before the 'left' position

        // 1. Move lp to the node just before 'left'
        for (int i = 0; i < left - 1; i++) {
            lp = lp.next;
        }

        // 2. 'curr' is the first node of the sublist to be reversed
        ListNode curr = lp.next;
        ListNode prev = null;

        // 3. Reverse the sublist from 'left' to 'right'
        for (int i = 0; i < right - left + 1; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // 4. Reconnect the reversed sublist with the rest of the list
        lp.next.next = curr;
        lp.next = prev;

        return dummy.next;
    }
}
