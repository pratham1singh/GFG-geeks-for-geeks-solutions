class Solution {
    int solved[];
    public int find(int i,int nums[],int n){
        if(i==n-1)
            return 0;
        if(solved[i]!=-1)
            return solved[i];
        int ans=70000;
        for(int k=1;k<=nums[i];k++)
            ans=Math.min(ans,1+find(i+k,nums,n));
        return solved[i]=ans;
    }
    public int jump(int[] nums) {
        int n=nums.length;
        solved= new int[n];
        // Arrays.fill(solved,-1);
        for(int i=n-2;i>=0;i--){
            int ans=700000;
             for(int k=nums[i];k>=1;k--){
                if(i+k>=n)
                    ans=Math.min(ans,1);
                else
                    ans=Math.min(ans,1+solved[i+k]);
            }
            solved[i]=ans;
        }
        return  solved[0];
    }
}