class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> s=new HashSet<>();
        for(int n:nums){
            if(!s.add(n)){
                return true;
            }
        }
        return false;
    }
}
