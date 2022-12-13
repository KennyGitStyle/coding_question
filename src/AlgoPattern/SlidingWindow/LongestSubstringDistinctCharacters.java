package AlgoPattern.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringDistinctCharacters {
    /*
    Given a string, find the length of the longest substring, which has all distinct characters.

     Input: String="aabccdb"
    Output: 3
    Explanation: The longest substring with distinct characters is "abc".

    Input: String="abbbb"
    Output: 2
    Explanation: The longest substring with distinct characters is "ab".

    Input: String="abccde"
    Output: 3
    Explanation: Longest substrings with distinct characters are "abc" & "cde".
    */

    public static int longestSubstringDistinctCharacters(String strChar)
    {
        int start = 0; // increment from start element in the sliding window...
        int maxCharLength = 0; // Length of distinct character...

        Map<Character, Integer> charMap = new HashMap<>();
        for(int end = 0; end < strChar.length(); end++){
            char rightSideChar = strChar.charAt(end);
            if(charMap.containsKey(rightSideChar)) {
                start = Math.max(start, charMap.get(rightSideChar) + 1);
            }
            charMap.put(rightSideChar, end);
            maxCharLength = Math.max(maxCharLength, end - start + 1);
        }
        return maxCharLength;
    }
}
