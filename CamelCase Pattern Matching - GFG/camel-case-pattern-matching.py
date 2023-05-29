#User function Template for python3

class Solution:
    def CamelCase(self,N,arr,pat):
        ans=[]
        for i in arr:
            str1=""
            for j in i:
                if j.isupper():
                    str1+=j
            if str1.startswith(pat):
                ans.append(i)
        ans.sort()
        if len(ans)==0:
            return [-1]
        return ans
                


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__=='__main__':
    t=int(input())
    for _ in range(t):
        N=int(input())
        Dictionary=list(map(str,input().split()))
        Pattern=input()
        ob=Solution()
        ans=ob.CamelCase(N,Dictionary,Pattern)
        ans.sort()
        for i in ans:
            print(i,end=" ")
        print()    
# } Driver Code Ends