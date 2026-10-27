class Solution {
    public ListNode partition(ListNode head, int x) {
        // Dummy heads for two lists: < x and >= x
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);
        
        // Pointers to track the end of each list
        ListNode before = beforeHead;
        ListNode after = afterHead;
        
        // Traverse the original linked list
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        
        // Prevent cycle by terminating the 'after' list
        after.next = null;
        
        // Connect the 'before' list to the head of the 'after' list
        before.next = afterHead.next;
        
        return beforeHead.next;
    }
}
