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
    boolean issame(TreeNode root,TreeNode sub){
        if(root==null && sub==null)
            return true;
        if(root==null || sub==null)
            return false;

        if(root.val!=sub.val)
            return false;

        return issame(root.left,sub.left) && issame(root.right,sub.right);
    }
    boolean recursion(TreeNode t,TreeNode s){
        if(t==null)
            return false;

        if(issame(t,s))
            return true;
        
        return recursion(t.left,s) || recursion(t.right,s);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return recursion(root,subRoot);
    }
}