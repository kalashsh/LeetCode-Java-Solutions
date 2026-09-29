class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }

        int answer = right;
        while (left <= right) {
            int divisor = left + (right - left) / 2;
            if (isValid(nums, threshold, divisor)) {
                answer = divisor;
                right = divisor - 1;  
            } else {
                left = divisor + 1;   
            }
        }
        return answer;
    }
    private boolean isValid(int[] nums, int threshold, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor;
            if (sum > threshold) {
                return false;
            }
        }
        return true;
    }
}
