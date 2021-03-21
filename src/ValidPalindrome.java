// 125. Valid Palindrome
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = preprocess(s);
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    public String preprocess(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                sb.append(c);
            }
        }
        return sb.toString().toLowerCase();
    }
}
