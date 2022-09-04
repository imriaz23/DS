public class MaxSubArraySum {
    /*
     * Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any
     * contiguous subarray of size ‘k’. Input : [2, 1, 5, 1, 3, 2] k = 3 Output : 9
     */

    // Time: O(n^2) Space : O(1)
    public static int findMaximumSubArraySumOfK1(int[] nums, int k) {
        if (nums.length <= 0 || k <= 0) {
            return -1;
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public static int findMaximumSubArraySumOfK2(int[] nums, int k) {
        if (nums.length <= 0 || k <= 0) {
            return -1;
        }
        int n = nums.length;
        int windStart = 0;
        int maxSubArraySum = Integer.MIN_VALUE;
        int windowSum = 0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            windowSum += nums[windowEnd];
            if (windowEnd >= k - 1) {
                if (windowSum > maxSubArraySum) {
                    maxSubArraySum = windowSum;
                }
                windowSum -= nums[windStart];
                windStart++;
            }
        }
        return maxSubArraySum;
    }

    public static void main(String[] args) {
        System.out.println(findMaximumSubArraySumOfK2(new int[] {2, 3, 4, 1, 5}, 2));
    }
}
