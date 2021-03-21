import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 207. Course Schedule
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] g = new int[numCourses + 5][numCourses + 5];
        int[] degree = new int[numCourses + 5];

        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];
            degree[b]++;
            g[a][b] = 1;
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (degree[i] == 0)
                q.add(i);
        while (!q.isEmpty()) {
            int course = q.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (g[course][i] != 0) {
                    if (--degree[i] == 0)
                        q.offer(i);
                }
            }
        }
        return count == numCourses;
    }
}
