//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean lemonadeChange(int N, int bills[]) {
       int i=0;
       HashMap <Integer,Integer> map = new HashMap<>();
       map.put(5,0);
       map.put(10,0);
       map.put(20,0);
       
       while(i<N){
           if(bills[i]==5){
               map.put(5,map.get(5)+1);
           }
           else if(bills[i]==10){
               if(map.get(5)>0){
                   map.put(5,map.get(5)-1);
                   map.put(10,map.get(10)+1);
               }
               else{
                   return false;
               }
           }
           else{
               if(map.get(5)>0 && map.get(10)>0){
                    map.put(5,map.get(5)-1);
                    map.put(10,map.get(10)-1);
                    map.put(20,map.get(20)+1);
               }
               else if(map.get(5)>2){
                   map.put(5,map.get(5)-3);
                   map.put(20,map.get(20)+1);
               }
               else
                  return false;
           }
           i+=1;
       }
       return true;
    }
}
