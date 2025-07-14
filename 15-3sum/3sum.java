class Solution {
    public List<List<Integer>> usingSet(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        Set<List<Integer>> set=new HashSet<>();
        List<List<Integer>> ans=new ArrayList<>();
        int curr=0;
        int left;
        int right;
        for(curr=0;curr<n-2;curr++){ 
            if(nums[curr]>0)
                continue;
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
     public List<List<Integer>> handleduplicatewithoutset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        int curr=0;
        int left;
        int right;
        for(curr=0;curr<n-2;curr++){ 
            //avoid duplicates
            if(nums[curr]>0 || (curr-1>=0 && nums[curr]==nums[curr-1]))
                continue;

            left=curr+1;
            right=n-1;
            while(left<right){ 
                int sum=nums[curr]+nums[left]+nums[right];
                if(sum==0){
                    ans.add(Arrays.asList(nums[curr],nums[left],nums[right]));
                    int currleft=nums[left];
                    int currright=nums[right];
                    while(left<right && nums[left+1]==currleft) left++;
                    while(left<right && nums[right-1]==currright)   right--;
                    left++;
                    right--;
                }
                else if(sum<0)
                    left++;
                else
                    right--;
            }
        }
        
        return ans;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        //return usingSet(nums); //TC:O(n*n) SC:O(n)
        return handleduplicatewithoutset(nums); //TC:O(n*n) SC:O(1)
        
    }
}            