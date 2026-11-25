import java.util.*;
class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int low = 1, high = n;
        int ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (hasUniqueSubarray(nums, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private boolean hasUniqueSubarray(int[] nums, int k) {
        int n = nums.length;
        long base = 100001;
        long mod = 1000000007L;
        long power = 1;
        for (int i = 1; i < k; i++) {
            power = (power * base) % mod;
        }
        long hash = 0;
        for (int i = 0; i < k; i++) {
            hash = (hash * base + nums[i]) % mod;
        }
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(hash, 1);
        for (int i = k; i < n; i++) {
            hash = (hash - (nums[i - k] * power) % mod + mod) % mod;
            hash = (hash * base + nums[i]) % mod;
            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }
        for (int count : map.values()) {
            if (count == 1) {
                return true;
            }
        }
        return false;
    }
}