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
    TreeNode recursion(TreeNode root){
        if(root==null)
            return root;

        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;

        TreeNode left=recursion(root.left);
        TreeNode right=recursion(root.right);      
        return root;
    }
    public TreeNode invertTree(TreeNode root) {        
        return recursion(root);
    }
}