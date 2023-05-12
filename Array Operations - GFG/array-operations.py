from typing import List


class Solution:
    def arrayOperations(self, n : int, arr : List[int]) -> int:
        c=0
        i=0
        if 0 not in arr:
            return -1
        while i<n:
            
            if arr[i]!=0:
                c+=1
                while i<n and arr[i]!=0:
                    i+=1
            i+=1
        return c
            



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
        
        n = int(input())
        
        
        arr=IntArray().Input(n)
        
        obj = Solution()
        res = obj.arrayOperations(n, arr)
        
        print(res)
        

# } Driver Code Ends