import java.util.*;

public class Fibonacci {

    // Iterative approach
    //time O(n)  space O(1)
    public static void fibonacci1(int n) {
        if (n == 0) {
            System.out.println("Term is: 0");
            return;
        }
        if (n == 1) {
            System.out.println("Term is: 1");
            return;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        System.out.println("Term is: " + b);
    }

    // Recursive approach
    //time O(2^n)  space O(n)
    public static int fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci2(n - 1) + fibonacci2(n - 2);
    }

    // Dynamic programming approach
    //time O(n)  space O(n)
    public static int fibonacci3(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = fibonacci3(n - 1, dp) + fibonacci3(n - 2, dp);
        return dp[n];
    }

    // Main method to test the Fibonacci functions
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter term you want: ");
        int n = sc.nextInt();

        // Iterative approach
        System.out.print("Iterative approach: ");
        fibonacci1(n);

        // Recursive approach
        System.out.println("Recursive approach: Term is " + fibonacci2(n));

        // Dynamic programming approach
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Dynamic programming approach: Term is " + fibonacci3(n, dp));

        sc.close();
    }
}
