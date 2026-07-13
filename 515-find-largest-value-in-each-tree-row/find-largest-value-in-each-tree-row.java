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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)
            return ans;
        q.add(root);
        while(!q.isEmpty()){
            int levelsz=q.size();
            int maxval=Integer.MIN_VALUE;
            for(int i=0;i<levelsz;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
                maxval=Math.max(maxval,curr.val);
            }
            ans.add(maxval);
        }
        return ans;
    }
}