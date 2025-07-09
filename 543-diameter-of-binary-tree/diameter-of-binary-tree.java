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
    int[] recursion(TreeNode root){
        if(root==null)
            return new int[]{0,0};
        int[] left=recursion(root.left);
        int[] right=recursion(root.right);

        int currdiam=left[1]+right[1];
        maxdiam=Math.max(maxdiam,currdiam);
        int maxh=1+Math.max(left[1],right[1]);

        return new int[]{currdiam,maxh};
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter=recursion(root);
        return maxdiam;
    }
}