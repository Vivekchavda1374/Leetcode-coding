// Definition for a Node.
// class Node {
//     public int val;
//     public Node prev;
//     public Node next;
//     public Node child;
// }

class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        DFS(head);
        return head;
    }

    private Node DFS(Node node) {
        Node curr = node;
        Node last = null;

        while (curr != null) {
            Node next = curr.next;
            if (curr.child != null) {
                Node childTail = DFS(curr.child);
                curr.next = curr.child;
                curr.child.prev = curr;
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }
                curr.child = null;
                last = childTail;
            } else {
                last = curr;
            }
            curr = next;
        }
        return last;
    }
}