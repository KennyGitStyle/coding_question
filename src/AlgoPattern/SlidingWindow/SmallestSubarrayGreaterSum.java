package AlgoPattern.SlidingWindow;

/*
* Given an array of positive integers and a number ‘S,’
* find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
* Return 0 if no such subarray exists.
* Input: [2, 1, 5, 2, 3, 2], S=7
*/

public class SmallestSubarrayGreaterSum {
    public static int SmallestSubarrayGreaterSum(int[] arr, int s){
        int start = 0, minLengthOfSmallestSum = Integer.MAX_VALUE, sum = 0;
        for(int end = 0; end < arr.length; end++){
            sum += arr[end];
            while(sum >= s){
                minLengthOfSmallestSum = Math.min(minLengthOfSmallestSum, end - start + 1);
                sum -= arr[start];
                start++;
            }
        }
        return minLengthOfSmallestSum == Integer.MAX_VALUE ? 0 : minLengthOfSmallestSum; // O(N + N) = O(N)
    }

}
