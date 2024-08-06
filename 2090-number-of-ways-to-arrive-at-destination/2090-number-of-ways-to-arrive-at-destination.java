class node{
    int x;
    long cost;
    public node(int x,long cost){
        this.x=x;
        this.cost=cost;
    }
}
class Solution {
    int n,weight[][],count[],M=(int)(Math.pow(10,9)+7);
    HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();

    public void shortestDist(int src,int dest){
        long dist[]= new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<node> pq = new PriorityQueue<>((p,q)->Long.compare(p.cost,q.cost));
        pq.add(new node(src,0));
        while(pq.size()>0){
            node z=pq.poll();
            for(int a:adj.get(z.x))
                if(z.cost+weight[z.x][a]<dist[a]){
                    count[a]=count[z.x];
                    dist[a]=z.cost+weight[z.x][a];
                    pq.add(new node(a,dist[a]));
                }
                else if(z.cost+weight[z.x][a]==dist[a])
                    count[a]=(count[a]+count[z.x])%M;
                
        }
    }
    
    public int countPaths(int n, int[][] roads) {
        this.n=n;
        weight= new int[n][n];
        for(int i=0;i<n;i++)
            adj.put(i,new ArrayList<>());

        for(int x[]:roads){
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
            weight[x[0]][x[1]]=x[2];
            weight[x[1]][x[0]]=x[2];
        }
        count= new int[n];
        count[0]=1;
        shortestDist(0,n-1);

        return count[n-1]%M;
    }
}