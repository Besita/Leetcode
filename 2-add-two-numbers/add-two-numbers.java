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
    public ListNode method2(ListNode l1,ListNode l2){
		ListNode ans = new ListNode(-1);
		ListNode head=ans;
		int carry=0;
		int x=0,y=0;
		while(l1!=null ||l2!=null || carry==1){
			x=(l1!=null)?l1.val:0;
			y=(l2!=null)?l2.val:0;
			int sum=x+y+carry;
			carry=sum/10;
			ListNode curr=new ListNode(sum%10);
			ans.next=curr;
			ans=ans.next;
			if(l1!=null) l1=l1.next;
			if(l2!=null) l2=l2.next;
		}   
		return head.next;
	}


    public ListNode method1(ListNode l1,ListNode l2){
        ListNode ans=new ListNode(-1);
        ListNode result=ans;
        int carry=0;
        int x=0,y=0;
        while(l1!=null || l2!=null || carry==1){
            x=(l1!=null)?l1.val:0;
            y=(l2!=null)?l2.val:0;
            if(l1!=null)    l1=l1.next;
            if(l2!=null)    l2=l2.next;

            int sum=x+y+carry;
            ListNode curr=new ListNode(sum%10);
            carry=sum/10;

            ans.next=curr;
            ans=curr;
        }
        return result.next;
    }












    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //return method2(l1,l2);
        return method1(l1,l2);
    }
}