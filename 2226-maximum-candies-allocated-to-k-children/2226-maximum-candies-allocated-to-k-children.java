class Solution {
    public int maximumCandies(int[] candies, long k) {
        long total = 0;
        int max = 0;
        for (int candy : candies) {
            total+=candy;
            max=Math.max(max, candy);
        }
        if (total<k) {
            return 0;
        }
        int left=1;
        int right=max;
        int answer=0;
        while (left<=right) {
            int mid=left + (right - left) / 2;
            if (canAllocate(candies, k, mid)) {
                answer=mid;
                left=mid+1;   
            } else {
                right=mid-1; 
            }
        }
        return answer;
    }
    private boolean canAllocate(int[] candies, long k, int perChild) {
        long children=0;
        for (int candy : candies) {
            children+=candy/perChild;
            if (children>=k) {
                return true;
            }
        }
        return false;
    }
}
