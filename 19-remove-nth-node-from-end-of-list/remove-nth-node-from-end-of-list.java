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
    public ListNode removeNthFromEnd(ListNode head, int n) {
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
}