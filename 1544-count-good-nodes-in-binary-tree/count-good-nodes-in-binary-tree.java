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
    int recursion(TreeNode root,int max){
        if(root==null)
          return 0;   
        max=Math.max(max,root.val);
        if(root.val>=max)                  
            return 1+recursion(root.left,max)+recursion(root.right,max);
         return recursion(root.left,max)+recursion(root.right,max);
    }
    public int goodNodes(TreeNode root) {
        if(root==null)
            return 0;
        return recursion(root,root.val);
    }
}