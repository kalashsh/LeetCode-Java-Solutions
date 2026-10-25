class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);
        int currentSum = 0, result = 0;

        for (int num : nums) {
            currentSum += num;
            result +=   countMap.getOrDefault(currentSum - goal, 0);
            countMap.put(currentSum, countMap.getOrDefault(currentSum, 0) + 1); 
        }

        return result;
    }
}
