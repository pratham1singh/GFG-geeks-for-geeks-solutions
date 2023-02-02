#User function Template for python3

class Solution:

    def longestSubstrDistinctChars(self, S):
        dict1={}
        ml=0
        cl=0
        i=f=0
        l=len(S)
        while f<l:
            if S[f] not in dict1:
                dict1[S[f]]=1
                cl+=1
                f+=1
            else:
                while S[f] in dict1:
                    del dict1[S[i]]
                    i+=1
                    cl-=1
                dict1[S[f]]=1
                cl+=1
                f+=1
            if cl>ml:
                ml=cl
        if cl>ml:
            ml=cl
        return ml
        
            
        


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':

    t = int(input())

    for _ in range(t):
        S = input()

        solObj = Solution()

        ans = solObj.longestSubstrDistinctChars(S)

        print(ans)

# } Driver Code Ends