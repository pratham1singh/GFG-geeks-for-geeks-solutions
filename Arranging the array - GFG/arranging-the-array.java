//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.Rearrange(a, n);
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n;i++)
                output.append(a[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public void Rearrange(int a[], int n)
    {
       ArrayList<Integer> list1=new ArrayList<>();
       ArrayList<Integer> list2=new ArrayList<>();
       for(Integer x:a){
           if(x>=0)
            list1.add(x);
            else
                list2.add(x);
       }
       int i=0;
       for(i=0;i<list2.size();i++)
        a[i]=list2.get(i);
        int l2=list2.size();
        for(i=i;i<n;i++)
            a[i]=list1.get(i-l2);
        
      
    }
}