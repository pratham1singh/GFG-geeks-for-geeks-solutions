//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class node{
    int i,j;
    public node(int i,int j){
        this.i=i;
        this.j=j;
    }
}


class Solution {
    
    int numberOfEnclaves(int[][] grid) {
    
      int n=grid.length,m=grid[0].length,l=0,ones=0,count=0;
      int visited[][]=new int[n][m];
      Queue<node> queue = new LinkedList<>();
      
      for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
              if(grid[i][j]==1&&(i==0||i==n-1||j==0||j==m-1)){
                  visited[i][j]=1;
                  queue.add(new node(i,j));
                  l+=1;
                  
              }
              if(grid[i][j]==1)
                ones+=1;
          }
      }
      while(l>0){
            
            
            node x= queue.poll();
            count+=1;
            l-=1;
            
             if(x.i>0&&visited[x.i-1][x.j]==0&&grid[x.i-1][x.j]==1){
                queue.add(new node(x.i-1,x.j));
                l+=1;
                visited[x.i-1][x.j]=1;
            }
             if(x.j>0&&visited[x.i][x.j-1]==0&&grid[x.i][x.j-1]==1){
                queue.add(new node(x.i,x.j-1));
                l+=1;
                visited[x.i][x.j-1]=1;
            }
            if(x.i<n-1&&visited[x.i+1][x.j]==0&&grid[x.i+1][x.j]==1){
                queue.add(new node(x.i+1,x.j));
                l+=1;
                visited[x.i+1][x.j]=1;
            }
             if(x.j<m-1&&visited[x.i][x.j+1]==0&&grid[x.i][x.j+1]==1){
                queue.add(new node(x.i,x.j+1));
                l+=1;
                visited[x.i][x.j+1]=1;
            }
        }
       
      
      return ones-count;
    }
}