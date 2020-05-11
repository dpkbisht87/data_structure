package com.practice.dp;

public class CountOfSubsetSum {
    
    public static int countSubsetsWithSumEqualToGivenSum(int[] arr, int sum){
        if(arr.length == 0 || sum <= 0){
            return 0;
        }
        
        int[][] mat = new int[arr.length][sum + 1];
        
        for(int i = 0; i < arr.length; i++){
            mat[i][0] = 1;
        }
        
        for(int j = 0;j <= sum; j++){
            if(arr[0] == j){
                mat[0][j] = 1;
            }
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j <= sum; j++){
                int includeCurrent = 0;
                int excludeCurrent = 0;
                
                if(arr[i] <= j){
                    includeCurrent = mat[i - 1][j - arr[i]];
                }
                
                if(i > 0){
                    excludeCurrent = mat[i - 1][j];
                }
                mat[i][j] = includeCurrent + excludeCurrent;
            }
        }
        return mat[arr.length - 1][sum];
    }
    
    
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 1, 4, 5};
        int sum = 7;
    
        System.out.println(CountOfSubsetSum.countSubsetsWithSumEqualToGivenSum(arr, sum));
    
    }
}
