class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode p = dummy;
        for (int i = 1; i < left; i++) p = p.next;
        ListNode cur = p.next;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = p.next;
            p.next = temp;
        }
        return dummy.next;
    }
}