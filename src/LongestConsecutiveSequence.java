import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 128. Longest Consecutive Sequence
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int cnt = 0;
        int maxRes = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i] != nums[i - 1] + 1) {
                maxRes = Math.max(cnt + 1, maxRes);
                cnt = 0;
            } else cnt++;
        }
        if (cnt != 0) maxRes = Math.max(cnt + 1, maxRes);
        return maxRes;
    }
}
