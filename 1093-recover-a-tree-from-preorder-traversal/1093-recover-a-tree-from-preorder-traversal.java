/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int i;
    ArrayList<Integer> depth;
    ArrayList<Integer> nodes;
    
    public TreeNode create(int curr,int n){
        // System.out.println(i+" "+n);
        if(i==n)
            return null;
        TreeNode root= new TreeNode(nodes.get(curr));
        if(i+1<n&&depth.get(curr)<depth.get(i+1)){
            i++;
            root.left=create(i,n);
        }
        if(i+1<n&&depth.get(curr)<depth.get(i+1)){
            i++;
            root.right=create(i,n);
        }
        return root;

    }
    public TreeNode recoverFromPreorder(String s) {
        depth = new ArrayList<>();
        nodes = new ArrayList<>();

        int c=0,n=s.length();
        for(int i=0;i<n;i++)
            if(s.charAt(i)=='-')
                c++;
            else{
                depth.add(c);
                int x=0;
                while(i<n&&s.charAt(i)!='-')
                    x=x*10+Integer.parseInt(""+s.charAt(i++));
                nodes.add(x);
                c=1;
            }
        this.i=0;

        return create(0,depth.size());
    }
}