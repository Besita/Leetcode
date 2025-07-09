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
    int maxdiam=0;
    int recursion(TreeNode root){
        if(root==null)
            return 0;
        int left=recursion(root.left);
        int right=recursion(root.right);

        maxdiam=Math.max(maxdiam,left+right);
        int maxh=1+Math.max(left,right);

        return maxh;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int maxh=recursion(root);
        return maxdiam;
    }
}