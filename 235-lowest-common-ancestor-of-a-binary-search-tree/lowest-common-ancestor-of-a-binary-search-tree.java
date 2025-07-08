/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode recursion(TreeNode root, TreeNode p, TreeNode q){
        if(root.val==p.val || root.val==q.val)
            return root;

        if(p.val<root.val && q.val<root.val)
            return recursion(root.left,p,q);

        if(p.val>root.val && q.val>root.val)
            return recursion(root.right,p,q);
        
        //if(p.val<root.val && q.val>root.val)
        return root;

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return root;

        return recursion(root,p,q);
    }
}