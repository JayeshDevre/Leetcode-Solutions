class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        // 1. Find the length and last node
        int length = 1;
        ListNode lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            length++;
        }

        // 2. Effective rotations
        k = k % length;
        if (k == 0) return head;

        // 3. Make it circular
        lastNode.next = head;

        // 4. Find new tail: (length - k - 1) steps
        int stepsToNewTail = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // 5. New head = newTail.next
        ListNode newHead = newTail.next;
        newTail.next = null; // break the cycle

        return newHead;
    }
}
