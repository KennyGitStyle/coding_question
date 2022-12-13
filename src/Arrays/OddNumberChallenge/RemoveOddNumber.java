package Arrays.OddNumberChallenge;

public class RemoveOddNumber {
    public static int[] removeOddNumber(int[] arr)
    {
        int oddNumber = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] % 2 != 0)
                oddNumber++;
        }
        int[] result = new int[oddNumber++];
        int index = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] % 2 != 0)
                result[index++] = arr[i];
        }
        return result;
    }

}
