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
    public long kthLargestLevelSum(TreeNode root, int k) {

        TreeNode curr=root;
        int level=1;
        Queue<TreeNode> q=new LinkedList<>();
        PriorityQueue<Long> maxheap=new PriorityQueue<>(Collections.reverseOrder());
        q.add(curr);
        while(!q.isEmpty()){
            int levelsize=q.size();
            long levelsum=0;
            for(int i=0;i<levelsize;i++){
                TreeNode node=q.poll();
                levelsum+=node.val;
                //q.pop();
                if(node.left!=null)
                    q.add(node.left);
                
                if(node.right!=null)
                    q.add(node.right);      
            }
            maxheap.offer(levelsum);
            //System.out.print(" "+levelsum);
        }
        int itr=1;
        while(!maxheap.isEmpty()){
            long ans= maxheap.poll();
            if(itr==k){                
                return ans;
            }
            itr++;
        }
        return -1;
    }
}
