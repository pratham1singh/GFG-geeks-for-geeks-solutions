//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class node{
    int node,level;
    public node(int node, int level){
        this.node=node;
        this.level=level;
    }
}
class Solution
{
    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        
        
        Queue<node> queue = new LinkedList<>();
        queue.add(new node(0,0));
        int visited[] = new int[V];
        int l=1;
        visited[0]=1;
        
        while(l>0){
            
            node x= queue.remove();
            l-=1;
            // System.out.println(x.node+" "+x.level);
            if(x.node==X)
                return x.level;
            for(int a: adj.get(x.node)){
                if(visited[a]==0){
                    queue.add(new node(a,x.level+1));
                    l+=1;
                    visited[a]=1;
                }
            }
        }
        return -1;
    }
}