class Solution {
    HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();
    HashMap<Integer,HashMap<Integer,Boolean>> reachable = new HashMap<>();

    public HashMap<Integer,Boolean> dfs(int i){
        if(reachable.get(i)!=null) return reachable.get(i);
        HashMap<Integer,Boolean> ans = new HashMap<>();
        ans.put(i,true);
        for(int a:adj.get(i)){
            HashMap<Integer,Boolean> map=dfs(a);
            for(int key:map.keySet())
                ans.put(key,map.get(key));
        }
        reachable.put(i,ans);
        return ans;
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++)
            adj.put(i,new ArrayList<Integer>());

        for(int x[]:edges)
            adj.get(x[0]).add(x[1]);

        for(int i=0;i<n;i++)
            dfs(i);

        for(int i=0;i<n;i++){
            List<Integer> arr= new ArrayList<>();

            for(int j=0;j<n;j++)
                if(reachable.get(j).get(i)!=null&&i!=j)
                    arr.add(j);
            ans.add(arr);
        }
        // System.out.println(reachable);
        return ans;
        
    }
}