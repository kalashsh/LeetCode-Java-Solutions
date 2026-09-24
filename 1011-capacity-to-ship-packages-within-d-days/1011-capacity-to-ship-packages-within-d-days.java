class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = (left + right) / 2, need = 1, sum = 0;
            for (int w : weights) {
                if (sum + w > mid) {
                    need++;
                    sum = 0;
                }
                sum += w;
            }
            if (need > days) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}