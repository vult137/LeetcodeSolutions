import java.util.ArrayList;

// 34. Find First and Last Position of Element in Sorted Array
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirst(nums, target);
        res[1] = res[0] == -1 ? -1 : findLast(nums, target);
        return res;
    }

    private int findFirst(int[] nums, int target) {
        int index = -1;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) end = mid - 1;
            else start = mid + 1;
            if (nums[mid] == target) index = mid;
        }
        return index;
    }

    private int findLast(int[] nums, int target) {
        int index = -1;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) start = mid + 1;
            else end = mid - 1;
            if (nums[mid] == target) index = mid;
        }
        return index;
    }

}
