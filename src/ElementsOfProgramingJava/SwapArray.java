package ElementsOfProgramingJava;

import java.util.Collections;
import java.util.List;

public class SwapArray {
    public static void swapArrElement(int[] arr)
    {
        int nextEven = 0, nextOdd = arr.length -1;
        while(nextEven < nextOdd)
        {
            if(arr[nextEven] % 2 == 0)
                nextEven++;
            else {
                int temp = arr[nextEven];
                arr[nextEven] = arr[nextOdd];
                arr[nextOdd] = temp;
                nextEven++;
                nextOdd--;
            }
        }
    }

    public static void swapArrElementList(List<Integer> arrList)
    {
        int nextEven = 0, nextOdd = arrList.size() - 1;
        while(nextEven < nextOdd)
        {
            if(arrList.get(nextEven) % 2 == 0)
                nextEven++;
            else {
                Collections.swap(arrList, nextEven, nextOdd--);
            }
        }
    }
}
