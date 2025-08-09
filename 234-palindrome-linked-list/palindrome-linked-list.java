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
    public boolean isPalindrome(ListNode head) {
        return usingarray(head);
        
    }
}