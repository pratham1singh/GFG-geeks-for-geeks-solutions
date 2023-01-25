#User function Template for python3

def uniqueRow(row, col, matrix):
    dict1={}
    ans=[]
    c1=0
    c2=col
    i=0
    while i<row:
        if tuple(matrix[c1:c2]) in dict1:
            dict1[tuple(matrix[c1:c2])]+=1
        else:
            dict1[tuple(matrix[c1:c2])]=1
        i+=1
        c1=c2
        c2+=col
    c1=0
    c2=col
    for i in range(row):
        if dict1[tuple(matrix[c1:c2])]>=1:
            ans.append(matrix[c1:c2])
            dict1[tuple(matrix[c1:c2])]=0
        c1=c2
        c2+=col
    return ans
            
        


#{ 
 # Driver Code Starts
#Initial Template for Python 3

def main():
    testcase = int(input())
    while(testcase):
        s = input().split()
        row = int(s[0])
        col = int(s[1])
        matrix = input().split()
        
        a = uniqueRow(row, col, matrix)
        
        for row in a:
            for value in row:
                print(value,end = " ")
            print("$",end = "")
        print()
        testcase -= 1

if __name__ == "__main__":
    main()
# } Driver Code Ends