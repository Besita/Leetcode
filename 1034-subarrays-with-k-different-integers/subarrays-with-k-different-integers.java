class Solution {
    int using3pointer(int[] nums,int k){
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
            
            if(map.size()==k){ 
                while(map.get(nums[mid])>1){
                    map.put(nums[mid],map.get(nums[mid])-1);
                    mid++;
                }
                ans+=mid-left+1;
            }
        }
        return ans;
    }
    int using2pointer(int[] nums,int k){
        int left=0;
        int count=0;
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int right=0;right<nums.length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            while(map.size()>k){
                map.put(nums[left],map.getOrDefault(nums[left],0)-1);
                if(map.get(nums[left])==0)
                    map.remove(nums[left]);
                left++;
            }

            count+=right-left+1;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return using3pointer(nums,k);
        //return using2pointer(nums,k)-using2pointer(nums,k-1);
    }
}