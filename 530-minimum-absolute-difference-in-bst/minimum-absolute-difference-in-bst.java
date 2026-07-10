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
    int diff=Integer.MAX_VALUE;
    TreeNode prev=null;
    public void mindiffRecursion(TreeNode root){
        if(root==null)
            return;

        mindiffRecursion(root.left);

        if(prev!=null)
            diff=Math.min(diff,Math.abs(root.val-prev.val));
        prev=root;

        mindiffRecursion(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        if(root==null)
            return 0;
        mindiffRecursion(root);
        return diff;
    }
}