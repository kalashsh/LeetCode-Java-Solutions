class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int low = 1, high = maxSum;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isValid(n, index, maxSum, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
    boolean isValid(int n, int index, int maxSum, int sum) {
        int leftElements = index;
        int rightElements = n - index - 1;
        int leftSeriesElements = Math.min(leftElements, sum - 1);
        int leftLeftOverElements = leftElements - leftSeriesElements;
        long leftSum = leftLeftOverElements + (((long)sum * leftSeriesElements) - ((long) leftSeriesElements * (leftSeriesElements + 1) / 2));

        int rightSeriesElements =  Math.min(rightElements, sum - 1);
        int rightLeftOverElements = rightElements - rightSeriesElements;
        long rightSum = rightLeftOverElements + (((long)sum * rightSeriesElements) - ((long) rightSeriesElements * (rightSeriesElements + 1) / 2));

        return (leftSum + sum + rightSum) <= maxSum;
    }
}