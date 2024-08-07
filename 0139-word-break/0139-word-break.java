class Solution {
    HashMap<String,Boolean> dict = new HashMap<>();
    String s;
    int n,solved[];
    public boolean find(int i){
        if(i==n)
            return true;
        if(solved[i]!=-1) return solved[i]==1;
        boolean ans=false;
        for(int j=i;j<n;j++)
            if(dict.get(s.substring(i,j+1))!=null)
                ans=ans||find(j+1);
        solved[i]=ans?1:0;
        return ans;
            
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        for(String str:wordDict)
            dict.put(str,true);
        this.s=s;
        n=s.length();
        solved= new int[n];
        Arrays.fill(solved,-1);
        return find(0);
    }
}