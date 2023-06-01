//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    ArrayList<String> ans2=new ArrayList<>();
    Set <String> ans=new HashSet();  
    
    int r;
    public void find(int arr[][],String str,int i,int j){
        if(i==r-1&&j==r-1&&arr[i][j]==1){
            ans.add(str);
            return;
        }
        else if(i>=r||j>=r||i<0||j<0||arr[i][j]==0)
            return;
        else{
            arr[i][j]=0;
            find(arr,str+"U",i-1,j);
            find(arr,str+"D",i+1,j);
            find(arr,str+"L",i,j-1);
            find(arr,str+"R",i,j+1);
            arr[i][j]=1;
        }
    }
    public ArrayList<String> findPath(int[][] m, int n) {
      r=n;
      String str="";
      find(m,str,0,0);
      for(String x:ans){
          ans2.add(x);
      }
      return ans2;
    }
}