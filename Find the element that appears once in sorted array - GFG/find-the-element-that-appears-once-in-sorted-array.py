#User function Template for python3

class Solution:
    def findOnce(self,arr : list, n : int):
        i=0
        ans=arr[0]
        while i<n:
            if i<n-1:
                
                if arr[i]!=arr[i+1]:
                    ans=arr[i]
                    return arr[i]
                i+=2
            else:
                ans=arr[i]
                i+=1
        return ans


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    
    for _ in range(t):
        n = int(input())
        arr = [int(x) for x in input().strip().split()]
        ob = Solution()
        print(ob.findOnce(arr, n))
# } Driver Code Ends