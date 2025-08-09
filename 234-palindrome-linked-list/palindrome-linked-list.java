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
    public boolean ispalindrome(List<Integer> arr){
        int n=arr.size();
        int left=0;
        int right=n-1;
        while(left<right){
            if(arr.get(left)==arr.get(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
    public boolean usingarray(ListNode head){
        ListNode curr=head;
        List<Integer> arr=new ArrayList<>();
        while(curr!=null){
            arr.add(curr.val);
            curr=curr.next;
        }
        return ispalindrome(arr);
    }
    public boolean usingReverse(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=head;
        //find middle element if even mid element is second mid
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        prev.next=null;
        //reverse the second half
        ListNode rev=null;        
        while(slow!=null){
            ListNode nextt=slow.next;
            slow.next=rev;
            rev=slow;
            slow=nextt;
        }
        //check whether they are equal
        while(rev!=null && head!=null){
            if(rev.val==head.val){
                rev=rev.next;
                head=head.next;
            }else{
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(ListNode head) {
        //return usingarray(head);
        return usingReverse(head);       
    }
}