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
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;
        int pos = 1;
        int first = -1;
        int last = -1;
        int min = Integer.MAX_VALUE;
        while (next != null) {
            if ((curr.val > prev.val && curr.val > next.val) ||
                (curr.val < prev.val && curr.val < next.val)) {

                if (first == -1) {
                    first = pos;
                } else {
                    min = Math.min(min, pos - last);
                }

                last = pos;
            }
            prev = curr;
            curr = next;
            next = next.next;
            pos++;
        }

        if (first == -1 || first == last) {
            return new int[]{-1, -1};
        }

        int max = last - first;

        return new int[]{min, max};
    }
}