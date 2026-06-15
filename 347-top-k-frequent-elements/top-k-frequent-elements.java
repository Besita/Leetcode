class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());

        Collections.sort(list,(a,b)->b.getValue()-a.getValue());

        int count=0;
        int[] ans=new int[k];
        for(Map.Entry<Integer,Integer> iter:list){
            if(count<k){
                ans[count++]=iter.getKey();
            }
        }
        return ans;
    }
}