class Solution {
    int usingHashMap(int n,int[][] pick){
        Map<Integer,Map<Integer,Integer>> map=new HashMap<>();
        for(int[] i:pick){
            map.putIfAbsent(i[0],new HashMap<>());
            map.get(i[0]).put(i[1],map.get(i[0]).getOrDefault(i[1],0)+1);
        }

        int ans=0;
        for(int i=0;i<n;i++){
            Map<Integer,Integer> curr=map.get(i);
            if(curr!=null){
                for(int val:curr.values()){
                    if(val>i){ 
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }
    int usingArray(int n,int[][] pick){
        int[][] ans=new int[n][11];//11balls
        for(int[] i:pick){
            ans[i[0]][i[1]]++;
        }
        int out=0;
        int player=0;
        for(int[] i:ans){
            for(int j:i){
                if(j>player){
                    out++;
                    break;
                }
            }
            player++;
        }
        return out;
    }
    public int winningPlayerCount(int n, int[][] pick) {
        //return usingHashMap(n,pick);
        return usingArray(n,pick);        
    }
}