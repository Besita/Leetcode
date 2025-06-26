class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        int left=0;
        int mid=0;
        for(int right=0;right<nums.length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            while(map.size()>k){
                map.put(nums[mid],map.get(nums[mid])-1);
                if(map.get(nums[mid])==0)
                    map.remove(nums[mid]);
                mid++;
                left=mid;
            }

            while(map.get(nums[mid])>1){
                map.put(nums[mid],map.get(nums[mid])-1);
                mid++;
            }
            if(map.size()==k)
                ans+=mid-left+1;
        }
        return ans;
    }
}