package com.practice.dp;

public class LongestPallindromeSubsequence2 {

    public static int lpsIterativeWay(String str, int start, int end){
        if(str == null){
            return 0;
        }
        if(start == end){
            return 1;
        }
        if(start > end){
            return 0;
        }
        if(str.charAt(start) == str.charAt(end)){
            return 2 + lpsIterativeWay(str, start + 1, end - 1);
        }else {
            return Math.max(lpsIterativeWay(str, start + 1, end), lpsIterativeWay(str, start, end - 1));
        }
    }

    public static int lpsTopDown(String str, int start, int end, Integer[][] arr){
        if(str == null){
            return 0;
        }
        if(start == end){
            return 1;
        }
        if(start > end){
            return 0;
        }
        if( arr[start][end] == null){
            if(str.charAt(start) == str.charAt(end)){
                arr[start][end] = 2 + lpsTopDown(str, start + 1, end - 1, arr);
            }else{
                arr[start][end] = Math.max(lpsTopDown(str, start + 1, end, arr), lpsTopDown(str, start, end - 1, arr));
            }
        }
        return arr[start][end];
    }

    public static int lpsBottomUp(String str, int n){
        int[][] arr = new int[n][n];
        for(int i = 0; i< n; i++){
            for(int j = 0;j < n; j++){
                arr[i][j] = 1;
            }
        }
        
        for(int i = n - 2; i >= 0; i--){
            for(int j = i + 1; j< n; j++){
                if(str.charAt(i) == str.charAt(j)){
                    arr[i][j] = 2 + arr[i + 1][j - 1];
                } else {
                    arr[i][j] = Math.max(arr[i + 1][j], arr[i][j - 1]);
                }
            }
        }
        return arr[0][n - 1];
    }

    public static void main(String[] args) {
        String str = "abefbac";
        System.out.println(LongestPallindromeSubsequence2.lpsIterativeWay(str, 0, str.length() - 1));

        Integer[][] arr = new Integer[str.length()][str.length()];
        System.out.println(LongestPallindromeSubsequence2.lpsTopDown(str, 0, str.length() - 1, arr));


        System.out.println(LongestPallindromeSubsequence2.lpsBottomUp(str, str.length()));


    }
}
