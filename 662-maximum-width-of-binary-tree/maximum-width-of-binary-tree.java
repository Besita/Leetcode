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
class Pair{
    TreeNode node;
    int val;
    Pair(TreeNode node,int val){
        this.node=node;
        this.val=val;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int levelleft=0;
        int levelright=0;
        int maxwidth=0;
        while(!q.isEmpty()){
            int n=q.size();
            levelleft=q.peek().val;
            for(int i=0;i<n;i++){ 
                Pair temp=q.poll();
                TreeNode curr=temp.node;
                int num=temp.val;
                if(curr.left!=null){
                    q.add(new Pair(curr.left,2*num+1));
                }
                if(curr.right!=null){
                    q.add(new Pair(curr.right,2*num+2));
                }
                levelright=temp.val;                
            }  
            maxwidth=Math.max(maxwidth,levelright-levelleft+1);
        }
        return maxwidth;        
    }
}