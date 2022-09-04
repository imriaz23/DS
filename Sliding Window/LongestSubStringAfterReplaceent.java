import java.util.*;

public class LongestSubStringAfterReplaceent {
    public static int findLongestSubStringAfterreplacingKLetter(String str, int k) {
        if (str.length() <= 0) {
            return 0;
        }
        int windowStart = 0;
        int maxRepeatingLetterCount = 0;
        int ans = 0;
        Map<Character, Integer> charFreqCount = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFreqCount.put(rightChar, charFreqCount.getOrDefault(rightChar, 0) + 1);
            maxRepeatingLetterCount =
                    Math.max(maxRepeatingLetterCount, charFreqCount.get(rightChar));

            if (windowEnd - windowStart + 1 - maxRepeatingLetterCount > k) {
                char leftChar = str.charAt(windowStart);
                charFreqCount.put(leftChar, charFreqCount.get(leftChar) - 1);
                windowStart++;
            }
            ans = Math.max(ans, windowEnd - windowStart + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findLongestSubStringAfterreplacingKLetter("aabccbb", 2));
    }
}
