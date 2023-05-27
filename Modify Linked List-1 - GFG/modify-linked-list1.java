//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
    }
}
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n=Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            Node head=new Node(Integer.parseInt(s[0]));
            Node copy=head;
            for(int i=1;i<n;i++){
                Node temp=new Node(Integer.parseInt(s[i]));
                copy.next=temp;
                copy=copy.next;
            }
            Solution ob=new Solution();
            Node ans=ob.modifyTheList(head);
            while(ans!=null){
                out.print(ans.data+" ");
                ans=ans.next;
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public static Node modifyTheList(Node head)
    {
        int n=0,i=0;
        ArrayList<Integer> arr=new ArrayList<Integer> ();
        Node ptr=head;
        while(ptr!=null){
            arr.add(ptr.data);
            ptr=ptr.next;
            
            n+=1;
        }
        int m=(int)(n/2);
        if(n%2==0)
            m-=1;
        i=n-1;
        ptr=head;
        while(i>m){
            ptr.data=arr.get(i)-ptr.data;
            i-=1;
            ptr=ptr.next;
        }
        
        i=m;
        while(ptr!=null){
            ptr.data=arr.get(i);
            i-=1;
            ptr=ptr.next;
        }
        return head;

    }
}