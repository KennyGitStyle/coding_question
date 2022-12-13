package AlgoPattern;

public class MinimumSubarray {
    public static int subArrayMinimum(int k, int arr[])
    {
        int start = 0, max = Integer.MAX_VALUE, sum = 0;
        for(int end = 0; end < arr.length; end++)
        {
            sum += arr[end];
            while(sum >= k){
                max = Math.min(max, end - start + 1);
                sum -= arr[start];
                start++;
            }
        }
        return max;
    }
}
