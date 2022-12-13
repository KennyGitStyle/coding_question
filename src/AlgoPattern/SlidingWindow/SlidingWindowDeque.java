package AlgoPattern.SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class SlidingWindowDeque {
    /*
    * Given an integer array and a window of size w,
    * find the current maximum value in the window as it slides through the entire array.
    * Constraints:
    *  1 <= array.length <= 10^3
    * -10^4 <= array.length[i] <= 10^4
    *  1 <= window
    * Input: [-4, 2, -5, 1, -1, 6] // Out of bound
    * window = 3
    * result = [2, 2, 1, 6]
    */
    public static Deque<Integer> maxSlindingWindow(List<Integer> nums, int windowSize)
    {
        /*
         1. Process the size of k
         2. Start iterating the list.
         3. In the deque, only keep the indexes of the elements from the current sliding window.
         4. Remove indexes of all elements smaller than the current sliding window from the deque.
         5. Add the current element to the deque.
         6. Add the first element to the deque output list.
         7.  Repeat the above steps until we get all the positive numbers.
         */

        Deque<Integer> result = new ArrayDeque<>();
        Deque<Integer> window = new ArrayDeque<>();

        // Input: [0] then return result
        // Return 0 if num is empty
        if(nums.size() == 0){
            return result;
        }

        // If window_size is greater than the list size, we need to set the window_size to equal the list.
        if(windowSize > nums.size()){
            windowSize = nums.size();
        }

        boolean flag = false;

        // find out maximum value in the first window.
        for(int w = 0; w < windowSize; w++){
            // For every element, remove the previous smaller elements from the window
            while(!window.isEmpty() && nums.get(w) >= nums.get(window.peekLast()))
            {
                window.removeLast();
            }

            // This is only for the purpose of printing..
            if(!flag){
                if(window.isEmpty()){
                    nums.get(w);
                }
            }
            flag = false;
            //Add current element at the back of the queue
            window.addLast(w);
        }

        // Append the largest element in the window to the result...
        result.add(nums.get(window.peek()));


        for(int i = windowSize; i < nums.size(); i++)
        {
            // Remove all numbers that are smaller than current number from the end of the list.
            while(!window.isEmpty() && nums.get(i) >= nums.get(window.peekLast())){
                flag = true;
                window.removeLast();
            }
            if(!flag)
            {
                if(window.isEmpty())
                {
                    nums.get(i);
                }
            }
            flag = false;

            // Remove the first index from the window of the deque if it doesnt fall in the current window anymore.
            if(!window.isEmpty() && window.peek() <= (i - windowSize))
            {
                window.removeFirst();
            }
            // Add the current element at the back of the queue.
            window.addLast(i);
            result.addLast(window.peek());;
        }
        return result;
    }
}
