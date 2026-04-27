// This script will write and implement the dynamic programming coin change algorithm

// define our DPCoinChange class
public class DPCoinChange {

    // define method containing the algorithm's main logic
    public static int dpCoinChange(int[] D, int n) {

        // initialize min array, fill with inf, and m
        int inf = Integer.MAX_VALUE;
        int[] min = new int[n + 1];
        int m = D.length;

        // intitialize min[0] = 0
        min[0] = 0;

        // start outer loop
        for (int i = 1; i <= n; i++) {
            min[i] = inf;

            for (int j = 0; j <= m - 1; j++) {
                if (i >= D[j]) {
                    if (min[i - D[j]] + 1 < min[i]) {
                        min[i] = min[i - D[j]] + 1;
                    }
                }
            }
        } 

        // return our desired value
        return min[n];
    }

    // define our main method to test our algorithm
    public static void main(String[] args) {
        // initialize our inputs
        int[] D = {1, 3, 4, 5};
        int n = 6;

        // use our DP method get our result and print it out
        int result = dpCoinChange(D, n);
        System.out.println(result);
    }
}