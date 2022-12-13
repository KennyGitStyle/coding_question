package BinarySearch;

public class LowHighBinarySearch {
    static int findIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length -1;
        if (low < nums.length && nums[low] == target)
            return lowHighIndexBinarySearch(nums, target, low + 1, high);
        else if (high < nums.length && nums[high] == target)
            return lowHighIndexBinarySearch(nums, target, low, high + 1);
        return -1;
    }
    public static int lowHighIndexBinarySearch(int[] arr, int target, int start, int end)
    {

        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if(mid < target)
                start += 1;
            else
                end -= 1;
        }
        return -1;
    }
}
