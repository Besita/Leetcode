class Solution {
    public int[] usingHashmap(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());

        Collections.sort(list,(a,b)->b.getValue()-a.getValue());

        int count=0;
        int[] ans=new int[k];
        for(Map.Entry<Integer,Integer> iter:list){            
            ans[count++]=iter.getKey();
            
            if(count==k)
                break;
        }
        return ans;
    }
    public int[] usingBucketsort(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        List<Integer>[] bucket=new ArrayList[n+1];
        for(Map.Entry<Integer,Integer> iter : map.entrySet()){
            if(bucket[iter.getValue()] == null)
                bucket[iter.getValue()]=new ArrayList<>();
            bucket[iter.getValue()].add(iter.getKey());
        }

        int[] ans=new int[k];
        for(int i=n,count=0;i>0 && count<k;i--){
            if(bucket[i]!=null){
                List<Integer> curr=bucket[i];
                for(int val:curr)
                    ans[count++]=val;
            }
        }
        return ans;
    }

    public int[] topKFrequent(int[] nums, int k) {
        return usingHashmap(nums,k);//15 ms

        //return usingBucketsort(nums,k);//12 ms
        
    }
}