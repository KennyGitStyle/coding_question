package AlgoPattern.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagram {
    /*
    * String Anagrams (hard)
      Given a string and a pattern, find all anagrams of the pattern in the given string.
      Every anagram is a permutation of a string. As we know,
      when we are not allowed to repeat characters while finding permutations of a string, we get N!
      permutations (or anagrams) of a string having N

      characters. For example, here are the six anagrams of the string “abc”:
        abc
        acb
        bac
        bca
        cab
        cba
     Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
    *
    * Input: String="abbcabc", Pattern="abc"
    Output: [2, 3, 4]
    Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
    */

    public static List<Integer> findAnagrams(String str, String pattern)
    {
        int start = 0, matched = 0;
        Map<Character, Integer> charAnagramMap = new HashMap<>();
        for(char chr : pattern.toCharArray())
        {
            charAnagramMap.put(chr, charAnagramMap.getOrDefault(chr, 0) + 1);
        }

        List<Integer> resultIndices = new ArrayList<>();

        for(int end = 0; end < str.length(); end++)
        {
            char rightSideChar = str.charAt(end);
            if(charAnagramMap.get(rightSideChar) == 0)
            {
                matched++;
            }

            if(matched == charAnagramMap.size())
            {
                resultIndices.add(start);
            }

            if(end >= pattern.length() -1)
            {
                char leftSideChar = str.charAt(start++);
                if(charAnagramMap.containsKey(leftSideChar)){
                    if(charAnagramMap.get(leftSideChar) == 0)
                    {
                        matched--;
                    }
                    charAnagramMap.put(leftSideChar, charAnagramMap.get(leftSideChar) + 1);
                }
            }
        }
        return resultIndices;
    }
}
