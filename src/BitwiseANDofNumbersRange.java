// 201. Bitwise AND of Numbers Range
public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0){
            return 0;
        }
        int moveFactor = 1;
        while(m != n){
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }

    public static void main(String[] args) {
        BitwiseANDofNumbersRange bit = new BitwiseANDofNumbersRange();
        System.out.println(bit.rangeBitwiseAnd(5,7));
    }
}
