//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line[] = in.readLine().trim().split("\\s+");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int l = Integer.parseInt(line[2]);
            int r = Integer.parseInt(line[3]);
            
            Solution ob = new Solution();
            System.out.println(ob.setSetBit(x, y, l, r));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int setSetBit(int x, int y, int l, int r){
        int n=0,i=0;
        while(Math.max(x,y)>Math.pow(2,i))
            i+=1;
        int arr[] = new int[i];
        n=i;
        for(i=0;i<n;i++){
            if(i+1>=l && i+1<=r){
                arr[i]=1;
            }
        }
        n=0;
        i=0;
        while(i<arr.length){
            n=n+arr[i]*(int)Math.pow(2,i);
            i+=1;
        }
        
        y=y&n;
        return x|y;
    }
}