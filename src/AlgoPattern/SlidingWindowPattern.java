package AlgoPattern;

public class SlidingWindowPattern {
    public static double[] findAverageBruteForce(int k, int[] arr)
    {
        double[] result = new double[arr.length - k + 1];
        for(int i = 0; i <= arr.length - k; i++)
        {
            double sum = 0;
            for(int j = i; j < i + k; j++)
            {
                sum += arr[j];
            }
            result[i] = sum / k;
        }
        return result;
    }

    public static double[] findAverageSlidingWindow(int k, int[] arr)
    {
        double[] result = new double[arr.length - k + 1];
        double sum = 0;
        int start = 0;
        for(int end = 0; end < arr.length; end++)
        {
            sum += arr[end];
            if(end >= k - 1){
                result[start] = sum / k;
                sum -= arr[start];
                start++;
            }
        }
        return result;
    }

}
