class Solution {
    public void swap(int[] nums,int a,int b){
        int curr=nums[a];
        nums[a]=nums[b];
        nums[b]=curr;
    }
    public void reverse(int[] nums, int a,int b){
        while(a<b){
            swap(nums,a,b);
            a++;
            b--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int idx=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){ 
                idx=i;
                break;
            }
        }

        if(idx>=0){
            int curr=nums[idx];
            for(int i=n-1;i>idx;i--){
                if(nums[i]>curr){ 
                    swap(nums,i,idx);
                    break;
                }
            }
        }

        reverse(nums,idx+1,n-1);        
    }
}