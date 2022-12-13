package JavaFundamentalsForCoding;

import java.util.Arrays;

public class Slicing {
    public static int[] sliceArray(int[] arr)
    {
        // we allocate a new array with the length of the input array
        int[] squaredArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            squaredArray[i] = (int) Math.pow(arr[i], 2);
        }

        return squaredArray;
    }
}
