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
    int[] recursion(TreeNode root){
        if(root==null)
            return new int[]{1,0};
        int[] left=recursion(root.left);
        int[] right=recursion(root.right);

        int isbalance=0;
        if(left[0]==right[0] && left[0]==1 && Math.abs(left[1]-right[1])<=1)
            isbalance=1;
        
        int maxx=Math.max(left[1],right[1]);

        return new int[]{isbalance,1+maxx};
    }
    public boolean isBalanced(TreeNode root) {
        int[] maxheight=recursion(root);
        return maxheight[0]==1;
    }
}