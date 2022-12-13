package AlgoPattern.TwoPointer;

public class SquaringSortedArray {
    /*
    * Given a sorted array, create a new array containing squares of
    * all the numbers of the input array in the sorted order.
    *
    * Input: [-2, -1, 0, 2, 3]
      Output: [0, 1, 4, 4, 9]

      Input: [-3, -1, 0, 1, 2]
      Output: [0, 1, 1, 4, 9]
    * */
    public static int[] makeSquares(int[] arr)
    {
        int squareNumbers[] = new int[arr.length];
        int highestSquareCount = arr.length - 1;
        int left = 0, right = arr.length - 1;
        while(left <= right)
            {
                int leftSquare = arr[left] * arr[left];
                int rightSquare = arr[right] * arr[right];
                if(leftSquare > rightSquare)
            {
                squareNumbers[highestSquareCount--] = leftSquare;
                left++;
            } else{
                squareNumbers[highestSquareCount--] = rightSquare;
                right--;
            }
        }

        return squareNumbers;
    }
}
