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
    public boolean isPalindrome(ListNode head) {
        ListNode mid=middle(head);
        ListNode headS=reverseList(mid);
        ListNode reverseHead=headS;

        while(head!=null && headS!=null){
            if(head.val!=headS.val){
                break;
            }else{
                head=head.next;
                headS=headS.next;
            }
        }
        reverseList(reverseHead);
        if(head==null || headS==null){
            return true;
        }
        return false;
    }

    private ListNode reverseList(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=curr.next;

        while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=next;
            if(next!=null){
                next=next.next;
            }
        }
        return prev;
    }

    private ListNode middle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}