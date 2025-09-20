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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode();
        dummy.next=head;

        ListNode leftPrevNode=dummy;
        ListNode currNode=leftPrevNode.next;

        for(int i=0;i<left-1;i++){
            leftPrevNode=leftPrevNode.next;
            currNode=currNode.next;
        }

        ListNode newHead=currNode;
        ListNode prevNode=null;

        for(int i=0;i<right-left+1;i++){
            ListNode nextNode=currNode.next;
            currNode.next=prevNode;
            prevNode=currNode;
            currNode=nextNode;
        }

        leftPrevNode.next=prevNode;
        newHead.next=currNode;

        return dummy.next;
    }
   
}