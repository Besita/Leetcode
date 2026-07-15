class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        char[] mutt={'A','C','G','T'};
        Set<String> set=new HashSet<>();
        for(int i=0;i<bank.length;i++)
            set.add(bank[i]);

        Set<String> visited=new HashSet<>();
        
        Queue<String> q=new LinkedList<>();
        q.add(startGene);
        visited.add(startGene);
        int moves=0;

        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                String curr=q.poll();
                if(curr.equals(endGene))
                    return moves;
                //char[] dummy=curr.toCharArray();
                for(int j=0;j<startGene.length();j++){
                    char[] oldc=curr.toCharArray();
                    String currnew;
                    for(int k=0;k<4;k++){
                        if(mutt[k]!=oldc[j]){
                            oldc[j]=mutt[k];
                            currnew=new String(oldc);
                            if(set.contains(currnew) && !visited.contains(currnew)){
                                q.add(currnew);
                                visited.add(currnew);
                            }

                        }

                    }


                }

            }
            moves++;
        }
        return -1; 
    }
}