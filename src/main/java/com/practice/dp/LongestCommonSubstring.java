package com.practice.dp;

public class LongestCommonSubstring {

    public int lcsubstring(String s1, String s2, int n, int m, int countOfLcs){
        if(n == 0 || m == 0){
            return countOfLcs;
        }

        if(s1.charAt(n - 1) == s2.charAt(m - 1)){
            countOfLcs = lcsubstring(s1, s2, n -1, m -1, countOfLcs + 1);
        }

        int count1 = lcsubstring(s1, s2, n -1, m, 0);
        int count2 = lcsubstring(s1, s2, n, m -1, 0);

        return Math.max(countOfLcs, Math.max(count1, count2));
    }

    public int lcsubStringBottomUp(String s1, String s2, int n, int m){
        int[][] arr = new int[n +1][m +1];
        int maxLcs = 0;
        for (int i = 1; i <= n; i++){
            for( int j = 1; j <= m; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1 )){
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                    maxLcs = Math.max(maxLcs, arr[i][j]);
                }else{
                    arr[i][j] = 0;
                }

            }
        }
        return maxLcs;
    }

    public static void main(String[] args) {
        String s1 = "abd";
        String s2 = "abca";


        LongestCommonSubstring lcsApp = new LongestCommonSubstring();
        System.out.println(lcsApp.lcsubstring(s1, s2, s1.length(), s2.length(), 0));

        System.out.println(lcsApp.lcsubStringBottomUp(s1, s2, s1.length(), s2.length()));
    }
}
