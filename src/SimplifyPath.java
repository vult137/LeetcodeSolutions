import java.util.*;

// 71. Simplify Path
public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> s = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String part: path.split("/")) {
            if (part.equals("..") && !s.isEmpty()) s.pop();
            else if (!skip.contains(part)) s.push(part);
        }
        StringBuilder res = new StringBuilder();
        for (String part:s) res.insert(0, "/" + part);
        return res.length() == 0 ? "/" : res.toString();
    }
}
