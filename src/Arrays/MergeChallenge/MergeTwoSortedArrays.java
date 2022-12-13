package Arrays.MergeChallenge;

public class MergeTwoSortedArrays {
    public static int[] mergeArrays(int[] arr1, int[] arr2)
    {
        int i = 0, j = 0, k = 0;
        int arr1Len = arr1.length, arr2Len = arr2.length;
        int[] result = new int[arr1.length + arr2.length];
        while(i < arr1Len && j < arr2Len)
        {
            if(arr1[i] < arr2[j]){
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while(i < arr1Len)
        {
            result[k++] = arr1[i++];
        }

        while(j < arr2Len)
        {
            result[k++] = arr2[j++];
        }

        return result;
    }
}
