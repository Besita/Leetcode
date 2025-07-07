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

    void recursion(TreeNode root,String curr,List<String> ans){
        if(root.left==null && root.right==null)
            ans.add(curr);
        if(root.left!=null)
            recursion(root.left,curr+"->"+root.left.val,ans);
        if(root.right!=null)
            recursion(root.right,curr+"->"+root.right.val,ans);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        String curr="";        
        if(root==null)
            return ans;
        recursion(root,curr+root.val,ans);
        return ans;
    }
}