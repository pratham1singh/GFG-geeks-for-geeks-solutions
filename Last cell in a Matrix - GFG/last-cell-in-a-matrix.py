#User function Template for python3

class Solution:
    def endPoints(self, matrix, R, C):
        i=0
        j=0
        d="r"
        while i<R and j<C:
            if matrix[i][j]==0:
                if d=='r':
                    if j+1>=C:
                        return [i,j]
                    j+=1
                elif d=='l':
                    if j-1<0:
                        return [i,j]
                    j-=1
                elif d=='u':
                    if i-1<0:
                        return [i,j]
                    i-=1
                elif d=='d':
                    if i+1>=R:
                        return [i,j]
                    i+=1
            else:
                matrix[i][j]=0
                if d=='l':
                    if i-1<0:
                        return[i,j]
                    else:
                        d='u'
                        i-=1
                elif d=='r':
                    if i+1>=R:
                        return [i,j]
                    else:
                        i+=1
                        d='d'
                elif d=='d':
                    if j-1<0:
                        return [i,j]
                    else:
                        j-=1
                        d='l'
                elif d=='u':
                    if j+1>=C:
                        return [i,j]
                    else:
                        j+=1
                        d='r'
        return [i,j]
                
                    
                    
                



#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        r,c = map(int, input().strip().split())
        matrix = []
        for i in range(r):
            line = [int(x) for x in input().strip().split()]
            matrix.append(line)
        ob = Solution()
        ans = ob.endPoints(matrix,r,c)
        print('(',ans[0],', ',ans[1],')',sep ='')

# } Driver Code Ends