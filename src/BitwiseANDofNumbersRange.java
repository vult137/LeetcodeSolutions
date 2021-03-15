// 201. Bitwise AND of Numbers Range
public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        int res = left;
        for (int i = left + 1; i <= right; i++) {
            res = res & i;
        }
        return res;
    }

    public static void main(String[] args) {
        BitwiseANDofNumbersRange bit = new BitwiseANDofNumbersRange();
        System.out.println(bit.rangeBitwiseAnd(5,7));
    }
}
