package AlgoPattern.TwoPointer;

public class TwoPointerSummary {
    /*
    * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.

        Input: [1, 2, 3, 4, 6], target=6
        Output: [1, 3]
        Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6

        Input: [2, 5, 9, 11], target=11
        Output: [0, 2]
        Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11



    *
    * To solve this problem, we can consider each element one by one (pointed out by the first pointer)
    * and iterate through the remaining elements (pointed out by the second pointer)
    * to find a pair with the given sum. The time complexity of this algorithm will be O(N^2)
        O(N^2)
     where ‘N’ is the number of elements in the input array.

    Given that the input array is sorted, an efficient way would be to start with one pointer
*   in the beginning and another pointer at the end. At every step, we will see
*   if the numbers pointed by the two pointers add up to the target sum. If they do not, we will do one of two things:

    If the sum of the two numbers pointed by the two pointers is greater than
*   the target sum, this means that we need a pair with a smaller sum. So, to try more pairs, we can decrement the end-pointer.
    If the sum of the two numbers pointed by the two pointers is smaller than the target sum,
*   this means that we need a pair with a larger sum. So, to try more pairs, we can increment the start-pointer.
    Here is the visual representation of this algorithm:
    *
    *
    * */

    public static int[] targetSumSorted(int[] arr, int target)
    {
        int left = 0, right = arr.length - 1;
        while(left < right)
        {
            int currentSum = arr[left] + arr[right];
            if(currentSum == target)
            {
                return new int[] {left, right};
            }

            if(target > currentSum)
            {
                left++;
            } else
            {
                right--;
            }
        }
        return new int[] {-1, -1};
    }
}
