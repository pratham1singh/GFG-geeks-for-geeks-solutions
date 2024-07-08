//Solution1 using simple array
class Solution1 {
    public int findTheWinner(int n, int k) {
        int arr[]= new int[n],i=0,c=n;

        while(c>1){
            int j=i,count=0;
            if(j==n)
                j=0;

            while(1>0){
                if(arr[j]!=-1)
                    count+=1;
                if(count==k)
                    break;
                if(j==n-1)
                    j=0;
                else
                    j+=1;
                // if(j==i)
                //     break;
            }
            if(count<k)
                break;
            i=j;
            System.out.println(i);
            arr[i]=-1;
            i++;
            if(i==n)
                i=0;
            c-=1;
        }
        i=0;
        while(arr[i]==-1)
            i++;
        return i+1;


    }
}


//Solution2 using linkedlist
class Solution {
    class node{
        int data;
        node pre,forw;

        public node(int data){
            this.data=data;
            this.pre=null;
            this.forw=null;
        }
    }

    public int findTheWinner(int n, int k) {
        node head=new node(1),ptr=head;
        for(int i=2;i<=n;i++){
            node temp= new node(i);
            temp.pre=ptr;
            ptr.forw=temp;
            ptr=temp;
        }
        ptr.forw=head;
        head.pre=ptr;
        ptr=head;

        while(ptr.pre!=ptr){
            int count=1;
            while(count<k){
                count+=1;
                ptr=ptr.forw;
            }
            //delete node
            // System.out.println(ptr.data);
            ptr.forw.pre=ptr.pre;
            ptr.pre.forw=ptr.forw;
            ptr=ptr.forw;
        }
        return ptr.data;
    }
}