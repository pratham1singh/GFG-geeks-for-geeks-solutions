from typing import List


class Solution:
    def finLength(self, N : int, color : List[int], radius : List[int]) -> int:
        list1=[]
        list2=[]
        top=-1
        i=0
        while i<N:
            if top==-1:
                list1.append(color[i])
                list2.append(radius[i])
                i+=1
                top+=1
            else:
                if color[i]!=list1[top] or radius[i]!=list2[top]:
                    list1.append(color[i])
                    list2.append(radius[i])
                    i+=1
                    top+=1
                else:
                    list1.pop()
                    list2.pop()
                    top-=1
                    i+=1
        return len(list1)
                    
                    
            
                
                



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
        
        
        color=IntArray().Input(N)
        
        
        radius=IntArray().Input(N)
        
        obj = Solution()
        res = obj.finLength(N, color, radius)
        
        print(res)
        

# } Driver Code Ends