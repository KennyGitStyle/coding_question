package BinarySearch;

public class SearchRotatedArray {

    public static int rotatedBinarySearch(int[] arr, int target)
    {
        int start = 0, end = arr.length - 1;
        return binarySearch(arr, target, start, end);
    }

    public static int binarySearch(int[] arr, int target, int start, int end)
    {
        if(start > end)
            return -1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target)
                return mid;
            if(arr[start] <= arr[mid]) {
                if (arr[start] <= target && target < arr[mid])
                    end -= 1;
                else
                    start += 1;
            } else {
                if (arr[mid] < target && target <= arr[end])
                    start += 1;
                else
                    end -= 1;
            }

        }
        return -1;
    }
}
