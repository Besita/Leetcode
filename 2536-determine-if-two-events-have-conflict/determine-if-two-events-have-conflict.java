class Solution {
    public boolean usingInt(String[] event1, String[] event2){
         int n=event1.length;        
        int[] meet1=new int[n];
        for(int i=0;i<n;i++){ 
            int hr=Integer.parseInt(event1[i].substring(0,2));
            int min=Integer.parseInt(event1[i].substring(3));
            int tottime=hr*60+min;
            meet1[i]=tottime;
        }

        int[] meet2=new int[n];
        for(int i=0;i<n;i++){ 
            int hr=Integer.parseInt(event2[i].substring(0,2));
            int min=Integer.parseInt(event2[i].substring(3));
            int tottime=hr*60+min;
            meet2[i]=tottime;
        }

        //System.out.println(meet1[1]+" "+meet2[0]);
        if((meet1[0]<=meet2[0] && meet1[1]>=meet2[0]) || (meet1[0]>meet2[0] && meet2[1]>=meet1[0]))
            return true;
        return false;
    }
     public boolean usingString(String[] event1, String[] event2){
        String start1=event1[0];
        String end1=event1[1];
        String start2=event2[0];
        String end2=event2[1];
        
        if((end1.compareTo(start2)<0) || (end2.compareTo(start1)<0))
            return false;
        return true;
    }
    public boolean haveConflict(String[] event1, String[] event2) {
       //return usingInt(event1,event2);
       return usingString(event1,event2);
    }
}