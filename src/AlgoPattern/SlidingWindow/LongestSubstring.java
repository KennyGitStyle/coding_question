package AlgoPattern.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
* Given a string, find the length of the longest substring in it with no more than K distinct characters.
*   Input: String="araaci", K=2
    Output: 4
    Explanation: The longest substring with no more than '2' distinct characters is "araa".
*/

public class LongestSubstring {
    public static int longestSubstringMaximumKDistinctCharacters(String str, int k){
        int maxLengthChar = 0, start = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        // In the following loop we'll try to extend the range [start, end]
        for(int end = 0; end < str.length(); end++){
            char rightSideChar = str.charAt(end);
            // shrink the sliding window, until we are left with 'k' distinct characters in the charMap (HashMap)
            charMap.put(rightSideChar, charMap.getOrDefault(rightSideChar, 0) + 1);
            while(charMap.size() > k){
                char leftSideCharacter = str.charAt(start);
                charMap.put(leftSideCharacter, charMap.get(leftSideCharacter) - 1);
                if(charMap.get(leftSideCharacter) == 0)
                    charMap.remove(leftSideCharacter);
                start++;
            }
            maxLengthChar = Math.max(maxLengthChar, end - start + 1); // Remember maximum length...

        }
        return maxLengthChar; // Time: O(N + N) = O(N) | Space = O(k)
    }

}
