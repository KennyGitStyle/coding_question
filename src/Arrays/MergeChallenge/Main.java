package Arrays.MergeChallenge;

import java.util.Arrays;

import static Arrays.MergeChallenge.MergeTwoSortedArrays.mergeArrays;

public class Main {
    public static void main(String[] args)
    {
        int[] arr1 = {1,2,3,4,5,6,7};
        int[] arr2 = {8,9,10,11,12,13};

        int[] result = mergeArrays(arr1, arr2);

        System.out.println("This is the result: " + Arrays.toString(result));
    }
}
