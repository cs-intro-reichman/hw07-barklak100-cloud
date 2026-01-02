public class Binomial {

    public static void main(String[] args) {
    }

    public static long binomial1(int n, int k) {
        return binomial(n, k);
    }

    public static long binomial(int n, int k) {
        if (k > n || k < 0) return 0;
        if (k == 0 || n == k) return 1;

        long[][] memo = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                memo[i][j] = -1;
            }
        }
        return calculateBinomial(n, k, memo);
    }

    private static long calculateBinomial(int n, int k, long[][] memo) {
        if (k > n || k < 0) return 0;
        if (k == 0 || n == k) return 1;
        if (memo[n][k] != -1) return memo[n][k];

        memo[n][k] = calculateBinomial(n - 1, k, memo) + calculateBinomial(n - 1, k - 1, memo);
        return memo[n][k];
    }

    public static boolean isSorted(int[] arr) {
    if (arr.length <= 1) {
        return true;
    }

    for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i] > arr[i + 1]) { 
            return false; 
        }
    }

    return true; 
}
    public static String intToBin(int n) {
        if (n == 0) return "0";
        String bin = "";
        while (n > 0) {
            bin = (n % 2) + bin;
            n = n / 2;
        }
        return bin;
    }

}