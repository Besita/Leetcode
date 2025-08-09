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
    public ListNode reverseList(ListNode head) {
        ListNode ans=null;
        ListNode res=ans;
        ListNode curr=head;
        ListNode nextt=head;
        while(curr!=null){
            nextt=curr.next;
            curr.next=ans;
            ans=curr;
            curr=nextt;
        }
        return ans;
    }
}