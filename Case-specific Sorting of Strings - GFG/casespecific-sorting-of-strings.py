#User function Template for python3

class Solution:

    #Function to perform case-specific sorting of strings.
    def caseSort(self,s,n):
        str1=""
        str2=""
        dictl={}
        dictu={}
        u=l=0
        for i in s:
            if i.islower():
                if i in dictl:
                    dictl[i]+=1
                else:
                    dictl[i]=1
            else:
                if i in dictu:
                    dictu[i]+=1
                else:
                    dictu[i]=1
        for i in "abcdefghijklmnopqrstuvwxyz":
            if i in dictl:
                str1+=i*dictl[i]
            if i.upper() in dictu:
                str2+=i.upper()*dictu[i.upper()]
        s=list(s)
        for i in range(n):
            if s[i].islower():
                s[i]=str1[l]
                l+=1
            else:
                s[i]=str2[u]
                u+=1
        return "".join(s)
                
        
        
        


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for tt in range(t):
        n=int(input())
        s=str(input())
        print(Solution().caseSort(s,n))
# } Driver Code Ends