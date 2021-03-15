import java.util.HashMap;
import java.util.Map;

// 205. Isomorphic Strings
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        String s1 = getSimplifiedString(s);
        String t1 = getSimplifiedString(t);
        return s1.equals(t1);
    }

    public String getSimplifiedString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                sb1.append(i);
            } else {
                sb1.append(map.get(s.charAt(i)));
            }
        }
        return sb1.toString();
    }
}
