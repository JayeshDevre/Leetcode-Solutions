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
        ListNode mid=middle(head);
        ListNode headS=reverseList(mid);
        ListNode headF=head;
        while(headF!=null && headS!=null){
            ListNode temp=headF.next;
            headF.next=headS;
            headF=temp;

            temp=headS.next;
            headS.next=headF;
            headS=temp;
        }
        if(headF!=null){
            headF.next=null;
        }
    }
    
    private ListNode reverseList(ListNode head){
        ListNode prev=null;
        ListNode present=head;
        while(present!=null){
            ListNode next=present.next;
            present.next=prev;
            prev=present;
            present=next;
        }
        return prev;
    }
    
    private ListNode middle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}