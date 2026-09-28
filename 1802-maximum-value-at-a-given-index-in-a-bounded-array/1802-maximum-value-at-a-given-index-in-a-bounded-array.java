class Solution {
    public int maxValue(int n, int index, int maxSum) {
        long left = 1;
        long right = maxSum;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            long sum = minSum(n, index, mid);

            if (sum <= maxSum) {
                left = mid + 1;   
            } else {
                right = mid - 1;  
            }
        }

        return (int) right;
    }
    private long minSum(int n, int index, long x) {
        long leftCount = index;
        long rightCount = n - index - 1;

        return x
                + sideSum(x, leftCount)
                + sideSum(x, rightCount);
    }
    private long sideSum(long x, long count) {
        long decreasing = Math.min(count, x - 1);
        long sum = decreasing * (2 * x - decreasing - 1) / 2;
        sum += count - decreasing;

        return sum;
    }
}
