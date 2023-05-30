//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    int fr,fc;
    String word;
    public boolean find(char[][] arr,int i,int l,int r,int c){
        if(i>=l)
            return true;
        else if (r>=fr||c>=fc||r<0||c<0)
            return false;
        else if(arr[r][c]!=word.charAt(i))
            return false;
        else{
           
            boolean ans=false;
            char a =arr[r][c];
            arr[r][c]='@';
            ans=find(arr,i+1,l,r+1,c)|| find(arr,i+1,l,r,c+1)||find(arr,i+1,l,r-1,c)|| find(arr,i+1,l,r,c-1);
            arr[r][c]=a;
            return ans;
        }
        
            
    }
    
    public boolean isWordExist(char[][] board, String word)
    {
            fr=board.length;
            fc=board[0].length;
            this.word=word;
            for(int i=0;i<fr;i++){
                for(int j=0;j<fc;j++){
                    if(board[i][j]==word.charAt(0)){
                        
                        // char arr[][]=new char[fr][fc];
                        // for(int k=0;k<fr;k++){
                        //     for(int l=0;l<fc;l++){
                        //       arr[k][l]=board[k][l];
                        //     }
                        // }
                        if(find(board,0,word.length(),i,j))
                            return true;
                    }
                }
            }
            
            
            return false;
    }
}