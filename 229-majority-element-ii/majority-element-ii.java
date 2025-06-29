class Solution {
    public List<Integer> usingHashmap(int[] nums){
        List<Integer> ans=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int thresh=n/3;
        for(Map.Entry<Integer,Integer> i:map.entrySet()){
            int val=i.getKey();
            int count=i.getValue();
            if(count>thresh)
                ans.add(val);
        }
        return ans;
    }
    public List<Integer> usingVoterAlgo(int[] nums){
        int n=nums.length;
        int freq=n/3+1;
        int count1=0,count2=0;
        int cand1=0,cand2=0;
        for(int i=0;i<n;i++){
            if(count1==0 && nums[i]!=cand2){
                cand1=nums[i];
                count1++;
            }
            else if(count2==0 && nums[i]!=cand1){
                cand2=nums[i];
                count2++;
            }
            else if(nums[i]==cand1)
                count1++;
            else if(nums[i]==cand2)
                count2++;
            else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]==cand1)
                count1++;
            else if(nums[i]==cand2)
                count2++;
        }
        if(count1>=freq)
            ans.add(cand1);
        if(count2>=freq)
            ans.add(cand2);
        return ans;
    }
    List<Integer> usingsorting(int[] nums){
        int n=nums.length;
        int freq=n/3+1;
        Arrays.sort(nums);
        int count=0;
        List<Integer> ans=new ArrayList<>();
        int currval;
        //int i=0;
        for(int i=0;i<n;){           
            currval=nums[i];
            while(i<n && nums[i]==currval){
                count++;
                i++;
            }
            if(count>=freq)
                ans.add(currval);
            count=0;           
        }
        return ans;
    }
    public List<Integer> majorityElement(int[] nums) {
       //return usingHashmap(nums);
        //return usingsorting(nums);
        return usingVoterAlgo(nums);//using Moore's voter algorithm
    }
}