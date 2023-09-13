#User function Template for python3

class Solution:
    def findLargest(self, N, S):
        if S==0 and N>1:
            return -1
        ans=""
        while  N>0:
            if S==0:
                ans+='0'
                N-=1
            elif S<9:
                ans+=str(S)
                S=0
                N-=1
            else:
                ans+=str(9)
                S-=9
                N-=1
        if S==0:
            return int(ans)
        return -1


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        N, S = [int(x) for x in input().split()]
        
        ob = Solution()
        print(ob.findLargest(N, S))
# } Driver Code Ends