class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        genParenthesis(res, "", n,n);
        return res;
    }
    public void genParenthesis(List<String> res, String s, int left, int right){
        if(left==0 && right ==0){
            res.add(s);
            return;
        }
        if(left > 0){
            genParenthesis(res, s + "(", left - 1, right);
        }
        if(right > left){
            genParenthesis(res, s + ")", left, right-1);
        }
    }
}