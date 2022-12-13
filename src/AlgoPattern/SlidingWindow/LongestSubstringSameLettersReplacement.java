package AlgoPattern.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringSameLettersReplacement {
    /*
    * Given a string with lowercase letters only,
    * if you are allowed to replace no more than k letters with any letter,
    *  find the length of the longest substring having the same letters after replacement.
    *
    * Input: String="aabccbb", k=2
        Output: 5
        Explanation: Replace the two 'c' with 'b' to have the longest repeating substring "bbbbb".

        * Input: String="abbcb", k=1
          Output: 4
          Explanation: Replace the 'c' with 'b' to have the longest repeating substring "bbbb".
    * */

    public int longestSubstringSameLettersReplacement(String charStr, int k)
    {
        int start = 0, maxCharLength = 0, letterCount = 0;

        Map<Character, Integer> charLetterMap = new HashMap<>();
        for(int end = 0; end < charStr.length(); end++)
        {
            char rightSideChar = charStr.charAt(end);
            charLetterMap.put(rightSideChar, charLetterMap.getOrDefault(rightSideChar, 0) + 1);
            letterCount = Math.max(letterCount, charLetterMap.get(rightSideChar));

            if(end - start + 1 - letterCount > k)
            {
                char leftSideChar = charStr.charAt(start);
                charLetterMap.put(leftSideChar, charLetterMap.get(leftSideChar) - 1);
                start++;
            }

            maxCharLength = Math.max(maxCharLength, end - start + 1);

        }
        return maxCharLength;
    }
}
