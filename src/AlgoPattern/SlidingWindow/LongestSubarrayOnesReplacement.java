package AlgoPattern.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayOnesReplacement {
    /*
    * Given an array containing 0s and 1s,
    * if you are allowed to replace no more than ‘k’ 0s with 1s,
    * find the length of the longest contiguous subarray having all 1s.
    * -------------------------------------------------------------------------------------
    * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
    Output: 6
    Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
    *
    * Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
    Output: 9
    Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
    */

    public static int longestSubarrayOnesReplacement(int[] arr, int k) {
        int start = 0, maxArrLength = 0, maxNumCount = 0;
        for(int end = 0; end < arr.length; end++)
        {
            if(arr[end] == 1)
            {
                maxNumCount++;
            }

            if(end - start + 1 - maxNumCount > k)
            {
                if(arr[start] == 1)
                {
                    maxNumCount--;
                }
                start++;
            }

            maxArrLength = Math.max(maxArrLength, end - start + 1);
        }
        return maxArrLength;
    }
}
