class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        //int[] prefix=new int[n];
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        int prefix=nums[0];
        if(prefix==k)
            count++;
        map.put(0,0);
        map.put(prefix,1);
        for(int i=1;i<n;i++){
            prefix+=nums[i];
            if(prefix==k)
                count++;
            if(map.containsKey(prefix-k)){ 
                count+=map.get(prefix-k);
            }
            map.put(prefix,map.getOrDefault(prefix,0)+1);
        }
        return count;
    }
}