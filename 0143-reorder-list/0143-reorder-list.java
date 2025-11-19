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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }

        //find the middle element
        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        // reverse the list from middle
        ListNode secondList=reverse(slow.next);
        slow.next=null;

        // merge the list
        ListNode firstList=head;
        while(secondList!=null){
            ListNode tmp1=firstList.next;
            ListNode tmp2=secondList.next;

            firstList.next=secondList;
            secondList.next=tmp1;

            firstList=tmp1;
            secondList=tmp2;
        }
    }

    private ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}