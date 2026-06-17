class Solution {
    public int mostFrequentEven(int[] nums) {
        int n=nums.length;
        //int bucket=n+1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }

        List<Integer>[] bucket=new ArrayList[n+1];
        for(int key:map.keySet()){
            int count=map.get(key);
            if(bucket[count]==null){
                bucket[count]=new ArrayList();
            }
            bucket[count].add(key);
        }

        int ans=Integer.MAX_VALUE;
        for(int i=n;i>0;i--){
            if(bucket[i]!=null){
                int sz=bucket[i].size();
                for(int j=0;j<sz;j++){
                    ans=Math.min(ans,bucket[i].get(j));
                }
                break;
            }
        }
        return (ans==Integer.MAX_VALUE?-1:ans);
    }
}