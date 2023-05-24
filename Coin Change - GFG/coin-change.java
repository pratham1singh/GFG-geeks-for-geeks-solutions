//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    long arr[][];
    public long find(int coins[],int sum,int n){
            if(sum==0)
                return 1;
            else if(n<0)
                return 0;
            
            else{
                if(arr[n][sum]!=-1)
                    return arr[n][sum];
                long x=0;
                if(coins[n]>sum)
                    x=find(coins,sum,n-1);
                else 
                    x=find(coins,sum,n-1) +find(coins,sum-coins[n],n);
                arr[n][sum]=x;
                return x;
            }
    }
    public long count(int coins[], int N, int sum) {
        arr=new long [N+1][sum+1];
        for(int i=0;i<=N;i++){
            for(int j=0;j<=sum;j++){
                arr[i][j]=-1;
            }
        }
       return find(coins,sum,N-1);
    }
}