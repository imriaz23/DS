import java.util.*;

public class LongestSubStringDistinctChar {

    public static int findLongestSubtringWithNoRepeatingCharacter(String str) {
        int ans = 0;
        int windowStart = 0;
        Map<Character, Integer> index = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (index.containsKey(rightChar)) {
                windowStart = Math.max(windowStart, index.get(rightChar) + 1);
            }
            index.put(rightChar, windowEnd);
            ans = Math.max(ans, windowEnd - windowStart + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findLongestSubtringWithNoRepeatingCharacter("abbbb"));
    }
}
