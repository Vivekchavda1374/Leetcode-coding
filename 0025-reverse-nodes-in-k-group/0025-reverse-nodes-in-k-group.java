class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode tail = head;
        int count = 0;
        while (tail != null && count < k) {
            tail = tail.next;
            count++;
        }
        if (count < k) return head;
        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup(tail, k); 
        return newHead;
    }

    private ListNode reverse(ListNode cur, ListNode end) {
        ListNode prev = null;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
