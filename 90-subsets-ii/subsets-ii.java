class Solution {
    void backtracking(int[] nums,int idx,List<Integer> curr,List<List<Integer>> ans){
        if(idx==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[idx]);
        backtracking(nums,idx+1,curr,ans);
        curr.remove(curr.size()-1);
        while(idx+1<nums.length && nums[idx]==nums[idx+1])
            idx++;
        backtracking(nums,idx+1,curr,ans);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums,0,curr,ans);
        return ans;
    }
}