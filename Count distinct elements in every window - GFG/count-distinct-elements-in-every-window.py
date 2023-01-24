
class Solution:
    def countDistinct(self, A, N, K):
        i=0
        dict1={}
        c=0
        ans=[]
        for i in range(K):
            if i<N:
                if A[i] in dict1:
                    dict1[A[i]]+=1
                else:
                    dict1[A[i]]=1
                    c+=1
        ans.append(c)
        for i in range(K,N):
            if A[i] not in dict1 and dict1[A[i-K]]>1:
                c+=1
                ans.append(c)
                dict1[A[i-K]]-=1
                dict1[A[i]]=1
            elif A[i] not in dict1 and dict1[A[i-K]]==1:
                ans.append(c)
                del dict1[A[i-K]]
                dict1[A[i]]=1
            elif A[i] in dict1 and dict1[A[i-K]]>1:
                ans.append(c)
                dict1[A[i-K]]-=1
                dict1[A[i]]+=1
            elif A[i] in dict1 and dict1[A[i-K]]==1:
                if A[i]!=A[i-K]:
                    c-=1
                ans.append(c)
                del dict1[A[i-K]]
                if A[i] in dict1:
                    dict1[A[i]]+=1
                else:
                    dict1[A[i]]=1
        return ans
            
            
        
                


#{ 
 # Driver Code Starts
if __name__=='__main__':
    t = int(input())
    for i in range(t):
        n,k = list(map(int, input().strip().split()))
        arr = list(map(int, input().strip().split()))
        res = Solution().countDistinct(arr, n, k)
        for i in res:
            print (i, end = " ")
        print ()
# } Driver Code Ends