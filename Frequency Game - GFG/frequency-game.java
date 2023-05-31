//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

// Position this line where user code will be pasted.

// Driver class with main function
class GFG {
    // Main function
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        // Iterating over testcases
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            int arr[] = new int[n];

            String s[]=in.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            System.out.println(obj.LargButMinFreq(arr, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// Helper class to find largest number with minimum frequency
class Solution {
    // Function to find largest number with minimum frequency
    public static int LargButMinFreq(int arr[], int n) {
        int mx=arr[0];
        for(int i=0;i<n;i++)
            if(arr[i]>mx)
                mx=arr[i];
        int arr2[] =new int[mx+1];
        for(int i=0;i<n;i++){
            arr2[arr[i]]+=1;
        }
        int mf=n+1,ans=0;
        for(int i=mx;i>0;i--){
            
            if(arr2[i]<mf&&arr2[i]!=0){
                mf=arr2[i];
                ans=i;
            }
        }
        return ans;
    }
}