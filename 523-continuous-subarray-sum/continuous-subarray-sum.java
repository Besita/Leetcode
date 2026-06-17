class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        //edgecase for k==0 follow-up question
        if(k==0){
            for(int i=1;i<nums.length;i++){
                if(nums[i]==0 && nums[i-1]==0)
                    return true;
            }
            return false;
        }
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int prefix=0;
        map.put(0,-1);
        for(int i=0;i<n;i++){
            prefix+=nums[i];
            int curr=prefix%k;
            if(map.containsKey(curr) && (i-map.get(curr)>=2))
                return true;
            
            map.putIfAbsent(curr,i);
        }
        return false;
    }
}