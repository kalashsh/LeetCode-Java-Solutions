class Solution {
    public int[] searchRange(int[] nums, int target) {
         int[] ans = {-1, -1};

        int start = findFirst(nums, target);
        if (start == -1) {
            return ans;
        }

        int end = findLast(nums, target);

        ans[0] = start;
        ans[1] = end;

        return ans;
    }
    private static int findFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }

        return index;
    }

    private static int findLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }

        return index;
    }
}   