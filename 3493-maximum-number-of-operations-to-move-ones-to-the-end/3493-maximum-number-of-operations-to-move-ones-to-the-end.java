class Solution {
    public int maxOperations(String s) {
        int n=s.length(),i=0,c=0,ans=0;
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();

        // st.push(1);
        
        while(i<n){
            if(s.charAt(i)=='0'){
                if(c!=0)
                    arr.add(c);
                c=0;
            }
            else
                c++;
            i++;
        }
        if(c!=0)
            arr.add(c);
        c=0;
        if(s.endsWith("0"))
            st.push(1);
        for(int k=arr.size()-1;k>=0;k--)
            st.push(arr.get(k));

        while(st.size()>1){
            int x=st.pop();
            ans+=x;
            x+=st.pop();
            st.push(x);
        }
        return ans;
    }
}