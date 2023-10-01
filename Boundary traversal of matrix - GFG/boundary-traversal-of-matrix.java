//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            s = in.readLine().trim().split(" ");
            int ind=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[ind++]);
                }
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.boundaryTraversal(a, n, m);
            for (int i : ans) {
                out.print(i + " ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list4 = new ArrayList<>();
        
        for(int i=0;i<m;i++){
            list1.add(matrix[0][i]);
            list2.add(matrix[n-1][i]);
        }
        for(int i=0;i<n;i++){
            list3.add(matrix[i][0]);
            list4.add(matrix[i][m-1]);
        }
        if(m==1)
            return list3;
        if(n==1)
            return list1;
        list1.remove(m-1);
        list4.remove(n-1);
        list2.remove(0);
        list3.remove(0);
        list1.addAll(list4);
        for(int i=m-2;i>=0;i--)
            list1.add(list2.get(i));
        for(int i=n-2;i>=0;i--)
            list1.add(list3.get(i));
        return list1;
    }
}
