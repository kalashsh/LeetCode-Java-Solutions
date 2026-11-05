
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode beforeA = list1;
        for (int i = 0; i < a - 1; i++) {
            beforeA = beforeA.next;
        }
        ListNode afterB = beforeA;
        for (int i = 0; i < b - a + 2; i++) {
            afterB = afterB.next;
        }
        beforeA.next = list2;
        ListNode last = list2;
        while (last.next != null) {
            last = last.next;
        }
        last.next = afterB;

        return list1;
    }
}
