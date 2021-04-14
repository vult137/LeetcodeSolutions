import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 210. Course Schedule II
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] g = new int[numCourses + 5][numCourses + 5];
        int[] degree = new int[numCourses + 5];

        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];
            degree[b]++;
            g[a][b] = 1;
        }
        int count = 0;
        int[] res = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (degree[i] == 0)
                q.add(i);
        while (!q.isEmpty()) {
            int course = q.poll();
            res[numCourses - count - 1] = course;
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (g[course][i] != 0) {
                    if (--degree[i] == 0)
                        q.offer(i);
                }
            }
        }
        if (count != numCourses) return new int[0];
        return res;
    }
}
