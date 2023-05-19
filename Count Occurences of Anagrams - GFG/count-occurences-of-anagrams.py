#User function Template for python3
class Solution:

	
	def search(self,pat, txt):
	    w=[0]*26
	    p=[0]*26
	    i=0
	    ans=0
	    while i<len(pat):
	        p[ord(pat[i])-97]+=1
	        i+=1
	    i=0
	    while i<len(pat):
	        w[ord(txt[i])-97]+=1
	        i+=1
	    f=i
	    i=0
	    while f<len(txt):
	        
	        flag=0
	        k=0
	        while k<26:
	            if(p[k]!=w[k]):
	                flag=-1
	                break
	            k+=1
	        if(flag==0):
	            ans+=1
	        w[ord(txt[i])-97]-=1
	        i+=1
	        w[ord(txt[f])-97]+=1
	        f+=1
	    k=0
	    flag=0
	    while k<26:
            if(p[k]!=w[k]):
                flag=-1
                break
            k+=1
        if(flag==0):
            ans+=1
	        
	    return ans
	   
	        


#{ 
 # Driver Code Starts
#Initial Template for Python 3


# Driver code 
if __name__ == "__main__": 		
    tc=int(input())
    while tc > 0:
        txt=input().strip()
        pat=input().strip()
        ob = Solution()
        ans = ob.search(pat, txt)
        print(ans)
        tc=tc-1
# } Driver Code Ends