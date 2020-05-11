package com.practice.dp;

import java.util.Arrays;
import java.util.List;

public class MaxSumArrayNonConsecutiveElements {
    
    public static int maxSum(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        if(arr[0]> arr[1]){
            dp[1] = arr[0];
        }else{
            dp[1] = arr[1];
        }
        for(int i = 2; i < arr.length; i++){
            int includeCurrentValue = dp[i - 2] + arr[i];
            int excludeCurrentValue = dp[i - 1];
            dp[i] = Math.max(includeCurrentValue, excludeCurrentValue);
        }
        for(int item: dp){
            System.out.println(item);
        }
        return dp[arr.length - 1];
    }
    
    public static void main(String[] args) {
        int[] arr = { 4, 2, 3, 5, 1, 6, 7 };
        System.out.println(MaxSumArrayNonConsecutiveElements.maxSum(arr));
    }
}
