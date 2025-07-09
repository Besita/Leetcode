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
    void recursive(TreeNode root,List<Integer> ans){
        if(root==null)
            return ;
        recursive(root.left,ans);
        recursive(root.right,ans);
        ans.add(root.val);
    }
    List<Integer> iterative(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        if(root==null)
            return ans;
        TreeNode curr=root;
        Stack<TreeNode> st=new Stack<>();       
    
        while(!st.isEmpty() || curr!=null){
            if(curr!=null){
                st.push(curr);
                ans.add(curr.val);
                curr=curr.right;
            }
            else{
                TreeNode temp=st.peek();
                st.pop();
                curr=temp.left;
            }                       
        }
        Collections.reverse(ans);
        return ans;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        /*List<Integer> ans=new ArrayList<>();
        recursive(root,ans);
        return ans;*/

        return iterative(root);
    }
}