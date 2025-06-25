class Solution {
    void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    List<Integer> toArray(int[] nums){
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            ans.add(nums[i]);

        return ans;
    }
    public void backtracking(int[] nums,int curr,Set<List<Integer>> ans){
        if(curr==nums.length){
            ans.add(toArray(nums));
            return;
        }

        for(int i=curr;i<nums.length;i++){
            swap(nums,curr,i);
            backtracking(nums,curr+1,ans);
            swap(nums,curr,i);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans=new HashSet<>();
        Arrays.sort(nums);
        backtracking(nums,0,ans);
        List<List<Integer>> out=new ArrayList<>();
        for(List<Integer> i:ans)
            out.add(new ArrayList<>(i));
        return out;
    }
}