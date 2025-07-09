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
    int maxsum=Integer.MIN_VALUE;
    int recursion(TreeNode root){
        if(root==null)
            return 0;
        int left=recursion(root.left);
        int right=recursion(root.right);
        if(left<0)
            left=0;
        if(right<0)
            right=0;

        maxsum=Math.max(maxsum,left+right+root.val);
        
        return root.val+Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        recursion(root);
        return maxsum;
    }
}