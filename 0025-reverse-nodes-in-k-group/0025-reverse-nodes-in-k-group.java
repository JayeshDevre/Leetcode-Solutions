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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            // 1. Find the kth node
            ListNode kth = getKthNode(prevGroupEnd, k);
            if (kth == null) break; // not enough nodes

            // 2. Define group boundaries
            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kth.next;

            // 3. Reverse current group
            ListNode prev = nextGroupStart;
            ListNode curr = groupStart;
            while (curr != nextGroupStart) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            // 4. Connect with previous part
            prevGroupEnd.next = kth;
            prevGroupEnd = groupStart; // now groupStart is the end of this group
        }

        return dummy.next;
    }

    // Helper to find kth node from 'start'
    private ListNode getKthNode(ListNode start, int k) {
        ListNode curr = start;
        for (int i = 0; i < k; i++) {
            if (curr.next == null) return null;
            curr = curr.next;
        }
        return curr;
    }
}
