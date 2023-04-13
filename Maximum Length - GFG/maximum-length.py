#User function Template for python3
import math
class Solution():
    def solve(self, a, b, c):
        if a==b and b==c:
            return a*3
        else:
            x=0
            if a>b and a>c:
                if math.ceil(a//2)>=a-(b+c+1):
                    return a+b+c
            elif b>c:
                if math.ceil(b//2)>=b-(a+c+1):
                    return a+b+c
            else:
                if math.ceil(c//2)>=c-(b+a+1):
                    return a+b+c
        return -1
                
        
       


#{ 
 # Driver Code Starts
#Initial Template for Python 3

from collections import Counter
for _ in range(int(input())):
    a, b, c=map(int,input().split())
    obj = Solution()
    res = obj.solve(a, b, c)
    
    print(res)
# } Driver Code Ends