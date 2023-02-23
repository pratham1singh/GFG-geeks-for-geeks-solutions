# Your task is to complete this function
# Function should return True/False or 1/0
def PalinArray(arr ,n):
    def palin(str1):
        i=0
        f=len(str1)-1
        while i<f:
            if str1[i]!=str1[f]:
                return 0
            i+=1
            f-=1
        return 1
    for i in arr:
        if palin(str(i))==0:
            return 0
    return 1
        


#{ 
 # Driver Code Starts
# Driver Program
if __name__=='__main__':
    t=int(input())
    for i in range(t):
        n = int(input())
        arr = list(map(int, input().strip().split()))
        if PalinArray(arr, n):
            print(1)
        else:
            print(0)
# Contributed By: Harshit Sidhwa

# } Driver Code Ends