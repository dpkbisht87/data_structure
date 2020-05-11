package com.practice.dp;

public class EditDistance {

    public static int editDistanceRecursive(String s1, String s2, int n, int m){
        if(s1 == s2){
            return 0;
        }
        if(n == 0){
            return m;
        }
        if(m == 0){
            return n;
        }

        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return editDistanceRecursive(s1, s2, n-1, m-1);
        }else{
            return 1 + Math.min(editDistanceRecursive(s1, s2, n -1, m), Math.min(editDistanceRecursive(s1, s2, n, m-1), editDistanceRecursive(s1, s2, n -1, m-1)));
        }

    }

    public static int editDistanceBottomUp(String s1, String s2, int n, int m) {

        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }

        int[][] arr = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            arr[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            arr[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    arr[i][j] = arr[i - 1][j - 1];
                } else {
                    arr[i][j] = 1 + Math.min(arr[i - 1][j], Math.min(arr[i][j - 1], arr[i - 1][j - 1]));
                }
            }
        }
        return arr[m][n];
    }

    public static void main(String[] args) {
        String s1 = "abd";
        String s2 = "bcd";

        System.out.println(EditDistance.editDistanceRecursive(s1, s2, s1.length(), s2.length()));
        System.out.println(EditDistance.editDistanceBottomUp(s1, s2, s1.length(), s2.length()));

    }
}
