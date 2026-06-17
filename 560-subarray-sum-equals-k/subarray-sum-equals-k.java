class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int[] prefix=new int[n];
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        prefix[0]=nums[0];
        if(prefix[0]==k)
            count++;
        map.put(prefix[0],1);
        for(int i=1;i<n;i++){
            prefix[i]=nums[i]+prefix[i-1];
            if(prefix[i]==k)
                count++;
            if(map.containsKey(prefix[i]-k)){ 
                count+=map.get(prefix[i]-k);
            }
            map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
        }
        return count;
    }
}