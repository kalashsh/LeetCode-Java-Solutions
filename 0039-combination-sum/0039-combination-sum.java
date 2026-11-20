class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        genCombinations(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }
    public void genCombinations(int[] candidates, int target, int start, List<Integer> current, int sum){
        if(sum==target){
            res.add(new ArrayList<>(current));
            return;
        }
        if(sum > target) return;

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);                 
            genCombinations(candidates, target, i, current, sum + candidates[i]);  
            current.remove(current.size() - 1);       
        }
    }
}