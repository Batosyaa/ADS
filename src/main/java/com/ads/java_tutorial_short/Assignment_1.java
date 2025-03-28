package com.ads.java_tutorial_short;

public class Assignment_1 {

    // O(n)
    public static int probOne(int[] array, int n) {
        // Base Case
        if (n == 1) {
            return array[0];
        }

        return Math.min(array[n - 1], probOne(array, n - 1));
    }

    // O(n)
    public static double probTwo(int n, int[] array) {
        if (n == 1) {
            return array[0];
        }

        return (array[n - 1] + (n - 1) * probTwo(n - 1, array)) / n;
    }

    // O(n)
    public static boolean probThree(int n, int i) {
        // Base case
        if (n <= 1) {
            return false;
        }
        if (i == 1) {
            return true;
        }
        if (n % i == 0) {
            return false;
        }

        return probThree(n, i - 1);
    }

    // O(n)
    public static long probFour(int n) {
        // base case
        if (n <= 1) {
            return 1;
        }
        return n * probFour(n - 1);
    }

    // O(2^n)
    public static long probFive(int n) {
        if (n <= 1) {
            return 1;
        }
        return probFive(n - 1) * probFive(n - 2);
    }

    // O(n)
    public static long probSix(int n, int a) {
        // base case
        if (n == 0) {
            return 1;
        }

        // recursive case
        return a * probSix(n - 1, a);
    }

    // O(n!)
    public static void probSeven(String TestString, String ExceptionString) {
        if (TestString.isEmpty()) {
            System.out.println(ExceptionString);
            return;
        }
        
        for (int i = 0; i < TestString.length(); i++) {
            char ChosenC = TestString.charAt(i);

            String Remaining = TestString.substring(0, i) + TestString.substring(i + 1);

            probSeven(Remaining, ExceptionString + ChosenC);
        }
    }

    // O(n)
    public static boolean probEight(String TestString, int index) {
        // base case
        if (index == TestString.length()) {
            return true;
        }

        if (Character.isDigit(TestString.charAt(index))) {
            return false;
        }

        return probEight(TestString, index + 1); // index must always be put as 0 to check each char!!!
    }

    // O(2^n)
    public static int probNine(int n, int k) {
        // base case
        if (k == 0 || k == n) {
            return 1;
        }

        // recursive case
        return probNine(n - 1, k - 1) + probNine(n - 1, k);
    }

    // O(log(min(a, b)))
    public static int probTen(int a, int b) {
        // base case
        if (b == 0) {
            return a;
        }

        return probTen(a, a % b);
    }
    }
