#User function Template for python3

class Solution:
    def minRepeats(self, A, B):
        l1=len(A)
        l2=len(B)
        n=((max(l2,l1)//min(l2,l1)))
        n+=1
        cl=0
        c=0
        str1=""
        l1=min(l1,l2)
        while cl<=n*l1:
            str1+=A
            cl+=l1
            c+=1
            if B in str1:
                return c
        return -1

#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        A=input()
        B=input()
        
        ob = Solution()
        print(ob.minRepeats(A,B))
# } Driver Code Ends