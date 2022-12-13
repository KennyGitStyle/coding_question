package AlgoPattern.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowContainingSubstring {
    /*
    * Given a string and a pattern, find the smallest substring
    * in the given string which has all the character occurrences of the given pattern.
    *
    * Input: String="aabdec", Pattern="abc"
      Output: "abdec"
      Explanation: The smallest substring having all characters of the pattern is "abdec"
      *
      * Input: String="aabdec", Pattern="abac"
        Output: "aabdec"
        Explanation: The smallest substring having all character occurrences of the pattern is "aabdec"
    * */
    public static String findSubString(String str, String pattern)
    {
        int start = 0, matchedElement = 0, minLength = str.length() + 1, subStringStart = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for(char chrArr : pattern.toCharArray())
        {
            charFreqMap.put(chrArr, charFreqMap.getOrDefault(chrArr, 0) + 1);
        }

        for(int end = 0; end < str.length(); end++)
        {
            char rightSideChar = str.charAt(end);
            if(charFreqMap.containsKey(rightSideChar))
            {
                charFreqMap.put(rightSideChar, charFreqMap.get(rightSideChar) - 1);
                if(charFreqMap.get(rightSideChar) >= 0)
                {
                    matchedElement++;
                }
            }

            while(matchedElement == pattern.length())
            {
                if(minLength > end - start + 1)
                {
                    minLength = end - start + 1;
                    subStringStart = start;
                }
            }

            char leftSideChar = str.charAt(start++);
            if(charFreqMap.containsKey(leftSideChar))
            {

                if(charFreqMap.get(leftSideChar) == 0)
                {
                    matchedElement--;
                }

                charFreqMap.put(leftSideChar, charFreqMap.get(leftSideChar) + 1);
            }

        }

        return minLength > str.length() ? "" : str.substring(subStringStart, subStringStart + minLength);

    }
}
