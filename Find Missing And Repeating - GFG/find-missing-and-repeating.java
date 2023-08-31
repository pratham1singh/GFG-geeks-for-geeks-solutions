//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
      int limit=(int)Math.pow(10,5)+1;
      int map [] =  new int[limit];
      int mx=0;
      for(int x:arr){
          map[x]+=1;
          if(x>mx)
            mx=x;
      }
      int a=0,b=0;
      for(int i=1;i<=n;i++){
          if(map[i]==0)
            b=i;
          else if(map[i]==2)
            a=i;
      }
      int ans[] = new int[2];
      ans[0]=a;
      ans[1]=b;
      return ans;
    }
}