package AlgoPattern.SlidingWindow;

// Given an array of positive numbers and a positive number ‘k,’ find the minimum sum of any contiguous subarray of size ‘k’.
// [2, 1, 5, 1, 3, 2], k=3 = 9 Max sum
// [2, 1, 5, 1, 3, 2], k=3 = 6 Min sum
public class MaximumSumSubarray {
    public static int findMaxSumBruteForce(int[] arr, int k){
        int maxSum = 0, sum;
        for(int i = 0; i <= arr.length - k; i++){
            sum = 0;
            for(int j = i; j < i + k; j++){
                sum += arr[j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum; // O(N ^ 2)
    }

    //

    public static int findMinSumBruteForce(int[] arr, int k){
        int minSum = Integer.MAX_VALUE, sum; // Look up the const of Integer.MAX_VALUE / Integer.MIN_VALUE
        for(int i = 0; i <= arr.length - k; i++){
            sum = 0;
            for(int j = i; j < i + k; j++){
                sum += arr[j];
            }
            minSum = Math.min(minSum, sum); // Look up the Math.min function in java
        }
        return minSum; // O(N ^ 2)
    }

    public static int findMaxSumEffi(int[] arr, int k){
        int maxSum = Integer.MIN_VALUE, sum = 0, windowStart = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            sum += arr[windowEnd];
            if(windowEnd >= k -1){
                maxSum = Math.max(maxSum, sum);
                sum -= arr[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }

    public static int findMinSumEffi(int[] arr, int k) {
        int minLength = Integer.MAX_VALUE, sum = 0, start = 0;
        for(int end = 0; end < arr.length; end++){
            sum += arr[end];
            if(end >= k - 1){
                minLength = Math.min(minLength, sum);
                sum -= arr[start];
                start++;
            }
        }
        return minLength;
    }

}
