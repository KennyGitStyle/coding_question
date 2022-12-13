package AlgoPattern;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

public class MaxSlidingWindow {
    public static ArrayDeque<Integer> findMaxSlidingWin(int[] arr, int w)
    {
        ArrayDeque<Integer> result = new ArrayDeque<>(); // ArrayDeque for storing values
        Deque<Integer> list = new ArrayDeque<>(); // creating a linked list

        // returning result
        if (arr.length <= 0) return result;
        // If window_size is greater than the array size,
        // set the window_size to nums.size()
        if (arr.length < w)
            w = arr.length;
        // Removing last smallest element index
        // Adding newly picked element index
        IntStream.range(0, w).forEach(i -> {
            while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
                list.removeLast();
            }
            list.addLast(i);
        });

        int i = w;
        while (i < arr.length) {
            result.add(arr[list.peek()]);

            // Removing all the elements indexes which are not in the current window
            while ((!list.isEmpty()) && list.peek() <= i - w) list.removeFirst();

            // Removing the smaller elements indexes which are not required
            while ((!list.isEmpty()) && arr[i] >= arr[list.peekLast()]) {
                list.removeLast();
            }

            // Adding newly picked element index
            list.addLast(i);
            ++i;
        }

        // Adding the max number of the current window in the result
        result.add(arr[list.peek()]);
        return result;


    }
}
