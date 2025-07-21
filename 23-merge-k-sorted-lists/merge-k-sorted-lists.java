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
    ListNode mergesort(ListNode node1,ListNode node2){
        ListNode curr1=node1;
        ListNode curr2=node2;
        ListNode res=new ListNode(-1);
        ListNode ans=res;
        while(node1!=null && node2!=null){
            if(node1.val<=node2.val){
                ans.next=new ListNode(node1.val);
                node1=node1.next;
            }
            else{
                ans.next=new ListNode(node2.val);
                node2=node2.next;
            }
            ans=ans.next;
        }
        while(node1!=null){
            ans.next=new ListNode(node1.val);
            node1=node1.next;
            ans=ans.next;
        }
         while(node2!=null){
            ans.next=new ListNode(node2.val);
            node2=node2.next;
            ans=ans.next;
        }
        return res.next;
    }
    public ListNode usingmergesort(ListNode[] lists){
        int k=lists.length;
       // if(k==0)    return null;
        //if(k==1)    return lists[0];

        for(int i=1;i<k;i++)
            lists[i]=mergesort(lists[i-1],lists[i]);

        return lists[k-1];
    }
    public ListNode usingsorting(ListNode[] lists){
        int n=lists.length;
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            ListNode curr=lists[i];
            while(curr!=null){
                arr.add(curr.val);
                curr=curr.next;
            }
        }       
        Collections.sort(arr);
        ListNode res=new ListNode(-1);
        ListNode ans=res;
        for(int i:arr){
            ans.next=new ListNode(i);
            ans=ans.next;
        }
        return res.next;
    }
    public ListNode usingArrays(ListNode[] lists){
        int minval=Integer.MAX_VALUE;
        int maxval=Integer.MIN_VALUE;
        int n=lists.length;
        for(int i=0;i<n;i++){
            ListNode curr=lists[i];
            while(curr!=null){
                minval=Math.min(minval,curr.val);
                maxval=Math.max(maxval,curr.val);
                System.out.println(maxval+" "+minval);
                curr=curr.next;
            }
        }
        int bucketlen=maxval-minval+1;
        System.out.println(maxval+" "+minval+" "+bucketlen);
        int[] bucket=new int[bucketlen];
        for(int i=0;i<n;i++){
            ListNode curr=lists[i];
            while(curr!=null){
                bucket[curr.val-minval]++;
                curr=curr.next;
            }
        }   
        ListNode ans=new ListNode(-1);
        ListNode res=ans;
        for(int i=0;i<bucketlen;i++){
            while(bucket[i]-- > 0){ 
                res.next=new ListNode(i+minval);
                res=res.next;
            }
        }
        return ans.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int k=lists.length;
        if(k==0)    return null;
        if(k==1)    return lists[0];

        ///return usingmergesort(lists); //memeory limit exceeded
        //return usingsorting(lists);
        return usingArrays(lists);
        
    }
}