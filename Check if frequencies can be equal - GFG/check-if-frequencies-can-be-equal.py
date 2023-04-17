#User function Template for python3
class Solution:
    def sameFreq(self, s):
        dict1={}
        for i in s:
            if i in dict1:
                dict1[i]+=1
            else:
                dict1[i]=1
        def check(dict2):
            x=list(dict2.values())[0]
            for i in dict2.values():
                if i!=x and i!=0:
                    return False
            return True
        if len(set(dict1.values()))==1:
            return True
        for i in "abcdefghijklmnopqrstuvwxyz":
            if i in dict1:
                dict1[i]-=1
                if check(dict1):
                    return True
                else:
                    dict1[i]+=1
        return False
                


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == "__main__":
	T=int(input())

	for _ in range(T):
		s = input()
		ob = Solution()
		answer = ob.sameFreq(s)
		if answer:
			print(1)
		else:
			print(0)

# } Driver Code Ends