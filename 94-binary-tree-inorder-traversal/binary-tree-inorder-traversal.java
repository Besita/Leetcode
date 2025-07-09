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
    void recursion(TreeNode root,List<Integer> ans){
        if(root==null)  
            return;

        recursion(root.left,ans);
        ans.add(root.val);
        recursion(root.right,ans);
    }
    List<Integer> iterative(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode curr=root;
        while(curr!=null || !st.isEmpty()){
            if(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            else{
                curr=st.peek();
                ans.add(curr.val);
                curr=curr.right;
                st.pop();
            }
        }
        return ans;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        /*List<Integer> ans=new ArrayList<>();
        recursion(root,ans);
        return ans;*/

        return iterative(root);
    }
}