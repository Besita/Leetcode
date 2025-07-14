class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        Set<List<Integer>> set=new HashSet<>();
        List<List<Integer>> ans=new ArrayList<>();
        int curr=0;
        int left;
        int right;
        for(curr=0;curr<n-2;curr++){ 
            left=curr+1;
            right=n-1;
            while(left<right){ 
                int sum=nums[curr]+nums[left]+nums[right];
                if(sum==0){
                    set.add(Arrays.asList(nums[curr],nums[left],nums[right]));
                    left++;
                }
                else if(sum<0)
                    left++;
                else
                    right--;
            }
        }
        for(List<Integer> i:set){
            ans.add(new ArrayList<>(i));
        }
        return ans;
    }
}            