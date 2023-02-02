#User function Template for python3
'''
	Your task is to segregate the list of 
	0s,1s and 2s.
	
	Function Arguments: head of the original list.
	Return Type: head of the new list formed.

	{
		# Node Class
		class Node:
		    def __init__(self, data):   # data -> value stored in node
		        self.data = data
		        self.next = None
	}

'''
class Solution:
    #Function to sort a linked list of 0s, 1s and 2s.
    def segregate(self, head):
        ptr=head
        pre=head
        l=0
        while ptr.next!=None:
            ptr=ptr.next
            l+=1
        l+=1
        tail=ptr
        ptr=head
        c=0
        while ptr!=None and c<=l+1:
            c+=1
            if ptr.data==0:
                if ptr==head:
                    pre=ptr
                    ptr=ptr.next
                    continue
                elif ptr==tail:
                    node=ptr
                    pre.next=None
                    node.next=head
                    head=node
                    break
                else:
                    node=ptr
                    pre.next=ptr.next
                    ptr=ptr.next
                    node.next=head
                    head=node
            elif ptr.data==2:
                if ptr==tail:
                    break
                elif ptr==head:
                    node=ptr
                    pre=ptr.next
                    ptr=ptr.next
                    node.next=None
                    tail.next=node
                    tail=node
                    head=pre
                else:
                    node=ptr
                    pre.next=ptr.next
                    ptr=ptr.next
                    node.next=None
                    tail.next=node
                    tail=node
                    continue
                
                
                
            else:
                pre=ptr
                ptr=ptr.next
            
        return head
                    
                
                
            
    


#{ 
 # Driver Code Starts
#Initial Template for Python 3
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
# Node Class
class Node:
    def __init__(self, data):   # data -> value stored in node
        self.data = data
        self.next = None

# Linked List Class
class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    # creates a new node with given value and appends it at the end of the linked list
    def append(self, new_value):
        new_node = Node(new_value)
        if self.head is None:
            self.head = new_node
            self.tail = new_node
            return
        self.tail.next = new_node
        self.tail = new_node
        
# prints the elements of linked list starting with head
def printList(head):
    if head is None:
        print(' ')
        return
    curr_node = head
    while curr_node:
        print(curr_node.data,end=" ")
        curr_node=curr_node.next
    print()

if __name__ == '__main__':
    t=int(input())
    for cases in range(t):
        n = int(input())
        a = LinkedList() # create a new linked list 'a'.
        nodes_a = list(map(int, input().strip().split()))
        for x in nodes_a:
            a.append(x)  # add to the end of the list
        printList(Solution().segregate(a.head))
# } Driver Code Ends