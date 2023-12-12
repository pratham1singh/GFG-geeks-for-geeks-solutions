//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    int arr[],N,visited[][];
    public int find(int i,int j){
        if(i==j)
            return 0;
        else if(i+1==j)
            return arr[i]*arr[j]*arr[j+1];
        else if(visited[i][j]!=0)
            return visited[i][j];
        else{
            int ans=2147483647;
            for(int k=i;k<j;k++){
                int l=find(i,k);
                int r=find(k+1,j);
                ans=Math.min(l+r+arr[i]*arr[k+1]*arr[j+1],ans);
            }
            visited[i][j]=ans;
            return visited[i][j];
        }
    }
    public int matrixMultiplication(int N, int arr[])
    {
        this.N=N;
        this.arr=arr;
        this.visited= new int[N+1][N+1];
        return find(0,N-2);
    }
}