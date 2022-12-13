package AlgoPattern.SlidingWindow;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Integer> targetList = Arrays.asList(3, 3, 3, 3, 2, 4, 3, 2, 3, 18);

        List<List<Integer>> numLists = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1),
                Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10),
                Arrays.asList(1, 5, 8, 10, 10, 10, 12, 14, 15, 19, 19, 19, 17, 14, 13, 12, 12, 12, 14, 18, 22, 26, 26, 26, 28, 29, 30),
                Arrays.asList(10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67),
                Arrays.asList(4, 5, 6, 1, 2, 3),
                Arrays.asList(9, 5, 3, 1, 6, 3),
                Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16),
                Arrays.asList(-1, -1, -2, -4, -6, -7),
                Arrays.asList(4, 4, 4, 4, 4, 4)
        );

        for(int i = 0; i < numLists.size(); i++)
        {
            System.out.println(i + 1 + ", Original array:\t" + numLists.get(i));

            System.out.println("Input window size:\t\t\t" + targetList.get(i));

            System.out.println("Window size used for the problem:\t " +
                    SlidingWindowDeque.maxSlindingWindow(numLists.get(i), targetList.get(i)));
        }

    }

}

