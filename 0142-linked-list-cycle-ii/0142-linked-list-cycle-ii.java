/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // For this problem I first need to find length of the cycle then assign one second pointer at length then move first and second pointer by one when both are equal we find our answer
    public ListNode detectCycle(ListNode head) {

        ListNode fast=head;
        ListNode slow=head;
        int length=0;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;

            if(fast==slow){
                ListNode temp=slow;
// Finding length of the cycle
                do{
                    temp=temp.next;
                    length++;
                }while(temp!=slow);
                break;
            }
        }

        ListNode f=head;
        ListNode s=head;
        if(length==0){
            return null;
        }

        while(length!=0){
            s=s.next;
            length--;
        }

        while(f!=s){
            f=f.next;
            s=s.next;
        }

        return s;  
    }
}