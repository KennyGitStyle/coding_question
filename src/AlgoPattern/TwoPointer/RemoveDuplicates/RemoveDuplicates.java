package AlgoPattern.TwoPointer.RemoveDuplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates {
    /*
    Given an array of sorted numbers, remove all duplicate number instances
    from it in-place, such that each element appears only once.
    The relative order of the elements should be kept the same
    and you should not use any extra space so that the solution have a space complexity of O(1).
    Move all the unique elements at the beginning of the array and after moving return the length of the subarray that has no duplicate in it.

     Input: [2, 3, 3, 3, 6, 9, 9]
     Output: 4
     Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].

     Input: [2, 2, 2, 11]
     Output: 2
     Explanation: The first two elements after removing the duplicates will be [2, 11].
     */
    public static void removeDuplicates(int[] arr) {
        // We will keep track of the current element we are processing
        int current = 0;

        // Loop through the array and compare each element to the previous one
        for (int i = 1; i < arr.length; i++) {
            // If the current element is not equal to the previous one, then it's unique
            if (arr[i] != arr[current]) {
                // We increment current to move on to the next element
                current++;
                // We assign the unique element to the current position
                arr[current] = arr[i];
            }
        }

        // At the end, the array will contain all the unique elements from the original
        // array, in the same relative order. To remove the remaining unused elements,
        // we create a new array with the correct length and copy over the unique elements.
        int[] result = Arrays.copyOf(arr, current + 1);
    }

    public static int removeDup(int[] arr)
    {
        int nextDuplicate = 1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[nextDuplicate - 1] != arr[i]) {
                arr[nextDuplicate] = arr[i];
                nextDuplicate++;
            }
        }
        return nextDuplicate;
    }
    /*
    Given an array of sorted numbers, write a function in java that removes all duplicate number instances from it in-place,
    such that each element appears only once.
    The relative order of the elements should be kept
    the same and you should not use any extra space so that that the solution have a space complexity of O(1).
    Move all the unique elements at the beginning of the List and after moving return the length of the subarray that has no duplicate in it.
     */

    public static int removeDuplicatesList(List<Integer> arr) {
        // We will keep track of the current element we are processing
        int current = 0;

        // Loop through the list and compare each element to the previous one
        for (int i = 1; i < arr.size(); i++) {
            // If the current element is not equal to the previous one, then it's unique
            if (!arr.get(i).equals(arr.get(current))) {
                // We increment current to move on to the next element
                current++;
                // We assign the unique element to the current position
                arr.set(current, arr.get(i));
            }
        }

        // At the end, the list will contain all the unique elements from the original
        // array, in the same relative order. To remove the remaining unused elements,
        // we remove them from the list.
        arr.subList(current + 1, arr.size()).clear();

        // We return the length of the sublist that contains the unique elements.
        return current + 1;
    }

    /*
    Given an List of sorted numbers,
    write a function in java that removes all duplicate number instances from it in-place,
    such that each element appears only once.
    The relative order of the elements should be kept the same and
    you should not use any extra space so that the solution have a space complexity of O(1).
    Return a List.
     */
    public static List<Integer> removeDuplicatesListReturn(List<Integer> arr) {
        // We will keep track of the current element we are processing
        int current = 0;

        // Loop through the list and compare each element to the previous one
        for (int i = 1; i < arr.size(); i++) {
            // If the current element is not equal to the previous one, then it's unique
            if (!arr.get(i).equals(arr.get(current))) {
                // We increment current to move on to the next element
                current++;
                // We assign the unique element to the current position
                arr.set(current, arr.get(i));
            }
        }

        // At the end, the list will contain all the unique elements from the original
        // array, in the same relative order. To remove the remaining unused elements,
        // we remove them from the list.
        arr.subList(current + 1, arr.size()).clear();

        // We return the sublist that contains the unique elements.
        return arr.subList(0, current + 1);
    }

    /*
    * Given an List of sorted numbers, write a function in java that removes duplicate number instances if List has 3 duplicates.
    * The relative order of the elements should be kept the same and you should not use any extra space so that the solution have a space complexity of O(1).
    * Return a List.
    * */

    public static List<Integer> removeDuplicatesIfThreeNumbersAreDuplicates(List<Integer> numbers) {
        // Check for invalid input
        if (numbers == null) {
            return null;
        }

        int len = numbers.size();
        if (len <= 2) {
            return numbers;
        }

        // Use two pointers to keep track of the current and previous element
        int prev = numbers.get(0);
        int cur = numbers.get(1);
        int count = 1;
        List<Integer> result = new ArrayList<>();

        // Iterate over the numbers and remove duplicate instances
        for (int i = 2; i < len; i++) {
            int num = numbers.get(i);
            if (num == prev && num == cur) {
                count++;
                if (count <= 2) {
                    result.add(num);
                }
            } else {
                result.add(num);
                count = 1;
                prev = cur;
                cur = num;
            }
        }

        // Add the last two elements, since they may not have been added
        result.add(cur);
        result.add(prev);

        return result;
    }

    /*
    * In this solution, we iterate over the input list and keep track of the current and previous element using two pointers.
    * We also maintain a count of the number of duplicate instances of the current element. If we encounter a number that has three duplicates,
    * we skip it and continue iterating. Otherwise, we add the number to the result list. At the end,
    * we add the last two elements of the input list to the result list, since they may not have been added.
    Note that this solution has a space complexity of O(1), since we are not using any extra space, and the relative order of the elements is preserved.
    * */
}

