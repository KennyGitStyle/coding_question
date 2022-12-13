package Arrays.ProductSum;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class FindSum {
    public static int[] twoNumSum(int[] arr, int n)
    {
        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();
        IntStream.range(0, arr.length).forEach(i -> {
            if (set.contains(n - arr[i])) {
                result[0] = arr[i];
                result[1] = n - arr[i];
            }
            set.add(arr[i]);
        });
        return result;

    }
}
