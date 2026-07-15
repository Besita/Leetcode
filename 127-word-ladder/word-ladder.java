class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }

        if(!set.contains(endWord))
            return 0;

        Set<String> visited=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        visited.add(beginWord);
        int count=1;
        char[] alpha={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                String curr=q.poll();
                if(curr.equals(endWord))
                    return count;
                
                for(int j=0;j<curr.length();j++){
                    char[] dummy=curr.toCharArray();
                    for(int k=0;k<26;k++){
                        if(dummy[j]!=alpha[k]){
                            dummy[j]=alpha[k];
                            String newc=new String(dummy);
                            if(set.contains(newc) && !visited.contains(newc)){
                                q.add(newc);
                                visited.add(newc);
                            }
                        }
                    }
                }
            }
            count++;
        }
        return 0;
    }
}