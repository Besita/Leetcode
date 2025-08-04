class Solution {
    public int subarraySum(int[] nums, int k) {
        int currsum=0;
        int left=0;
        int n=nums.length;
        int count=0;
        int[] prefix=new int[n];
        Map<Integer,Integer> map=new HashMap<>();
        prefix[0]=nums[0];
        for(int i=1;i<n;i++)
            prefix[i]=nums[i]+prefix[i-1];
        
        for(int i=0;i<n;i++){
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