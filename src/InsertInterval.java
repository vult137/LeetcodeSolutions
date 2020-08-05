import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 57. Insert Interval
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) merged.add(intervals[i++]);
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        merged.add(newInterval);

        while (i < intervals.length) merged.add(intervals[i++]);

        int[][] res = new int[merged.size()][2];
        for(int k = 0; k < merged.size(); k++) {
            res[k] = merged.get(k);
        }
        return res;
    }

}
