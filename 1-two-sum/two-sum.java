 
 class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();//O(N) SC
        int n=nums.length;
       // map.put(nums[0],0);
        for(int i=0;i<n;i++){ //O(n) TC
            int comp=target-nums[i];
            if(map.containsKey(comp)){ //O(1) TC
                return new int[]{i,map.get(comp)};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
