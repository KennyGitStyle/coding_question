package AlgoPattern.SlidingWindow;

// Given an array, find the average of each subarray of ‘K’ contiguous elements in it.

// Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5

// (1+3+2+6-1+4)/5 => 2.8

// 1 + 3 + 2 + 6 - 1

// 3 + 2 + 6 - 1 + 4

// 2 + 6 - 1 + 4 + 1 ...

public class AverageSubarray {
    public static double[] findAverageBruteForce(int[] arr, int k){
        double[] result = new double[arr.length - k + 1];
        for(int i = 0; i <= arr.length - k; i++){
            double sum = 0; // sum is to store value for result..
            for(int j = i; j < i + k; j++){
                sum += arr[j];
                result[i] = sum / k;
            }
        }
        return result; // O(N ^ 2)
    }

    public static double[] findAverageEffi(int[] arr, int k){
        double[] result = new double[arr.length - k + 1];
        double windowSum = 0;
        int start = 0;
        for(int end = 0; end < arr.length; end++){
            windowSum += arr[end];
            if(end >= k - 1){
                result[start] = windowSum / k;
                windowSum -= arr[start];
                start++;
            }
        }
        return  result; // O(N)
    }

}
