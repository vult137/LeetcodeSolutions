// 171. Excel Sheet Column Number
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int res = 0;
        for (int i = len - 1; i >= 0; i--) {
            res += (s.charAt(i) - 'A' + 1) * pow26(len - 1 -i);
        }
        return res;
    }

    private int pow26(int n) {
        int res = 1;
        while (n-- > 0) {
            res *= 26;
        }
        return res;
    }
}
