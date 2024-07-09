class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n=dist.length,i,ans=1;
        double time[]= new double[n],t=0;

        for(i=0;i<n;i++)
            time[i]=(double)dist[i]/speed[i];
        Arrays.sort(time);

        t=1;
        i=1;

        while(i<n){
            if(time[i]>t){
                t++;
                i++;
                ans++;
            }
            else
                break;
        }
        return ans;
    }
}