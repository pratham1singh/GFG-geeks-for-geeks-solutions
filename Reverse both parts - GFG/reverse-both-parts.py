
from typing import Optional

"""

Definition for singly Link List Node
class Node:
    def __init__(self,x):
        self.data=x
        self.next=None

You can also use the following for printing the link list.
printList(node)
"""

class Solution:
    def reverse(self, head : Optional['Node'], k : int) -> Optional['Node']:
        def rev(head):
            ptr=head
            pre=None
            forw=head
            while ptr!=None:
                forw=ptr.next
                ptr.next=pre
                pre=ptr
                ptr=forw
            return pre
        c=0
        head1=None
        head2=None
        ptr=head
        while ptr!=None:
            c+=1
            if c==k:
                break
            ptr=ptr.next
        head2=ptr.next
        ptr.next=None
        head1=head
        temp=head1
        
        head1=rev(head1)
        head2=rev(head2)
        temp.next=head2
        
        return head1
        
#{ 
 # Driver Code Starts

class Node:
    def __init__(self,x):
        self.data=x
        self.next=None

def printList(node):
    while (node != None):
        print(node.data,end=" ")
        node = node.next
    print()
def inputList():
    n=int(input())#lenght of link list
    data=[int(i) for i in input().strip().split()]#all data of linked list in a line
    head = Node(data[0])
    tail = head;
    for i in range(1,n):
        tail.next = Node(data[i]);
        tail = tail.next;
    return head;

if __name__=="__main__":
    t = int(input())
    for _ in range(t):
        
        head = inputList()
        
        
        k = int(input())
        
        obj = Solution()
        res = obj.reverse(head, k)
        
        printList(res)
        

# } Driver Code Ends