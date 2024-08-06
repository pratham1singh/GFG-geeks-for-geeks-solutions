class node{
    int x,col,dist;
    public node(int x,int col,int dist){
        this.x=x;
        this.col=col;
        this.dist=dist;
    }
}
class Solution {

    HashMap<Integer,ArrayList<Integer>> red_adj = new HashMap<>();
    HashMap<Integer,ArrayList<Integer>> blue_adj = new HashMap<>();
    int ans[];

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
      
        ans= new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[0]=0;
        int visitedr[][]= new int[n][n];
        int visitedb[][]= new int[n][n];

        for(int i=0;i<n;i++){
            red_adj.put(i,new ArrayList<>());
            blue_adj.put(i,new ArrayList<>());
        }
        for(int x[]:redEdges)
            red_adj.get(x[0]).add(x[1]);
        for(int x[]:blueEdges)
            blue_adj.get(x[0]).add(x[1]);

    //    visited[0][0]=1;
       Queue<node> queue = new LinkedList<>();
       queue.add(new node(0,-1,0));
       while(queue.size()>0){
            node z=queue.remove();
            ans[z.x]=Math.min(z.dist,ans[z.x]);
            if(z.col!=0)
                for(int a:red_adj.get(z.x))
                    if(visitedr[z.x][a]==0){
                        visitedr[z.x][a]=1;
                        queue.add(new node(a,0,z.dist+1));
                    }
            if(z.col!=1)
                for(int a:blue_adj.get(z.x))
                    if(visitedb[z.x][a]==0){
                        visitedb[z.x][a]=1;
                        queue.add(new node(a,1,z.dist+1));
                    }
       }
       for(int i=0;i<n;i++)
        if(ans[i]==Integer.MAX_VALUE)
            ans[i]=-1;
        return ans;
    }
}