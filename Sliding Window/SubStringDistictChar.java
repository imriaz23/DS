import java.util.*;

public class SubStringDistictChar {
    /*
     * Given a string, find the length of the longest substring in it with no more
     * than K distinct characters.
     * 
     * Input: String="araaci", K=2
     * Output: 4
     * Explanation: The longest substring with no more than '2' distinct characters
     * is "araa".
     * 
     * 
     * Input: String="araaci", K=1
     * Output: 2
     * Explanation: The longest substring with no more than '1' distinct characters
     * is "aa".
     * 
     */

    public static int findLongestSubStringwithKDistinctCharacter1(String str, int k) {
        if (str.length() <= 0) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        int n = str.length();
        for (int i = 0; i < n - 1; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(str.charAt(j));
                if (set.size() == k) {
                    ans = Math.max(ans, j - i + 1);
                }

            }
        }
        return ans;
    }

    public static int findLongestSubStringwithKDistinctCharacter2(String str, int k) {
        int n = str.length();
        if (n < 0) {
            return 0;
        }
        int ans = 0;
        int windowStart = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            char endChar = str.charAt(windowEnd);
            charCount.put(endChar, charCount.getOrDefault(endChar, 0) + 1);
            while (charCount.size() > k) {
                char startChar = str.charAt(windowStart);
                charCount.put(startChar, charCount.get(startChar) - 1);
                windowStart++;
                if (charCount.get(startChar) == 0) {
                    charCount.remove(startChar);
                }
            }
            ans = Math.max(ans, windowEnd - windowStart + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findLongestSubStringwithKDistinctCharacter2("cbbebi", 3));
    }
}
