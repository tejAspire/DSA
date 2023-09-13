//Design and implement C++/Java Program to find a subset of a given set S = {Sl, S2,…, Sn} of n positive integers whose SUM is equal to a given positive integer d. For example, if S = {1, 2, 5, 6, 8} and d= 9, there are two solutions {1, 2, 6} and {1, 8}. Display a suitable message, if the given problem instance doesn't have a solution.

import java.util.Scanner;

public class SumOfSubsets {
    int[] w;
    int[] x;
    int sum;
    int total = 0;

    public void process() {
        getData();
        System.out.println("The subsets are:");
        subset(0, 1, total);
    }

    private void getData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements:");
        int n = sc.nextInt();
        w = new int[n + 1];
        x = new int[n + 1];
        System.out.println("Enter " + n + " Elements :");
        for (int i = 1; i < n + 1; i++) {
            w[i] = sc.nextInt();
            total += w[i];
        }
        System.out.println("Enter the sum to be obtained: ");
        sum = sc.nextInt();
        if (total < sum) {
            System.out.println("No possible subsets!!!");
            System.exit(1);
        }
        sc.close();
    }

    private void subset(int s, int k, int r) {
        int i = 0;
        x[k] = 1;
        if (s + w[k] == sum) {
            System.out.print("(");
            for (i = 1; i <= k; i++) {
                if (x[i] == 1)
                    System.out.print(" " + w[i]);
            }
            System.out.println(" )");
        } else if ((s + w[k] + w[k + 1]) <= sum) {
            subset(s + w[k], k + 1, r - w[k]);
        }
        if ((s + r - w[k]) >= sum && (s + w[k + 1]) <= sum) {
            x[k] = 0;
            subset(s, k + 1, r - w[k]);
        }
    }

    public static void main(String[] args) {
        new SumOfSubsets().process();
    }
}
