import AlgoPattern.SlidingWindowPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static AlgoPattern.MinimumSubarray.subArrayMinimum;
import static AlgoPattern.SlidingWindowPattern.findAverageSlidingWindow;
import static BinarySearch.SearchRotatedArray.rotatedBinarySearch;
import static ElementsOfProgramingJava.SwapArray.swapArrElement;
import static ElementsOfProgramingJava.SwapArray.swapArrElementList;
import static JavaFundamentalsForCoding.Slicing.sliceArray;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6};
        System.out.println(Arrays.toString(arr));
        swapArrElement(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();
        System.out.print("ArrayList: ");
        List<Integer> result = new ArrayList<>();
        result.add(2);
        result.add(3);
        result.add(4);
        result.add(5);
        result.add(6);
        System.out.println("Before swap: " + result);
        swapArrElementList(result);
        System.out.println("Modified: " + result);
    }


}