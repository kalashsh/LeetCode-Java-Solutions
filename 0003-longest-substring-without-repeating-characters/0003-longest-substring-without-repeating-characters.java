class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, ans = 0;
        String str = "";
        for (int right = 0; right < s.length(); right++) {
            while (str.indexOf(s.charAt(right)) != -1)
            str=str.substring(1);
            str+=s.charAt(right);
            ans=Math.max(ans,str.length());
        }
        return ans;
    }
}
