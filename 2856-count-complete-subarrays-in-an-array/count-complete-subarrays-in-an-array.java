class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int distinct=map.size();
        map.clear();
        int count=0,left=0,right=0;
        int n=nums.length;
        for(right=0;right<n;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.size()==distinct){
                count+=n-right;
                if(map.get(nums[left])==1)
                    map.remove(nums[left]);
                else
                    map.put(nums[left],map.get(nums[left])-1);
                left++;
            } 
        }
        return count;
    }
}