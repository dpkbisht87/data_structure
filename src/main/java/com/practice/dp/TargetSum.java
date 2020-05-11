package com.practice.dp;

public class TargetSum {
    public static int ifTargetSumExists(int[] arr, int sum){
        if(arr.length == 0){
            return 0;
        }
        int sumOfElements = 0;
        for(int i: arr){
            sumOfElements += i;
        }
        
        if(sum > sumOfElements || (sumOfElements + sum) % 2 != 0){
            return 0;
        }
        int sumToCheck = (sum + sumOfElements) / 2;
        return countSubsetsWithSumEqualToGivenSum(arr, sumToCheck);
    }
    
    private static int countSubsetsWithSumEqualToGivenSum(int[] arr, int sumToCheck){
        if(arr.length == 0){
            return 0;
        }
        
        int[][] mat = new int[arr.length][sumToCheck + 1];
        
        for(int i = 0; i <arr.length; i++){
            mat[i][0] = 1;
        }
        
        for(int j = 0; j <= sumToCheck; j++){
            if(arr[0] == j){
                mat[0][j] = 1;
            }
        }
    
        for(int i = 1; i <arr.length; i++) {
            for (int j = 1; j <= sumToCheck; j++) {
                int includeCurrent = 0;
                int excludeCurrent = 0;
    
                if (arr[i] <= j) {
                    includeCurrent = mat[i - 1][j - arr[i]];
                }
                excludeCurrent = mat[i - 1][j];
    
                mat[i][j] = includeCurrent + excludeCurrent;
            }
        }
        return mat[arr.length - 1][sumToCheck];
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3};
        int sum = 3;
    
        System.out.println(TargetSum.ifTargetSumExists(arr, sum));
    
    }
}
