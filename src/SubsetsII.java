import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 90. Subsets II
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> com, int[] nums, int start) {
        res.add(new ArrayList<>(com));
        for (int i = start; i < nums.length; i++) {
            com.add(nums[i]);
            helper(res, com, nums, i + 1);
            com.remove(com.size() - 1);
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }
    }
}
