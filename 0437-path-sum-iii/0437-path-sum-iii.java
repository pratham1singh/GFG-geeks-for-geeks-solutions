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
    int target;

    public int find(TreeNode root,double sum){
        if(root==null) return 0;

        else if(sum==target){
            int ans=1;
            if(root.left!=null)
                ans+=find(root.left,sum+root.left.val);
             if(root.right!=null)
                ans+=find(root.right,sum+root.right.val);
            return ans;
        }
        else if(root.left==null&&root.right==null)
            return sum==target?1:0;
        else{
             int ans=0;
            if(root.left!=null)
                ans+=find(root.left,sum+root.left.val);
             if(root.right!=null)
                ans+=find(root.right,sum+root.right.val);
            return ans;
        }
        
    }
    public int find2(TreeNode root){
        if(root==null)
            return 0;
        else{
            int ans=0;
            ans+=find(root,root.val);
            ans+=find2(root.left);
            ans+=find2(root.right);
            return ans;
        }
    }
    public int pathSum(TreeNode root, int targetSum) {
        this.target=targetSum;
        return find2(root);
    }
}