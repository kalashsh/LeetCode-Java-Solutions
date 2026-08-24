class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder s = new StringBuilder();
        for (char c : num.toCharArray()) {
            while (k > 0 && s.length() > 0 && s.charAt(s.length() - 1) > c) {
                s.deleteCharAt(s.length() - 1);
                k--;
            }
            s.append(c);
        }
        while (k-- > 0)
            s.deleteCharAt(s.length() - 1);
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0')
            i++;
        return i == s.length() ? "0" : s.substring(i);
    }
}