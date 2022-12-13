package Arrays.ProductSum;

import java.util.Arrays;

import static Arrays.ProductSum.FindSum.twoNumSum;

public class Main {
    public static void main(String[] args)
    {
        int arr[] = {23, 21, 23, 18, 28, 21, 20};
        int num = 41;

        int[] result = twoNumSum(arr, num);

        System.out.println("This is the result: " + Arrays.toString(result));
    }
}
