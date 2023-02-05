#User function Template for python3

#Function to push an element in queue by using 2 stacks.
def Push(x,stack1,stack2):
    l=len(stack1)
    l2=l
    while l!=0:
        stack2.append(stack1.pop(-1))
        l-=1
    stack1.append(x)
    l+=1
    while l2!=0:
        stack1.append(stack2.pop(-1))
        l2-=1
    

#Function to pop an element from queue by using 2 stacks.
def Pop(stack1,stack2):
    if len(stack1)==0:
        return -1
    return stack1.pop()


#{ 
 # Driver Code Starts
#Initial Template for Python 3

#contributed by RavinderSinghPB
if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases):
        qry=int(input())
        qtyp_qry=list(map(int, input().strip().split()))
        
        i=0
        stack1=[]
        stack2=[]
        while i <len(qtyp_qry):
            #print(i)
            if qtyp_qry[i]==1:
                Push(qtyp_qry[i+1],stack1,stack2)
                #print(i)
                i+=2
            else:
                print(Pop(stack1,stack2),end=' ')
                i+=1
                
        print()
# } Driver Code Ends