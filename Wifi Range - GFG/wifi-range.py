#User function Template for python3
class Solution:
    def wifiRange(self, n, s, x):
        c=0
        for i in s:
            if i=="0":
                c+=1
            else:
                if c>x:
                    return False
                break
        c=0
        for i in s[::-1]:
            if i=="0":
                c+=1
            else:
                if c>x:
                    return False
                break
        c=0
        for i in s:
            if i=="0":
                c+=1
            else:
                if c>2*x:
                    return False
                c=0
        return True
                    
        
                    
        
        
        


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__': 
    t = int(input())
    for _ in range(t):
        N,X = map(int,input().strip().split())
        S = input()
        ob = Solution()
        ans = ob.wifiRange(N, S, X)
        if ans:
            print(1)
        else:
            print(0)

# } Driver Code Ends