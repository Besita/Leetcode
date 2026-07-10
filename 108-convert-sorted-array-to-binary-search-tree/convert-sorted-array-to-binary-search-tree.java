/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode build(int[] nums,int mid){
        if(nums.length==0)
            return null;

        int[] left=Arrays.copyOfRange(nums,0,mid);
        int[] right=Arrays.copyOfRange(nums,mid+1,nums.length);
        TreeNode leftt=build(left,left.length/2);
        TreeNode rightt=build(right,right.length/2);
        return new TreeNode(nums[mid],leftt,rightt);
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;
        if(n==0)
            return null;
        int mid=n/2;
        return build(nums,mid);        
    }
}