class Solution {
    public void recursion(int[] nums,int n,int idx,List<Integer> curr,List<List<Integer>> ans){
        if(idx==n){
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[idx]);
        recursion(nums,n,idx+1,curr,ans);
        curr.remove(curr.size()-1);
        recursion(nums,n,idx+1,curr,ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        recursion(nums,nums.length,0,curr,ans);
        return ans;
    }
}