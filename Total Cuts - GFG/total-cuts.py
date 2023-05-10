from typing import List


class Solution:
    def totalCuts(self, N : int, k: int, arr : List[int]) -> int:
        if N==1:
            return 0
        i=0
        lg=arr[0]
        sm=min(arr[1:])
        ans=0
        while i<N-1:
            if(lg+sm>=k):
                ans+=1
            i+=1
            if lg<arr[i]:
                lg=arr[i]
            if arr[i]==sm and i+1<=N-1:
                sm=min(arr[i+1:])
        return ans
            
            
        
        



#{ 
 # Driver Code Starts
class IntArray:
    def __init__(self) -> None:
        pass
    def Input(self,n):
        arr=[int(i) for i in input().strip().split()]#array input
        return arr
    def Print(self,arr):
        for i in arr:
            print(i,end=" ")
        print()


if __name__=="__main__":
    t = int(input())
    for _ in range(t):
        
        N = int(input())
        
        
        K = int(input())
        
        
        A=IntArray().Input(N)
        
        obj = Solution()
        res = obj.totalCuts(N,K,A)
        
        print(res)
        

# } Driver Code Ends