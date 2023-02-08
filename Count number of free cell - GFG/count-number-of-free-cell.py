#User function Template for python3

class Solution():
    def countZero(self, n, k ,arr):
        l=len(arr)
        c=r=n
        t=n*n
        dictr={}
        dictc={}
        ans=[]
        i=0
        while i<l:
            if arr[i][0] not in dictr and arr[i][1] not in dictc:
                t=t-(c+r-1)
                ans.append(t)
                r-=1
                c-=1
                dictr[arr[i][0]]=1
                dictc[arr[i][1]]=1
            elif arr[i][0] not in dictr:
                dictr[arr[i][0]]=1
                t-=r
                c-=1
                ans.append(t)
            elif arr[i][1] not in dictc:
                dictc[arr[i][1]]=1
                t-=c
                r-=1
                ans.append(t)
            else:
                ans.append(t)
            i+=1
        return ans
                
                
                
            
            


#{ 
 # Driver Code Starts
#Initial Template for Python 3


for _ in range(int(input())):
    n,k=map(int,input().split())
    arr = []
    for i in range(k):
        x,y=map(int,input().split())
        arr.append([x, y])
    obj = Solution()
    res = obj.countZero(n, k, arr)
    for i in res:
        print(i,end = " ")
    print()
# } Driver Code Ends