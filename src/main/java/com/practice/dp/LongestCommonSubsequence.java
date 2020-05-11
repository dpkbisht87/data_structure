package com.practice.dp;

public class LongestCommonSubsequence {

    public int lcs(String s1, String s2, int n, int m) {

        if (n == 0 || m == 0) {
            return 0;
        } else if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + lcs(s1, s2, n - 1, m - 1);
        }
        return Math.max(lcs(s1, s2, n - 1, m), lcs(s1, s2, n, m - 1));
    }


    public int lcsTopDown(String s1, String s2, int n, int m, Integer[][] arr) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (arr[n][m] == null) {
            if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
                arr[n][m] = 1 + lcsTopDown(s1, s2, n - 1, m - 1, arr);
            } else {
                arr[n][m] = Math.max(lcsTopDown(s1, s2, n - 1, m, arr), lcsTopDown(s1, s2, n, m - 1, arr));
            }

        }
        return arr[n][m];
    }

    public int lcsBottomUp(String s1, String s2, int n, int m) {

        if (n == 0 || m == 0) {
            return 0;
        }

        int[][] arr = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
                }
            }
        }
        return arr[m][n];
    }


    public static void main(String[] args) {
        String s1 = "abde";
        String s2 = "acd";
        LongestCommonSubsequence lcsApp = new LongestCommonSubsequence();
        System.out.println(lcsApp.lcs(s1, s2, s1.length(), s2.length()));

        Integer[][] arr = new Integer[s1.length() + 1][s2.length() + 1];
        System.out.println(lcsApp.lcsTopDown(s1, s2, s1.length(), s2.length(), arr));

        System.out.println(lcsApp.lcsBottomUp(s1, s2, s1.length(), s2.length()));
    }
}
