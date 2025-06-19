class Solution {
    void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public List<Integer> arraytoList(int[] nums){
        List<Integer> ans=new ArrayList<>();
        for(int i:nums)
            ans.add(i);
        return ans;
    }
    public void backtracking(int[] nums,int n,int curr,List<List<Integer>> ans){
        if(curr==n){
            ans.add(arraytoList(nums));
            return;
        }    
        for(int i=curr;i<n;i++){
            swap(nums,curr,i);
            backtracking(nums,n,curr+1,ans);
            swap(nums,curr,i);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        backtracking(nums,nums.length,0,ans);
        return ans;
    }
}