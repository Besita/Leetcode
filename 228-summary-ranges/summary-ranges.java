class Solution {
    public List<String> summaryRanges(int[] nums) {
        StringBuilder sb=new StringBuilder();
        List<String> ans=new ArrayList<>();
        int n=nums.length;
        
        if(n==0)
            return ans;
        for(int i=0;i<n;i++){ 
            int start=nums[i];
            String temp="";
            while(i+1<n && nums[i+1]==nums[i]+1){
                i++;
            }       
            int end=nums[i];
            
            if(start==end){ 
                temp+=end;
                ans.add(temp);                
            }
            else{
                temp+=start+"->"+end;
                ans.add(temp);
            }   
        }
        return ans;
    }
}