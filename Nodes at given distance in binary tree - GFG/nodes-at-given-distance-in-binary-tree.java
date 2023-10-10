//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class node{
        int d;
        Node root;
        public  node(Node root,int d){
            this.root=root;
            this.d=d;
        }
    }
 class Solution
{
    
    
    public static void parents(Node root,int target,HashMap<Node,Node> map){
        if(root!=null){
            
                
            if(root.left!=null){
                map.put(root.left,root);
                parents(root.left,target,map);
            }
            if(root.right!=null){
                map.put(root.right,root);
                parents(root.right,target,map);
            }
        }
    }
    public static Node source(Node root, int target){
        if(root!=null){
            if(root.data==target)
                return root;
            Node x=source(root.left,target);
            if(x!=null)
                return x;
            return source(root.right,target);
        }
        return null;
    }
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        HashMap<Node,Node> map = new HashMap<>();
        map.put(root,null);
        parents(root,target,map);
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Node,Boolean> visited = new HashMap<>();
         
         Queue<node> queue = new LinkedList<>();
         int l=1;
         queue.add(new node(source(root,target),0));
         visited.put(source(root,target),true);
        while(l>0){
           
            node x=queue.remove();
            l-=1;
            if(x.d==k)
                ans.add(x.root.data);
                
            else if(x.d<k){
                if(x.root.left!=null&&visited.get(x.root.left)==null){
                    queue.add(new node(x.root.left,x.d+1));
                    l+=1;
                    visited.put(x.root.left,true);
                }
                if(x.root.right!=null&&visited.get(x.root.right)==null){
                    queue.add(new node(x.root.right,x.d+1));
                    l+=1;
                    visited.put(x.root.right,true);
                }
                if(map.get(x.root)!=null&&visited.get(map.get(x.root))==null){
                    queue.add(new node(map.get(x.root),x.d+1));
                    l+=1;
                    visited.put(map.get(x.root),true);
                }
            }
            
                
        }
        Collections.sort(ans);
        return ans;
    }
};