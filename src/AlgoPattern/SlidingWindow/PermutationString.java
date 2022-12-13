package AlgoPattern.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationString {
    /*
    *Given a string and a pattern, find out if the string contains any permutation of the pattern.
    Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:
    abc
    acb
    bac
    bca
    cab
    cba
    If a string has ‘n’ distinct characters, it will have n! permutations.
    *
    * Input: String="oidbcaf", Pattern="abc"
        Output: true
        Explanation: The string contains "bca" which is a permutation of the given pattern.
      Input: String="odicf", Pattern="dc"
        Output: false
        Explanation: No permutation of the pattern is present in the given string as a substring.
    * */
    public boolean findPermutation(String perString, String pattern)
    {
        int start = 0, perMatch = 0;
        Map<Character, Integer> permMap = new HashMap<>();
        for(char chr : pattern.toCharArray())
        {
            permMap.put(chr, permMap.getOrDefault(chr, 0) + 1);
        }

        for(int end = 0; end < perString.length(); end++){
            char rightSideChar = perString.charAt(end);
            permMap.put(rightSideChar, permMap.get(rightSideChar) - 1);
            if(permMap.containsKey(rightSideChar))
            {
               perMatch++;
            }

            if(perMatch == permMap.size())
            {
                return true;
            }

            if(end >= pattern.length() - 1){
                char leftSideChar = perString.charAt(start++);
                if(permMap.containsKey(leftSideChar))
                {
                    if(permMap.get(leftSideChar) == 0)
                    {
                        perMatch++;
                    }
                    permMap.put(leftSideChar, permMap.get(leftSideChar) + 1);
                }
            }
        }
        return false; // O(N + M)
    }
}
