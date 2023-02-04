#User function Template for python3
class Solution:
	
	def findMaxSum(self,arr, n):
		incl = 0
        excl = 0   
        for i in arr:
              
            # Current max excluding i
            new_excl = max (excl, incl)
              
            # Current max including i
            incl = excl + i
            excl = new_excl
          
        # Return max of incl and excl
        return max(excl, incl)


#{ 
 # Driver Code Starts
#Initial Template for Python 3




if __name__ == '__main__':
    tc = int(input())
    while tc > 0:
        n = int(input())
        arr = list(map(int, input().strip().split()))
        ob = Solution()
        ans = ob.findMaxSum(arr, n)
        print(ans)
        tc -= 1

# } Driver Code Ends