package AlgoPattern.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripleSumZero {

    /*
    Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

    Input: [-3, 0, 1, 2, -1, 1, -2]
    Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
    Explanation: There are four unique triplets whose sum is equal to zero.
    * */

    public static List<List<Integer>> searchTriplets(int[] arr)
    {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for(int i = 0; i < arr.length - 2; i++)
        {
            if(i > 0 && arr[i] == arr[i - 1])
            {
                continue;
            }
            findPairs(arr, -arr[i], i + 1, triplets);
        }

        return triplets;
    }

    private static void findPairs(int[] arr, int target, int left, List<List<Integer>> triplet)
    {
        int right = arr.length - 1;

        while(left < right)
        {
            int currentSum = arr[left] + arr[right];

            if(currentSum == target)
            {
                triplet.add(Arrays.asList(-target, arr[left], arr[right]));
                left++;
                right--;
                while(left < right && arr[left] == arr[left - 1])
                    left++;
                while(left < right && arr[right] == arr[right + 1])
                    right--;
            } else if(target > currentSum)
            {
                left++;
            } else
                right--;

        }

    }
}
