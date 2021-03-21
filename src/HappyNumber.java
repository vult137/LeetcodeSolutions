// 202. Happy Number
public class HappyNumber {
    public boolean isHappy(int n) {
        int res = n;
        while (res > 10) {
            res = squareSum(res);
        }
        return res == 1;
    }

    public int squareSum(int n) {
        int res = 0;
        while (n > 0) {
            int tmp = n % 10;
            res += tmp * tmp;
            n /= 10;
        }
        return res;
    }
}
