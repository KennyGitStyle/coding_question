package Arrays.OddNumberChallenge;

import java.util.Arrays;

import static Arrays.OddNumberChallenge.RemoveOddNumber.removeOddNumber;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,5,7,5,7};
        int[] result = removeOddNumber(arr);

        System.out.println("This is the result: " + Arrays.toString(result));
    }

}
