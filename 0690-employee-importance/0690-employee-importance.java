/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {

    HashMap<Integer,Employee> map = new HashMap<>();

    public int findSum(int node){
        int ans=0;
        for(int x:map.get(node).subordinates)
            ans+=findSum(x);
        return ans+map.get(node).importance;
    }
    public int getImportance(List<Employee> employees, int id) {
        for(Employee x:employees)
            map.put(x.id,x);

        return findSum(id);
    }
}