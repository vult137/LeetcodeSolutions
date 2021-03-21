import java.util.ArrayList;
import java.util.List;

// 131. Palindrome Partitioning
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) dp[j][i] = true;
            }
        }
        List<List<String>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), s, dp, 0);
        return res;
    }

    public void helper(List<List<String>> res, List<String> path, String s, boolean[][] dp, int pos) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            if (dp[pos][i]) {
                path.add(s.substring(pos, i + 1));
                helper(res, path, s, dp, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
