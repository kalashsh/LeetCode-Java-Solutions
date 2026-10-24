
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) {
            return false;
        }

        int[] count = new int[26];

        // Count characters in s1
        for (int i = 0; i < n; i++) {
            count[s1.charAt(i) - 'a']++;
        }

        // Add the first window of s2
        for (int i = 0; i < n; i++) {
            count[s2.charAt(i) - 'a']--;
        }

        // If all frequencies match, a permutation exists
        if (isZero(count)) {
            return true;
        }

        // Slide the window across s2
        for (int i = n; i < m; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - n) - 'a']++;

            if (isZero(count)) {
                return true;
            }
        }

        return false;
    }

    private boolean isZero(int[] count) {
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
