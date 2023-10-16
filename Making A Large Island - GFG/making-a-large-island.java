//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[][] grid = IntMatrix.input(br, n, n);
            
            Solution obj = new Solution();
            int res = obj.largestIsland(n, grid);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class node{
    int i,j;
    public node(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution{
    public int largest_island(int i,int j,int grid[][],int visited[][],int id){
        int n=grid.length,m=grid[0].length;
        Queue<node> queue = new LinkedList<>();
        Queue<node> list1 = new LinkedList<>();
        queue.add(new node(i,j));
        visited[i][j]=1;
        int l=1,ans=0,l2=0;
        
        while(l>0){
            node x=queue.remove();
            list1.add(x);
            l2+=1;
            l-=1;
            ans+=1;
            
            if(x.i+1<n && visited[x.i+1][x.j]==0&& grid[x.i+1][x.j]==1){
                queue.add(new node(x.i+1,x.j));
                l+=1;
                visited[x.i+1][x.j]=1;
                
            }
            if(x.j+1<m && visited[x.i][x.j+1]==0&& grid[x.i][x.j+1]==1){
                queue.add(new node(x.i,x.j+1));
                l+=1;
                visited[x.i][x.j+1]=1;
                
            }
            if(x.i-1>=0 && visited[x.i-1][x.j]==0&& grid[x.i-1][x.j]==1){
                queue.add(new node(x.i-1,x.j));
                l+=1;
                visited[x.i-1][x.j]=1;
                
            }
            if(x.j-1>=0 && visited[x.i][x.j-1]==0&& grid[x.i][x.j-1]==1){
                queue.add(new node(x.i,x.j-1));
                l+=1;
                visited[x.i][x.j-1]=1;
                
            }
        }
        while(l2>0){
            node x=list1.remove();
            grid[x.i][x.j]=id;
            l2-=1;
        }
        return ans;
        
    }
    public int largestIsland(int N,int[][] grid) 
    {
        int ans=0,n=grid.length,m=grid[0].length, visited[][]= new int[n][m],id=2;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1&&visited[i][j]==0){
                  int x=largest_island(i,j,grid,visited,id);
                  map.put(id,x);
                  id+=1;
                    
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    int c=0;
                    HashMap<Integer,Integer> map2 = new HashMap<>();
                    if(i+1<n && visited[i+1][j]==1&&map2.get(grid[i+1][j])==null){
                        c+=map.get(grid[i+1][j]);
                        map2.put(grid[i+1][j],1);
                    }
                        
                    if(j+1<m && visited[i][j+1]==1&&map2.get(grid[i][j+1])==null){
                        c+=map.get(grid[i][j+1]);
                        map2.put(grid[i][j+1],1);
                    }
                        
                    
                    if(i-1>=0 && visited[i-1][j]==1&&map2.get(grid[i-1][j])==null){
                        c+=map.get(grid[i-1][j]);
                        map2.put(grid[i-1][j],1);
                    }
                        
                    if(j-1>=0 && visited[i][j-1]==1&&map2.get(grid[i][j-1])==null){
                        c+=map.get(grid[i][j-1]);
                        map2.put(grid[i][j-1],1);
                    }
                        
                    ans=Math.max(ans,c+1);
                }
            }
        }
        if(ans>0)
        return ans;
        return map.get(grid[0][0]);
        
    }
}
