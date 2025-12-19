class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int sumgas=Arrays.stream(gas).sum();
        int sumcost=Arrays.stream(cost).sum();
        if(sumgas<sumcost)
            return -1;

        int currentgas=0;
        int start=0;
        //there will be one unique solution, so iterate through once and check till 0-n
        for(int i=0;i<n;i++){
            currentgas+=gas[i]-cost[i];
            if(currentgas<0){
                currentgas=0;
                start=i+1; 
            }   
        }
        return start;

        /*//if there's no unique solution then there can be multiple start points so we can iterate a while loop 
        //since here there is a unique solution there can only one start point so just check firm i=0-n no need for while
        for(int i=0;i<n;i++){
            currentgas=0;
            start=i;
            int curr=i;
            travelleddist=0;
            while(currentgas+gas[curr]-cost[curr]>=0){
                currentgas+=gas[curr]-cost[curr];
                travelleddist++;
                curr++;
                curr=curr%n;
                if(travelleddist==n)
                    return start;
            }   

        }
        return -1;*/



    }
}