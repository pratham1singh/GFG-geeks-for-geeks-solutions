#Function to locate the occurrence of the string x in the string s.
def strstr(s,x):
    l2=len(x)
    l1=len(s)
    for i in range(l1):
        if s[i]==x[0]:
            k=i
            j=0
            flag=0
            c=0
            for l in range(k,l1):
                if j>=l2:
                    break
                if s[l]!=x[j]:
                    break
                c+=1
                j+=1
            if c==l2:
                return i
    return -1
                
        


#{ 
 # Driver Code Starts
#Contributed by : Nagendra Jha

import atexit
import io
import sys

_INPUT_LINES = sys.stdin.read().splitlines()
input = iter(_INPUT_LINES).__next__
_OUTPUT_BUFFER = io.StringIO()
sys.stdout = _OUTPUT_BUFFER

@atexit.register

def write():
    sys.__stdout__.write(_OUTPUT_BUFFER.getvalue())

if __name__ == '__main__':
    t=int(input())
    for cases in range(t):
        s,p =input().strip().split()
        print(strstr(s,p))


# } Driver Code Ends