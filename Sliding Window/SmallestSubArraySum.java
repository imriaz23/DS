public class SmallestSubArraySum {
    /*
     * Given an array of positive numbers and a positive number ‘S’, find the length of the smallest
     * contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray
     * exists.
     * 
     * Input: [2, 1, 5, 2, 3, 2], S=7 Output: 2 Explanation: The smallest subarray with a sum great
     * than or equal to '7' is [5, 2].
     */
    public static int findSmallestSubArrayofSum1(int nums[], int sum) {
        int n = nums.length;
        if (n <= 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int windowSum = 0;
            for (int j = i; j < n; j++) {
                windowSum += nums[j];
                if (windowSum == sum) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }

            }

        }

        return ans;
    }

    public static int findSmallestSubArrayofSum2(int nums[], int sum) {
        int n = nums.length;
        if (n <= 0) {
            return 0;
        }
        int windowSum = 0;
        int windowStart = 0;
        int minSubArraySize = Integer.MAX_VALUE;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            windowSum += nums[windowEnd];
            while (windowSum >= sum) {
                minSubArraySize = Math.min(minSubArraySize, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }
        return minSubArraySize;
    }

    public static void main(String[] args) {
        System.out.println(findSmallestSubArrayofSum2(new int[] {3, 4, 1, 1, 6}, 8));
    }
}
