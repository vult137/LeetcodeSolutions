// 204. Count Primes
public class CountPrimes {
    public int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] holder = new boolean[n + 1];
        holder[1] = true;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (!holder[i]) {
                count++;
                for (int j = 2; i * j <= n; j++)
                    holder[i * j] = true;
            }
        }
        return count;
    }
}
