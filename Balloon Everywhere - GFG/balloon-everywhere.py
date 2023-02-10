class Solution:
    def maxInstance(self, s : str) -> int:
        l=len(s)
        if l<7:
            return 0
        dict1={}
        for i in s:
            if i in dict1:
                dict1[i]+=1
            else:
                dict1[i]=1
        mx=l
        arr=[1,1,2,2,1]
        k=0
        for i in "balon":
            if dict1[i]//arr[k]<mx:
                mx=dict1[i]//arr[k]
            k+=1
        return mx
            


#{ 
 # Driver Code Starts
if __name__=="__main__":
    t = int(input())
    for _ in range(t):
        
        s = (input())
        
        obj = Solution()
        res = obj.maxInstance(s)
        
        print(res)

# } Driver Code Ends