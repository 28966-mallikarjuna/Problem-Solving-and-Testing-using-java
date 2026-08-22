class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int currMax = 0, maxSum = nums[0];
        int currMin = 0, minSum = nums[0];
        
        for (int num : nums) {
            totalSum += num;
            
            // Standard Kadane's for maximum subarray
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);
            
            // Kadane's variant for minimum subarray
            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);
        }
        
        // If all numbers are negative, maxSum will be the maximum negative number,
        // and totalSum will equal minSum. Return maxSum to ensure a non-empty subarray.
        if (maxSum < 0) {
            return maxSum;
        }
        
        // The max sum is either the normal max or the circular max (totalSum - minSum)
        return Math.max(maxSum, totalSum - minSum);
    }
}
