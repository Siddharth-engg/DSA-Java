/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        Map<Node, Node> oldToNew = new HashMap<>();
        Node curr = head;
        
        // First pass: create all the new nodes and store the mapping
        while (curr != null) {
            oldToNew.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        // Second pass: assign next and random pointers for each copy
        curr = head;
        while (curr != null) {
            Node copy = oldToNew.get(curr);
            copy.next = oldToNew.get(curr.next);
            copy.random = oldToNew.get(curr.random);
            curr = curr.next;
        }
        
        return oldToNew.get(head);
    }
}
