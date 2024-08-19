class Solution {
    public int count(int i,int pre,int flag,int n){
        if(i==n) return 0;
        if(i>n) return n;
        int ans=2*n;
        if(flag==1){
            ans=Math.min(ans,1+count(i+pre,pre,0,n));
        }
        else{
            if(pre!=0)
            ans=Math.min(ans,1+count(i+pre,pre,0,n));
            ans=Math.min(ans,1+count(i,i,1,n));
        }
        return ans;
    }
    public int minSteps(int n) {
        return count(1,0,0,n);
    }
}