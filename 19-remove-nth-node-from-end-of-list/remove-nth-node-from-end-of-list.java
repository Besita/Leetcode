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
    public int findLength(ListNode head){
        ListNode curr=head;
        int length=0;
        while(curr!=null){
            curr=curr.next;
            length++;
        }
        return length;
    }
    public ListNode twopass(ListNode head,int n){
        int length=findLength(head);
        int todelete=length-n;
        if(todelete==0)
            return head.next;
        int curridx=0;
        ListNode curr=head;
        while(curr!=null){
            curridx++;
            if(curridx==todelete){
                curr.next=curr.next.next;
                break;
            }
            curr=curr.next;
        }
        return head; 
    }
    public ListNode onepass(ListNode head,int n){
        ListNode fast=head;
        ListNode slow=head;
        for(int i=0;i<n;i++)
            fast=fast.next;

        if(fast==null)  //first element
            return head.next;
        while(fast!=null && fast.next!=null){ //middle elements
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //ListNode twopass(head,n); //0ms
        return onepass(head,n);
       
    }
}