class Solution {
    public int setSolution(int[] nums){
        int n=nums.length;
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<n;i++){ //O(n)
            //if(set.contains(nums[i]))//worstcase O(logn) avg O(1)
            //    continue;
            set.add(nums[i]);  //log(n) for add remove in treeset 
        }
        /*Integer[] arr=set.toArray(new Integer[0]);
        System.out.println(arr.length);
        if(arr.length<3)
            return arr[arr.length-1];
        return arr[arr.length-3];*/
        if(set.size()<3)
            return set.last();//last() used only in treeset/sortedset to retrive largest number
        set.remove(set.last());
        set.remove(set.last());
        return set.last();
    }
    public int bestSolution(int[] nums){
        int n=nums.length;
        long first=Long.MIN_VALUE,second=Long.MIN_VALUE,third=Long.MIN_VALUE;//test case contains intmin value
        for(int i=0;i<n;i++){
            if(nums[i]==first || nums[i]==second || nums[i]==third)
                continue;
            if(nums[i]>first){
                third=second;
                second=first;
                first=nums[i];
            }
            else if(nums[i]>second){
                third=second;
                second=nums[i];
            }
            else if(nums[i]>third)
                third=nums[i];
        }
        if(third!=Long.MIN_VALUE) //if third value is intmin testcase fails so using long
            return (int)third;//error: incompatible types: possible lossy conversion from long to int
        return (int)first;//so convert to int
    }
    public int thirdMax(int[] nums) {

        //TC:O(nlogn)
        return setSolution(nums);
        //TC O(n)
        //return bestSolution(nums);
        
    }
}